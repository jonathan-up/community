package cn.j0n4than.ex.community.pojo.entities;

import lombok.Data;

@Data
public class Role {
    private Integer id;
    private String name;
    private Integer status;
    private String description;
}
