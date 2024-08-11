//package org.example.base.config;
//
//import cn.dev33.satoken.stp.StpInterface;
//import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
//import org.liuxinru.wms.entity.UserRole;
//import org.liuxinru.wms.service.MenuService;
//import org.liuxinru.wms.service.RoleMenuService;
//import org.liuxinru.wms.service.RoleService;
//import org.liuxinru.wms.service.UserRoleService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import java.util.ArrayList;
//import java.util.List;
//
////自定义权限加载接口实现类
//// 保证此类被 SpringBoot 扫描，完成 Sa-Token 的自定义权限验证扩展
//@Component
//public class StpInterfaceImpl implements StpInterface {
//
//    @Autowired
//    private UserRoleService userRoleService;
//
//    @Autowired
//    private RoleService roleService;
//
//    @Autowired
//    private RoleMenuService roleMenuService;
//
//    @Autowired
//    private MenuService menuService;
//
//
////    返回一个账号所拥有的权限码集合
//    @Override
//    public List<String> getPermissionList(Object loginId, String loginType) {
//        Long userId = Long.parseLong(loginId.toString());
//        QueryWrapper<UserRole> wrapper = new QueryWrapper<>();
//        wrapper.eq("USER_ID", userId);
//        UserRole userRole = userRoleService.getBaseMapper().selectOne(wrapper);
//        if (userRole != null){
//            List<String> permissions = roleMenuService.selectPermissionByRoleId(String.valueOf(userRole.getRoleId()));
//            return permissions;
//        }
//        return new ArrayList<>();
//    }
//
////  返回一个账号所拥有的角色标识集合 (权限与角色可分开校验)
//    @Override
//    public List<String> getRoleList(Object loginId, String loginType) {
//        Long userId = Long.parseLong(loginId.toString());
//        List<String> userRoleList = userRoleService.selectByUserId(userId);
//        return userRoleList;
//    }
//
//}
