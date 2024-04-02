package com.ushareit.scmp;
import org.springframework.boot.SpringApplication;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


/**
 * Hello world!
 *
 */
@SpringBootApplication
@MapperScan("com.ushareit.scmp.mapper")
@EnableWebMvc
public class App 
{
    public static void main( String[] args )
    {
        SpringApplication.run(App.class, args);
    }
}
