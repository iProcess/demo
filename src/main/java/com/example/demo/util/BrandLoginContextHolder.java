package com.example.demo.util;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BrandLoginContextHolder {
    private static final ThreadLocal<WebHelper> BRAND_LOGIN_CONTEXT_THREAD_LOCAL = new ThreadLocal();
    public static void setLoginBrandInfo(WebHelper webHelper) {
        BRAND_LOGIN_CONTEXT_THREAD_LOCAL.set(webHelper);
        log.debug("BrandLoginContextHolder.setLoginContext done.");
    }

    public static WebHelper getLoginBrandInfo() {
        return (WebHelper)BRAND_LOGIN_CONTEXT_THREAD_LOCAL.get();
    }

    public static void removeLoginBrandInfo() {
        BRAND_LOGIN_CONTEXT_THREAD_LOCAL.remove();
        log.debug("BrandLoginContextHolder.removeLoginContext done.");
    }
}
