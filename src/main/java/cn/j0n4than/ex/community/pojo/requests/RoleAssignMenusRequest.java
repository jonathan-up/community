package cn.j0n4than.ex.community.pojo.requests;

import lombok.Data;

import java.util.List;

@Data
public class RoleAssignMenusRequest {
    private Integer id;
    private List<Integer> menus;
}
