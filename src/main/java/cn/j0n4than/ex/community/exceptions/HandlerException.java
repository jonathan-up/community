package cn.j0n4than.ex.community.exceptions;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class HandlerException extends RuntimeException {

    private int httpStatus;
    private Object result;

    public HandlerException(int httpStatus, String message, Object result) {
        super(message);
        this.httpStatus = httpStatus;
        this.result = result;
    }
}
