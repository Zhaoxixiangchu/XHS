package org.example.xhs.entity.rsp;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class ProductResourceRsp implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String productId;

    private String productTitle;

    private String downloadUrl;

//    private String dynamicPhotoUrl;

    private Date createDate;
}
