package com.example.demo.util;


import lombok.extern.slf4j.Slf4j;


@Slf4j
public class LoginContext {

    private static final ThreadLocal<LoginContext> holder = new ThreadLocal();
    private String pin;

    public LoginContext() {
    }

    public String getPin() {
        return this.pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }


    public static void setLoginContext(LoginContext loginContext) {
        holder.set(loginContext);
    }

    public static LoginContext getLoginContext() {
        return (LoginContext)holder.get();
    }

    public static void remove() {
        holder.remove();
    }

}
