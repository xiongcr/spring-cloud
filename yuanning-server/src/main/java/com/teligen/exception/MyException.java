package com.teligen.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MyException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    private Integer code;
    private String message;
}
