package cn.j0n4than.ex.community.handlers;

import cn.j0n4than.ex.community.exceptions.HandlerException;
import cn.j0n4than.ex.community.magic.HttpServletRequestEx;
import cn.j0n4than.ex.community.magic.HttpServletResponseEx;
import cn.j0n4than.ex.community.pojo.Page;
import cn.j0n4than.ex.community.pojo.ResponseEntity;
import cn.j0n4than.ex.community.pojo.entities.House;
import cn.j0n4than.ex.community.pojo.requests.DeleteRequest;
import cn.j0n4than.ex.community.pojo.vo.HouseVo;
import cn.j0n4than.ex.community.services.HouseService;
import cn.j0n4than.ex.community.services.impl.HouseServiceImpl;

import java.util.ArrayList;

// 房产
public class HouseHandler {

    private final static HouseService houseService = new HouseServiceImpl();

    // page list
    public static void page(HttpServletRequestEx request, HttpServletResponseEx response) {
        Integer current = request.getParameterInt("page", 1);
        Integer size = request.getParameterInt("size", 10);
        HouseVo condition = request.bindParameter(HouseVo.class);

        Page<HouseVo> page = houseService.findPage(condition, current, size);
        response.json(200, new ResponseEntity<>("OK", page));
    }

    // get one
    public static void one(HttpServletRequestEx request, HttpServletResponseEx response) {
        Integer id = request.getParameterInt("id");
        if (id == null) {
            throw new HandlerException(400, "Invalid id", null);
        }

        House one = houseService.findOne(id);
        if (one == null) {
            throw new HandlerException(404, "Record not found", null);
        }

        response.json(200, new ResponseEntity<>("OK", one));
    }

    // create or update
    public static void save(HttpServletRequestEx request, HttpServletResponseEx response) {

        House bind = request.bind(House.class);
        if (bind.getId() == null) {
            // create
            ArrayList<House> data = new ArrayList<>();
            data.add(bind);
            if (houseService.insert(data) > 0) {
                response.json(200, new ResponseEntity<>("添加成功"));
                return;
            }

            response.json(500, new ResponseEntity<>("添加失败"));
            return;
        }

        // update
        if (houseService.update(bind) > 0) {
            response.json(200, new ResponseEntity<>("更新成功"));
            return;
        }
        response.json(500, new ResponseEntity<>("更新失败"));
    }

    // delete
    public static void del(HttpServletRequestEx request, HttpServletResponseEx response) {
        DeleteRequest deleteRequest = request.bind(DeleteRequest.class);
        ArrayList<Object> ids = deleteRequest.getIds();

        int count = houseService.del(ids);
        response.json(200, new ResponseEntity<>(String.format("成功删除%d条记录", count), ids));
    }
}
