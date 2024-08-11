package org.example.xhs.entity.rsp;

import lombok.Data;

import java.io.Serializable;

@Data
public class DictionaryRsp implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String dicName;

    private String dicCode;

    private String dicValue;

    private Integer dicStatus;

    private Long createUserId;
}
