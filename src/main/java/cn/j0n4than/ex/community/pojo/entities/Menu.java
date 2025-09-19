package cn.j0n4than.ex.community.pojo.entities;

import lombok.Data;

@Data
public class Menu {
    private Integer id;
    private String title;
    private String icon;
    private Integer type;
    private String href;
    private Integer pid;
    private String openType;
    private Integer status;
}
