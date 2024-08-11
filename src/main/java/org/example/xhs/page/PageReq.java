package org.example.xhs.page;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

/**
 * 默认分页参数
 * 当前页默认为1
 * 每页数据个数默认10
 */
@Data
public class PageReq {

    @TableField(exist = false)
    private int pageNum = 1;

    @TableField(exist = false)
    private int pageSize = 10;
}
