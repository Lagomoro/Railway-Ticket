package pers.lagomoro.railway_system.runnable;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(exclude = DruidDataSourceAutoConfigure.class)
public class RailwayTicketApplication {

    public static void main(String[] args) {
        SpringApplication.run(RailwayTicketApplication.class, args);
    }

}
