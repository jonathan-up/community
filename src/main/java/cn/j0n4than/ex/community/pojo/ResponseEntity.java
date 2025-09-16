package cn.j0n4than.ex.community.pojo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ResponseEntity<T> {
    private String message;
    private T result;

    public ResponseEntity(String msg, T result) {
        this.message = msg;
        this.result = result;
    }

    public ResponseEntity(String msg) {
        this(msg, null);
    }
}
