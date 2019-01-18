package org.srysoft.rest.webservices.restfulwebservices;

import org.springframework.context.annotation.Configuration;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	private static final Contact DEFAULT_CONTACT = new Contact("Satyanarayan", "www.upwork.com", "satyanarayan.y@gmail.com");
	private static final ApiInfo DEFAULT_API_INFO = new ApiInfo(
			"Todo Management API", "Todo Mgmt API Documentation", "1.0",
			"urn:tos", DEFAULT_CONTACT, 
			"Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0");

	// private static final ApiInfo DEFAULT_API_INFO = null;

	// Bean Docket
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(DEFAULT_API_INFO);

	}

}
