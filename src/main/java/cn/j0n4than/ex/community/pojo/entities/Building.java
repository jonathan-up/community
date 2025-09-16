package cn.j0n4than.ex.community.pojo.entities;

import lombok.Data;

@Data
public class Building {
    private Integer id;
    private String name;
    private String period;
    private boolean lift;
    private Integer villageId;
}
