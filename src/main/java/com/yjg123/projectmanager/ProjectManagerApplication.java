package com.yjg123.projectmanager;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author dell
 */

@MapperScan("com.yjg123.projectmanager.mapper")
@SpringBootApplication
public class ProjectManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjectManagerApplication.class, args);
    }

}
