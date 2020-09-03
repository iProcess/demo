
package com.example.demo.test.exception;

public class ClientTimeoutException extends RpcException {
    private static final long serialVersionUID = -3008927155169307876L;

    protected ClientTimeoutException() {
    }

    public ClientTimeoutException(String errorMsg) {
        super(errorMsg);
    }

    public ClientTimeoutException(String errorMsg, Throwable throwable) {
        super(errorMsg, throwable);
    }
}
