package org.example.xhs.entity.req;

import lombok.Data;

import java.io.Serializable;

@Data
public class ParseParam implements Serializable {

    private static final long serialVersionUID = 1L;

    private String url;

    private boolean download = false;
}
