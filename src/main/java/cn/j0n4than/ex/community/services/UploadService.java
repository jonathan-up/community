package cn.j0n4than.ex.community.services;

import javax.servlet.http.Part;

public interface UploadService {
    String upload(Part path, String[] extAllowed);
}
