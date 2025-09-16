package cn.j0n4than.ex.community.handlers;

import cn.j0n4than.ex.community.magic.HttpServletRequestEx;
import cn.j0n4than.ex.community.magic.HttpServletResponseEx;
import cn.j0n4than.ex.community.pojo.ResponseEntity;

public class IndexHandler {

    public static void index(HttpServletRequestEx request, HttpServletResponseEx response) {
        response.json(200, new ResponseEntity<>("OK"));
    }
}
