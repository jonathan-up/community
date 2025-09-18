package cn.j0n4than.ex.community.pojo.entities;

import lombok.Data;

import java.util.Date;

@Data
public class RoleUser {
    private Integer id;
    private Integer uid;
    private Integer rid;
    private Date created;
}
