package org.example.xhs.mapper;

import org.apache.ibatis.annotations.Param;
import org.example.xhs.entity.req.User;
import org.example.xhs.entity.rsp.UserRsp;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {

    /**
     * 登录
     * @param userName
     * @param encryptPassword
     * @return
     */
    UserRsp login(@Param("userName") String userName, @Param("passWord") String encryptPassword);

    /**
     * 新增用户
     * @param user
     * @return
     */
    int add(User user);

    /**
     * 检查是否已存在用户名
     * @param userName
     * @return
     */
    int checkExist(@Param("userName") String userName);
}
