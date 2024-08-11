package org.example.xhs.response;

import com.github.pagehelper.Page;

import java.io.Serializable;
import java.util.List;

/**
 * 分页对象
 * @param <T>参数泛型
 */
public class PageResult<T> implements Serializable {
    //数据总数
    private Long total;
    //当前数据
    private List<T> data;

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public PageResult(Long total, List<T> data) {
        this.total = total;
        this.data = data;
    }

    public PageResult(Page<T> page){
        this.total = page.getTotal();
        this.data = page.getResult();
    }

    public PageResult() {
    }
}
