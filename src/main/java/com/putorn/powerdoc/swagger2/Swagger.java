package com.putorn.powerdoc.swagger2;

import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @description: swagger 配置类
 * @author：Guoqingkai
 * @date:2019/3/13
 */
@Configuration
public class Swagger {

	@Bean("用户权限模块接口api")
	public Docket createRestApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))//只扫描带有 @ApiOperation 注解的方法
				.paths(PathSelectors.any())
				.build()
				.directModelSubstitute(java.sql.Timestamp.class,java.sql.Date.class);//将Timestamp转为Date类型(否则TimeStamp会被分解为 年 月 日 等)
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("用户权限接口管理文档,springboot利用swagger构建api文档")
				.description("简单优雅的restfun风格，访问地址:http://localhost:8081/swagger-ui.html")
				.version("1.0")
				.build();
	}
}
