package pers.lagomoro.railway_system;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication(scanBasePackages="pers.lagomoro.railway_system",
        exclude = DruidDataSourceAutoConfigure.class)
@MapperScan("pers.lagomoro.railway_system.mapper")
public class RailwayTicketApplication {

    public static void main(String[] args) {
        SpringApplication.run(RailwayTicketApplication.class, args);
    }

}
