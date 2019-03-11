package com.zdy.biz.redis.config;


import lombok.NonNull;


public class RedisKey {


    private final static String prefix = "CACHE";


    public static String generateKey(String lastKey) {
        return prefix.concat(":").concat(lastKey);
    }

    public static String toKey(@NonNull String... keys) {
        StringBuffer buffer = new StringBuffer();
        for (String key : keys) {
            buffer.append(key).append(":");
        }
        return buffer.subSequence(0, buffer.length() - 1).toString().toUpperCase();
    }

    public static StringBuffer getKey(@NonNull String root) {
        return new StringBuffer(root.toUpperCase()).append(":");
    }

    public static String classKey(@NonNull String root, @NonNull Class<?> clzss) {
        return getKey(getReplaceKey(root)).append(clzss.getSimpleName().toUpperCase()).toString().toUpperCase();
    }

    public static String classKey(@NonNull String root, @NonNull Class<?> clzss, @NonNull String key) {
        return getKey(getReplaceKey(root)).append(clzss.getSimpleName().toUpperCase()).append(":").append(key).toString().toUpperCase();
    }

    public static String toReplaceKey(@NonNull String... keys) {
        StringBuffer buffer = new StringBuffer();
        for (String key : keys) {
            buffer.append(getReplaceKey(key)).append(":");
        }
        return buffer.subSequence(0, buffer.length() - 1).toString().toUpperCase();
    }

    public static String getReplaceKey(@NonNull String varietyCode) {
        return varietyCode.replaceAll("_", ":");
    }

    public static String getKey(@NonNull String commodity, @NonNull String currency) {
        return commodity.concat(":").concat(currency).toUpperCase();
    }

    public static String getKey(@NonNull String exchange, @NonNull String commodity, @NonNull String currency) {
        return exchange.concat(":").concat(getKey(commodity, currency)).toUpperCase();
    }
}
