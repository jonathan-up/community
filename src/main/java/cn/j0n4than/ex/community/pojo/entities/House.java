package cn.j0n4than.ex.community.pojo.entities;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class House {
    private Integer id;
    private Integer buildingId;
    private String houseNo;
    private String name;
    private Double area;
    private Integer layer;
    private String toward;
    private String type;
    private String usage;
    private String fitment;
    private String person;
    private String perPhone;
}
