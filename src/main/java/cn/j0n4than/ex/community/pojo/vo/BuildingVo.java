package cn.j0n4than.ex.community.pojo.vo;

import cn.j0n4than.ex.community.pojo.entities.Building;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class BuildingVo extends Building {

    private String villageName;
    private String property;
}
