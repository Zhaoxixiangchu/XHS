package org.example.xhs.entity.req;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class User implements Serializable {

    private static final long serialVersionUID = 1L;


    private Long id;

    private String userName;

    private String passWord;

    private String email;

    private String phone;

    private Date createDate;

    private Integer isEnable;

}
