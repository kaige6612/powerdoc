package com.putorn.powerdoc;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@MapperScan(basePackages = {"com.putorn.powerdoc.dao"})
@EnableSwagger2
@ApiResponses({@ApiResponse(code = 200, message = "success", response = ResponseEntity.class)})
public class Application {


	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}


}
