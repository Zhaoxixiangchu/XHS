package org.example.xhs.entity.rsp;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class UserRsp implements Serializable {

    private static final long serialVersionUID = 1L;


    private Long id;

    private String userName;

    private String passWord;

    private String email;

    private String phone;

    private Date createDate;

    private Integer isEnable;

}
