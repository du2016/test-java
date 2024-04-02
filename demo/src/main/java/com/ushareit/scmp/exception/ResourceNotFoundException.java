package com.ushareit.scmp.exception;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException() {
        super();
    }

    public ResourceNotFoundException(String message) {
        super(message);
    }

    // 可以根据需要添加其他构造函数和方法

}

