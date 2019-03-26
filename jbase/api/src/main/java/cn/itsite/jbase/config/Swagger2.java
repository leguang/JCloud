package cn.itsite.jbase.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableSwagger2
public class Swagger2 {
	
	@Bean
	public Docket createRestApi() {
		//添加head参数start
//		ParameterBuilder tokenPar = new ParameterBuilder(),
//				applicationPar = new ParameterBuilder(),
//				platformPar = new ParameterBuilder();
//		List<Parameter> pars = new ArrayList<Parameter>();
//		tokenPar.name("Token").description("x-access-token").modelRef(new ModelRef("string")).parameterType("header").required(false);
//		applicationPar.name("Application").description("access from which application, like 'wallet'.").modelRef(new ModelRef("string")).parameterType("header").required(false);
//		platformPar.name("Platform").description("access from what platform, like 'Android', 'iOS', etc.").modelRef(new ModelRef("string")).parameterType("header").required(false);
//		pars.add(tokenPar.build());
//		pars.add(applicationPar.build());
//		pars.add(platformPar.build());
		//添加head参数end
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.select()
//				.apis(RequestHandlerSelectors.basePackage("cn.itsite.jbase.testService"))
				.paths(PathSelectors.any())
				.build();
//				.globalOperationParameters(pars);
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("用户API文档")
				.version("1.0")
				.build();
	}

}
