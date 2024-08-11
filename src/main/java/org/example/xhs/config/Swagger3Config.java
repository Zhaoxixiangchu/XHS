package org.example.xhs.config;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import springfox.documentation.builders.*;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.schema.ScalarType;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ParameterType;
import springfox.documentation.service.RequestParameter;
import springfox.documentation.service.Response;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;
import java.util.List;

/**
 * 默认访问地址：<a href="http://localhost:8080/doc.html">...</a>
 */

//注解启动用Swagger的使用，同时在配置类中对Swagger的通用参数进行配置
@EnableKnife4j
@Configuration
@EnableOpenApi
public class Swagger3Config {



    public static final String DEFAULT_TOKEN = "6fd4221395024b5f87edd34bc3258ee8";

    @Bean
    public Docket createRestApi(){
        //返回文档概要信息
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("org.example.base.controller"))
                .paths(PathSelectors.any())
                .build()
                .globalRequestParameters(getGlobalRequestParameters())
                .globalResponses(HttpMethod.GET,getGlobalResponseMessage())
                .globalResponses(HttpMethod.POST,getGlobalResponseMessage());
    }

    /*
    生成接口信息，包括标题，联系人等
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Swagger3接口文档")
                .description("接口文档")
                .version("1.0")
                .build();
    }


    /*
    封装全局通用参数
     */
    private List<RequestParameter> getGlobalRequestParameters() {
        List<RequestParameter> parameters=new ArrayList<>();
        parameters.add(new RequestParameterBuilder()
                .name("token")
                .description("访问令牌")
                .required(true)
                .in(ParameterType.HEADER)
                .query(q->q.model(m->m.scalarModel((ScalarType.STRING))))
                .required(false)
                .build());

        return parameters;
    }
    /*
    封装通用相应信息
     */
    private List<Response> getGlobalResponseMessage() {
        List<Response> responseList=new ArrayList<>();
        responseList.add(new ResponseBuilder().code("404").description("未找到资源").build());
        return responseList;
    }
}