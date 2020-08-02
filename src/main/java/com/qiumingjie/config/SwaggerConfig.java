package com.qiumingjie.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author QiuMingJie
 * @date 2020-08-01 23:06
 * @description
 */
@Configuration
@EnableSwagger2
@ConditionalOnProperty(prefix = "mconfig", name = "swagger-ui-open", havingValue = "true")
public class SwaggerConfig {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.qiumingjie.controller"))
                .paths(PathSelectors.regex("/.*"))
                .build();
//
//        return new Docket(DocumentationType.SWAGGER_2)
//                .apiInfo(apiInfo())
//                .select()
//                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
//                .paths(PathSelectors.any())
//                .build();
    }

    public ApiInfo apiInfo() {

        return new ApiInfoBuilder()
                .title("表单系统API API")
                .description("Restful API")
                .termsOfServiceUrl("http://localhost:8895/formSystem/dist/index.html#/")
                .version("1.0")
                .build();
//        return new ApiInfoBuilder()
//                .title("表单系统API")
//                .description(" API接口")
//                .termsOfServiceUrl("https://blog.csdn.net/youbitch1")
//                .version("1.0")
//                .build();
    }
}
