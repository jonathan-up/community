package cn.j0n4than.ex.community.handlers;

import cn.idev.excel.FastExcel;
import cn.idev.excel.context.AnalysisContext;
import cn.idev.excel.read.listener.ReadListener;
import cn.j0n4than.ex.community.exceptions.HandlerException;
import cn.j0n4than.ex.community.magic.HttpServletRequestEx;
import cn.j0n4than.ex.community.magic.HttpServletResponseEx;
import cn.j0n4than.ex.community.pojo.Page;
import cn.j0n4than.ex.community.pojo.ResponseEntity;
import cn.j0n4than.ex.community.pojo.entities.Village;
import cn.j0n4than.ex.community.pojo.requests.DeleteRequest;
import cn.j0n4than.ex.community.services.UploadService;
import cn.j0n4than.ex.community.services.VillageService;
import cn.j0n4than.ex.community.services.impl.FilesystemUploadServiceImpl;
import cn.j0n4than.ex.community.services.impl.VillageServiceImpl;

import javax.servlet.ServletException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// 小区
public class VillageHandler {

    private final static VillageService villageService = new VillageServiceImpl();
    private final static UploadService uploaderService = new FilesystemUploadServiceImpl();

    // page list
    public static void page(HttpServletRequestEx request, HttpServletResponseEx response) {
        Integer current = request.getParameterInt("page", 1);
        Integer size = request.getParameterInt("size", 10);
        String name = request.getParameter("name");

        Page<Village> page = villageService.findPage(name, current, size);
        response.json(200, new ResponseEntity<>("OK", page));
    }

    // get one
    public static void one(HttpServletRequestEx request, HttpServletResponseEx response) {
        Integer id = request.getParameterInt("id");
        if (id == null) {
            throw new HandlerException(400, "Invalid id", null);
        }

        Village one = villageService.findOne(id);
        if (one == null) {
            throw new HandlerException(404, "Record not found", null);
        }

        response.json(200, new ResponseEntity<>("OK", one));
    }

    // create or update
    public static void save(HttpServletRequestEx request, HttpServletResponseEx response) {

        Village bind = request.bind(Village.class);
        bind.setCreated(new Date());
        if (bind.getId() == null) {
            // create
            ArrayList<Village> villages = new ArrayList<>();
            villages.add(bind);
            if (villageService.insert(villages) > 0) {
                response.json(200, new ResponseEntity<>("添加成功"));
                return;
            }

            response.json(500, new ResponseEntity<>("添加失败"));
            return;
        }

        // update
        if (villageService.update(bind) > 0) {
            response.json(200, new ResponseEntity<>("更新成功"));
            return;
        }
        response.json(500, new ResponseEntity<>("更新失败"));
    }

    // delete
    public static void del(HttpServletRequestEx request, HttpServletResponseEx response) {
        DeleteRequest deleteRequest = request.bind(DeleteRequest.class);
        ArrayList<Object> ids = deleteRequest.getIds();

        int count = villageService.del(ids);
        response.json(200, new ResponseEntity<>(String.format("成功删除%d条记录", count), ids));
    }

    // image upload
    public static void upload(HttpServletRequestEx request, HttpServletResponseEx response) throws
            ServletException, IOException {
        String newFilename = uploaderService.upload(
                request.getPart("image"),
                new String[]{"jpg", "jpeg", "png"}
        );

        response.json(200, new ResponseEntity<>("上传成功", "/upload/" + newFilename));
    }

    // excel import
    public static void _import(HttpServletRequestEx request, HttpServletResponseEx response) throws
            ServletException, IOException {

        String newFilename = uploaderService.upload(request.getPart("excel"), new String[]{"xlsx"});
        File excel = new File(request.getServletContext().getRealPath("upload") + File.separator + newFilename);

        // parse excel
        try {
            List<Village> records = FastExcel.read(excel, Village.class, new ReadListener<Village>() {
                @Override
                public void invoke(Village village, AnalysisContext analysisContext) {
                }

                @Override
                public void doAfterAllAnalysed(AnalysisContext analysisContext) {
                }
            }).doReadAllSync();

            int insert = villageService.insert(records);

            response.json(200, new ResponseEntity<>(String.format("解析到%d条记录, 成功插入%d条记录", records.size(), insert)));
        } catch (Exception e) {
            e.printStackTrace();
            response.json(500, new ResponseEntity<>("解析Excel失败，格式或模板不正确"));
        } finally {
            // delete it anyway
            if (excel.exists()) {
                excel.delete();
            }
        }
    }
}
