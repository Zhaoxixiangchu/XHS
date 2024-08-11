//package org.example.base.config;
//
//import cn.dev33.satoken.context.SaHolder;
//import cn.dev33.satoken.context.model.SaRequest;
//import cn.dev33.satoken.error.SaErrorCode;
//import cn.dev33.satoken.exception.NotLoginException;
//import cn.dev33.satoken.interceptor.SaInterceptor;
//import cn.dev33.satoken.router.SaRouter;
//import cn.dev33.satoken.stp.StpUtil;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.commons.lang3.StringUtils;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//import static cn.dev33.satoken.exception.NotLoginException.NOT_TOKEN;
//import static cn.dev33.satoken.exception.NotLoginException.NOT_TOKEN_MESSAGE;
//
//@Configuration
//@Slf4j
//public class SaTokenConfigure implements WebMvcConfigurer {
//
//    //放行路径
//    private static final String[] EXCLUDE_PATH_PATTERNS = {
//            // Swagger
//            "**/swagger-ui.html",
//            "/swagger-resources/**",
//            "/druid/**",
//            "/webjars/**",
//            "/v2/**",
//            "/v3/**",
//            "/swagger-ui.html/**",
//            "/doc.html/**",
//            "/error",
//            "/favicon.ico",
//            "sso/auth",
//            "/csrf",
//            //登录接口
//            "/user/login",
//            "/rotationChart/list",
//            "/common/getCode",
//    };
//
//    // 注册拦截器
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        // 注册 Sa-Token 拦截器，校验规则为 StpUtil.checkLogin() 登录校验。
//        registry.addInterceptor(new SaInterceptor(handle -> {
//                    SaRequest request = SaHolder.getRequest();
//                    //从header里取，看看和设置的默认请求Token是否一致
//                    String tokenValue = request.getHeader("token");
//                    if (StringUtils.isEmpty(tokenValue)){
//                        tokenValue = request.getHeader("Token");
//                    }
//                    if (!Swagger3Config.DEFAULT_TOKEN.equals(tokenValue)){
//                        String finalTokenValue = tokenValue;
//                        SaRouter.match("/**").notMatch(EXCLUDE_PATH_PATTERNS).check(r -> {
//                            if (StringUtils.isEmpty(finalTokenValue)){
//                                throw NotLoginException.newInstance(null, NOT_TOKEN, NOT_TOKEN_MESSAGE, null).setCode(SaErrorCode.CODE_11001);
//                            } else {
//                                StpUtil.checkLogin();
//                            }
//                        });
//                    }
//                }));
//    }
//}
