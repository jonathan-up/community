package cn.j0n4than.ex.community.pojo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class User {
    private Integer id;
    private String username;

    // can json to obj
    // can not obj to json
    // read: obj -> json
    // write json -> obj
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String pwd;

    @JsonIgnore
    private String salt;
    private String phone;
    private String email;
    private String image;
    private Integer sex;
    private Integer status;
    private String realName;
    private String avatar;
}
