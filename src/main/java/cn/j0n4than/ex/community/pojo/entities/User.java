package cn.j0n4than.ex.community.pojo.entities;

import lombok.Data;

@Data
public class User {
    private Integer id;
    private String username;
    private String pwd;
    private String salt;
}
