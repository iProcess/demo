package com.example.demo.exception;

import java.io.Serializable;

public class RpcException extends RuntimeException implements Serializable {
    private static final long serialVersionUID = 7772360050382788166L;
    private int errorCode = 2;
    protected String errorMsg;
    private transient MessageHeader msgHeader;

    protected RpcException() {
    }

    public RpcException(MessageHeader header, Throwable e) {
        super(e);
        this.msgHeader = header;
    }

    public RpcException(MessageHeader header, String errorMsg) {
        super(errorMsg);
        this.msgHeader = header;
        this.errorMsg = errorMsg;
    }

    public RpcException(MessageHeader header, int errorCode, String errorMsg) {
        super(errorMsg);
        this.msgHeader = header;
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    protected RpcException(Throwable e) {
        super(e);
    }

    public RpcException(String errorMsg) {
        super(errorMsg);
        this.errorMsg = errorMsg;
    }

    public RpcException(String errorMsg, Throwable e) {
        super(errorMsg, e);
        this.errorMsg = errorMsg;
    }

    public MessageHeader getMsgHeader() {
        return this.msgHeader;
    }

    public void setMsgHeader(MessageHeader msgHeader) {
        this.msgHeader = msgHeader;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String toString() {
        String s = this.getClass().getName();
        String message = this.errorMsg;
        return message != null ? s + ": " + message : s;
    }
}
