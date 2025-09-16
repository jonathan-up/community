package cn.j0n4than.ex.community.pojo.entities;

import cn.idev.excel.annotation.ExcelIgnore;
import cn.idev.excel.annotation.ExcelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class Village {
    @ExcelProperty(index = 0)
    private Long id;

    @ExcelProperty(index = 1)
    private String code;

    @ExcelProperty(index = 2)
    private String name;

    @ExcelProperty(index = 7)
    private String property;

    @ExcelProperty(index = 3)
    private String address;

    @ExcelProperty(index = 4)
    private int totalBuildings;

    @ExcelProperty(index = 5)
    private int totalHouseholds;

    @ExcelProperty(index = 6)
    private String image;

    @ExcelIgnore
    private String phone;

    @ExcelProperty(index = 8)
    private Date created;
}
