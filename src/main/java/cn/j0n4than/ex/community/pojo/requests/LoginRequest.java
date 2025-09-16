package cn.j0n4than.ex.community.pojo.requests;

import lombok.Data;

@Data
public class LoginRequest {
    private String username;
    private String password;
}
