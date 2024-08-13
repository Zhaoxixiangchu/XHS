package org.example.xhs.entity.rsp;

import lombok.Data;
import org.example.xhs.entity.req.ProductResource;

import java.io.Serializable;
import java.util.List;

@Data
public class AuthorRsp implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String authorId;

    private String authorNickName;

    private String authorUrl;

    private List<ProductResource> productResourceList;
}
