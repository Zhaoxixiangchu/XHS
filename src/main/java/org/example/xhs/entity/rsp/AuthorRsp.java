package org.example.xhs.entity.rsp;

import lombok.Data;

import java.io.Serializable;

@Data
public class AuthorRsp implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String authorId;

    private String authorNickName;

    private String authorUrl;
}
