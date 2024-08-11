package org.example.xhs.entity.req;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;

    private String productTitle;

    private String productId;

    private String productTags;

    private String productDesc;

    private String productUrl;

    private String productType;

    private Date publishedTime;

    private Date lastUpdateDate;

    private String authorNickName;

    private String authorId;

    private String favoriteCount;

    private String commentCount;

    private String shareCount;

    private String likeCount;

    //作品地址
    private String url;

    private Date createDate;
}
