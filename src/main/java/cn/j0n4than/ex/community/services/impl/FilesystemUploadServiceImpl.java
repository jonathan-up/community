package cn.j0n4than.ex.community.services.impl;

import cn.j0n4than.ex.community.ServletContextHolder;
import cn.j0n4than.ex.community.exceptions.HandlerException;
import cn.j0n4than.ex.community.services.UploadService;
import cn.j0n4than.ex.community.utils.MiscUtils;

import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;

public class FilesystemUploadServiceImpl implements UploadService {
    @Override
    public String upload(Part part, String[] extAllowed) {

        // check upload path
        String uploadPath = ServletContextHolder.value.get().getRealPath("upload");
        File file = new File(uploadPath);
        if (!file.exists()) {
            if (!file.mkdir()) {
                throw new HandlerException(500, "未知错误", null);
            }
        }

        // get file name
        String fileName = MiscUtils.getFileName(part);
        if (fileName == null || fileName.isEmpty()) {
            throw new HandlerException(500, "未知错误", null);
        }

        // ext name
        String[] split = fileName.split("\\.");
        String ext = split[split.length - 1];
        if (!Arrays.asList(extAllowed).contains(ext)) {
            throw new HandlerException(500, "不允许上传的文件类型: " + ext, null);
        }

        // new file name
        String newFilename = MiscUtils.randString(32) + "." + ext;

        // save path
        String filePath = uploadPath + File.separator + newFilename;

        // save it
        try (InputStream input = part.getInputStream()) {
            Files.copy(input, new File(filePath).toPath(), StandardCopyOption.REPLACE_EXISTING);
            return newFilename;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
