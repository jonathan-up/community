package cn.j0n4than.ex.community.handlers;

import cn.j0n4than.ex.community.magic.HttpServletRequestEx;
import cn.j0n4than.ex.community.magic.HttpServletResponseEx;
import cn.j0n4than.ex.community.pojo.Page;
import cn.j0n4than.ex.community.pojo.ResponseEntity;
import cn.j0n4than.ex.community.pojo.vo.BuildingVo;
import cn.j0n4than.ex.community.services.BuildingService;
import cn.j0n4than.ex.community.services.UploadService;
import cn.j0n4than.ex.community.services.impl.BuildingServiceImpl;
import cn.j0n4than.ex.community.services.impl.FilesystemUploadServiceImpl;

// 小区
public class BuildingHandler {

    private final static BuildingService buildingService = new BuildingServiceImpl();
    private final static UploadService uploaderService = new FilesystemUploadServiceImpl();

    // page list
    public static void page(HttpServletRequestEx request, HttpServletResponseEx response) {
        Integer current = request.getParameterInt("page", 1);
        Integer size = request.getParameterInt("size", 10);
        String name = request.getParameter("name");

        Page<BuildingVo> page = buildingService.findPage(name, current, size);
        response.json(200, new ResponseEntity<>("OK", page));
    }

    // get one
//    public static void one(HttpServletRequestEx request, HttpServletResponseEx response) {
//        Integer id = request.getParameterInt("id");
//        if (id == null) {
//            throw new HandlerException(400, "Invalid id", null);
//        }
//
//        Village one = villageService.findOne(id);
//        if (one == null) {
//            throw new HandlerException(404, "Record not found", null);
//        }
//
//        response.json(200, new ResponseEntity<>("OK", one));
//    }

    // create or update
//    public static void save(HttpServletRequestEx request, HttpServletResponseEx response) {
//
//        Village bind = request.bind(Village.class);
//        bind.setCreated(new Date());
//        if (bind.getId() == null) {
//            // create
//            ArrayList<Village> villages = new ArrayList<>();
//            villages.add(bind);
//            if (villageService.insert(villages) > 0) {
//                response.json(200, new ResponseEntity<>("添加成功"));
//                return;
//            }
//
//            response.json(500, new ResponseEntity<>("添加失败"));
//            return;
//        }
//
//        // update
//        if (villageService.update(bind) > 0) {
//            response.json(200, new ResponseEntity<>("更新成功"));
//            return;
//        }
//        response.json(500, new ResponseEntity<>("更新失败"));
//    }

    // delete
//    public static void del(HttpServletRequestEx request, HttpServletResponseEx response) {
//        DeleteRequest deleteRequest = request.bind(DeleteRequest.class);
//        ArrayList<Object> ids = deleteRequest.getIds();
//
//        int count = villageService.del(ids);
//        response.json(200, new ResponseEntity<>(String.format("成功删除%d条记录", count), ids));
//    }
}
