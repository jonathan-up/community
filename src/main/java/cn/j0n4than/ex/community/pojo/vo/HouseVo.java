package cn.j0n4than.ex.community.pojo.vo;

import cn.j0n4than.ex.community.pojo.entities.House;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class HouseVo extends House {
    // private Integer buildingId;  // it in House

    private String buildingName;

    private Integer villageId;

    private String villageName;
}
