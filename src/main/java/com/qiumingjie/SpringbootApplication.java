package com.qiumingjie;

import cn.org.bjca.client.exceptions.ApplicationNotFoundException;
import cn.org.bjca.client.exceptions.InitException;
import cn.org.bjca.client.exceptions.SVSConnectException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@ServletComponentScan
@Slf4j
//去掉save的空的
//@EnableJpaRepositories(repositoryBaseClass = SimpleJpaRepositoryImpl.class)
public class SpringbootApplication extends SpringBootServletInitializer {

    public static void main(String[] args) throws ApplicationNotFoundException, InitException, SVSConnectException {
//        SignUtils.init();
        SpringApplication.run(SpringbootApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SpringbootApplication.class);
    }

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper().disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
    }

}
