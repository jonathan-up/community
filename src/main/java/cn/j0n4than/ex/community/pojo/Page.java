package cn.j0n4than.ex.community.pojo;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Page<T> {
    private Integer current;
    private Integer size;
    private Integer total;

    List<T> records;

    private Page() {
    }

    public Page(Integer current, Integer size) {
        this.current = current;
        this.size = size;
        this.records = new ArrayList<>();
    }

    public int totalPage() {
        int _total = this.total == 0 ? 1 : this.total;
        if (_total % this.size != 0) {
            return _total / this.size + 1;
        }
        return _total / this.size;
    }
}
