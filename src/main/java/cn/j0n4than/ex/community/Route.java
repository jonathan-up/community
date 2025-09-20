package cn.j0n4than.ex.community;

import cn.j0n4than.ex.community.magic.ServletDispatcherCall;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Route {
    private HttpMethod method;
    private List<String> perms;
    private ServletDispatcherCall handler;
}
