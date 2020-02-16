package com.example.demo.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;

public class CommonUtils {
    private static final Logger logger = LoggerFactory.getLogger(CommonUtils.class);

    public CommonUtils() {
    }

    public static boolean isWindows() {
        boolean flag = Boolean.FALSE;
        String osName = System.getProperty("os.name").toLowerCase();
        logger.debug("osName::{}", osName);
        if (osName.indexOf("windows") >= 0) {
            flag = Boolean.TRUE;
        }

        return flag;
    }

    public static Boolean isLinux() {
        boolean flag = Boolean.FALSE;
        String osName = System.getProperty("os.name").toLowerCase();
        logger.debug("osName::{}", osName);
        if (osName.indexOf("linux") >= 0) {
            flag = Boolean.TRUE;
        }

        return flag;
    }

    public static byte[] copyOf(byte[] src, int length) {
        byte[] dest = new byte[length];
        System.arraycopy(src, 0, dest, 0, Math.min(src.length, length));
        return dest;
    }

    public static <K, V> V putToConcurrentMap(ConcurrentMap<K, V> map, K key, V value) {
        V old = map.putIfAbsent(key, value);
        return old != null ? old : value;
    }

    public static boolean isTrue(String b) {
        return b != null && "true".equalsIgnoreCase(b);
    }

    public static boolean isTrue(Boolean b) {
        return b != null && b;
    }

    public static boolean isFalse(Boolean b) {
        return b != null && !b;
    }

    public static boolean isFalse(String b) {
        return b != null && "false".equalsIgnoreCase(b);
    }

    public static boolean isEmpty(Collection collection) {
        return collection == null || collection.isEmpty();
    }

    public static boolean isNotEmpty(Collection collection) {
        return collection != null && !collection.isEmpty();
    }

    public static boolean isEmpty(Map map) {
        return map == null || map.isEmpty();
    }

    public static boolean isNotEmpty(Map map) {
        return map != null && !map.isEmpty();
    }

    public static boolean isEmpty(Object[] array) {
        return array == null || array.length == 0;
    }

    public static boolean isNotEmpty(Object[] array) {
        return array != null && array.length > 0;
    }

    public static int parseInt(String num, int defaultInt) {
        if (num == null) {
            return defaultInt;
        } else {
            try {
                return Integer.parseInt(num);
            } catch (Exception var3) {
                return defaultInt;
            }
        }
    }

    public static int[] parseInts(String nums, String sperator) {
        String[] ss = StringUtils.split(nums, sperator);
        int[] ints = new int[ss.length];

        for(int i = 0; i < ss.length; ++i) {
            ints[i] = Integer.parseInt(ss[i]);
        }

        return ints;
    }


}
