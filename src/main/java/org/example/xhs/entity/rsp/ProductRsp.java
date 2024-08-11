package org.example.xhs.entity.rsp;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class ProductRsp implements Serializable {

    private static final long serialVersionUID = 1L;

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
