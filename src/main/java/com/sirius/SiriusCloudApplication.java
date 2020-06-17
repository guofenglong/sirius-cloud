package com.sirius;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Hello world!
 *
 * @author zhengyoule
 */
@SpringBootApplication(scanBasePackages = "com.sirius")
@EnableScheduling
@MapperScan("com.sirius.**.repository")
public class SiriusCloudApplication {

    @Bean
    public BCryptPasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    public static void main( String[] args ) {
        SpringApplication app = new SpringApplication(SiriusCloudApplication.class);
        app.run(args);
    }
}
