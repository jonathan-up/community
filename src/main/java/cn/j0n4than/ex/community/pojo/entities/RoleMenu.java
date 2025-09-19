package cn.j0n4than.ex.community.pojo.entities;

import lombok.Data;

import java.util.Date;

@Data
public class RoleMenu {
    private Integer id;
    private Integer mid;
    private Integer rid;
    private Date created;
}
