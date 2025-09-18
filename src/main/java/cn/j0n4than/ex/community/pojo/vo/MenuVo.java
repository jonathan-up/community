package cn.j0n4than.ex.community.pojo.vo;

import cn.j0n4than.ex.community.pojo.entities.Menu;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Data
public class MenuVo extends Menu {
    private List<Menu> children = new ArrayList<>();

    public MenuVo(Menu menu) {
        this.setId(menu.getId());
        this.setTitle(menu.getTitle());
        this.setIcon(menu.getIcon());
        this.setType(menu.getType());
        this.setHref(menu.getHref());
        this.setPid(menu.getPid());
        this.setOpenType(menu.getOpenType());
    }
}
