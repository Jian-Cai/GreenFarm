package org.csu.greenfarm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("org.csu.greenfarm.persistence")
public class GreenFarmApplication {

    public static void main(String[] args) {
        SpringApplication.run(GreenFarmApplication.class, args);
    }

}
