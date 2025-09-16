package cn.j0n4than.ex.community.pojo.requests;

import lombok.Data;

import java.util.ArrayList;

@Data
public class DeleteRequest {
    private ArrayList<Object> ids;
}
