package com.zdy.util;


import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Objects;
import java.util.UUID;

/**
 * 获取客户端网络信息的工具
 */
@Slf4j
public class NetUtil {
    public static String getLocalHost() {
        InetAddress ia = null;
        try {
            ia = InetAddress.getLocalHost();
            log.warn("当前HOST==={}", ia);
        } catch (Exception e1) {

            e1.printStackTrace();
            return UUID.randomUUID().toString();
        }
        return ia.toString();
    }

    public static String getLocalMac() {
        InetAddress ia = null;
        try {
            ia = InetAddress.getLocalHost();
            log.warn("当前HOST==={}", ia);
        } catch (Exception e1) {
            e1.printStackTrace();
            return UUID.randomUUID().toString();
        }

        try {
            /**下边这行代码只适用于windows系统，linux下无效**/
            //byte[] mac = NetworkInterface.getByInetAddress(ia).getHardwareAddress();
            String localMac = null;
            if (Objects.isNull(ia)) {
                /**尝试获取linux系统的MAC地址**/
                localMac = getLinuxMACAddress();
            } else {
                NetworkInterface networkInterface = NetworkInterface.getByInetAddress(ia);
                if (networkInterface == null || networkInterface.getHardwareAddress() == null) {
                    /**尝试获取linux系统的MAC地址**/
                    localMac = getLinuxMACAddress();
                } else {
                    /**继续按照原有逻辑处理**/
                    byte[] mac = networkInterface.getHardwareAddress();
                    StringBuffer sb = new StringBuffer();
                    for (int i = 0; i < mac.length; i++) {
                        if (i != 0) {
                            sb.append("-");
                        }
                        // 字节转换为整数
                        int temp = mac[i] & 0xff;
                        String str = Integer.toHexString(temp);
                        if (str.length() == 1) {
                            sb.append("0" + str);
                        } else {
                            sb.append(str);
                        }
                    }
                    localMac = sb.toString().toUpperCase();
                }
            }
            log.warn("当前MAC==={}", localMac);
            return localMac;
        } catch (Exception e) {
            e.printStackTrace();
            return UUID.randomUUID().toString();
        }
    }


    /**
     * 获取linux系统的MAC地址
     * add by kwan 2018-03-01
     *
     * @return
     */
    private static String getLinuxMACAddress() {

        final int MAC_ADDR_LENGTH = 17;
        /**MAC信息存在以下两种方式**/
        final String KEYWORDS_HWADDR = "HWADDR", KEYWORDS_ETHER = "ETHER";

        String mac = null;
        BufferedReader bufferedReader = null;
        Process process = null;
        try {
            /**linux下一般取eth0作为本地的主网卡，信息中包含mac地址**/
            process = Runtime.getRuntime().exec("ifconfig eth0");
            bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line = null;
            int index = -1;
            while ((line = bufferedReader.readLine()) != null) {
                index = line.toUpperCase().indexOf(KEYWORDS_HWADDR);
                if (index >= 0) {
                    mac = line.substring(index + KEYWORDS_HWADDR.length() + 1).trim();
                    break;
                } else {
                    index = line.toUpperCase().indexOf(KEYWORDS_ETHER);
                    if (index >= 0) {
                        mac = line.substring(index + KEYWORDS_ETHER.length() + 1).trim();
                        break;
                    }
                }
            }
        } catch (Exception e) {
        } finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            } catch (Exception ioe) {
            }
            bufferedReader = null;
            process = null;
        }
        return mac == null ? UUID.randomUUID().toString() : mac.length() == MAC_ADDR_LENGTH ? mac : mac.substring(0, MAC_ADDR_LENGTH);
    }

    /**
     * 获取请求主机IP地址,如果通过代理进来，则透过防火墙获取真实IP地址;
     *
     * @param request
     * @return
     * @throws IOException
     */
    public final static String getClientIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("X-forwarded-for");

        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            if (ip == null || ip.length() == 0
                    || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("Proxy-Client-IP");
            }
            if (ip == null || ip.length() == 0
                    || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("WL-Proxy-Client-IP");
            }
            if (ip == null || ip.length() == 0
                    || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("HTTP_CLIENT_IP");
            }
            if (ip == null || ip.length() == 0
                    || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("HTTP_X_FORWARDED_FOR");
            }
            if (ip == null || ip.length() == 0
                    || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getRemoteAddr();
            }
        } else if (ip.length() > 15) {
            String[] ips = ip.split(",");
            for (int index = 0; index < ips.length; index++) {
                String strIp = ips[index];
                if (!("unknown".equalsIgnoreCase(strIp))) {
                    ip = strIp;
                    break;
                }
            }
        }
        return ip;
    }
}
