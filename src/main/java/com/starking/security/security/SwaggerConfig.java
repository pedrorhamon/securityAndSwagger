package com.starking.security.security;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;

/**
 * @author pedroRhamon
 */
@Configuration
public class SwaggerConfig {

	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI()
				.info(new Info().title("API Documentation")
						.version("1.0")
				.description("API documentation for the application")
				.termsOfService("http://swagger.io/terms/")
				.license(new License().name("Apache 2.0").url("http://springdoc.org")))
				.addSecurityItem(new SecurityRequirement().addList("JWT"))
	            .components(new Components().addSecuritySchemes("JWT", createJWT()));
	}

	private SecurityScheme createJWT() {
		return new SecurityScheme()
	            .name("JWT")
	            .type(SecurityScheme.Type.HTTP)
	            .scheme("bearer")
	            .bearerFormat("JWT")
	            .in(SecurityScheme.In.HEADER)
	            .name("Authorization");
	}

	@Bean
	public GroupedOpenApi publicApi() {
		return GroupedOpenApi.builder()
				.group("public-api")
				.pathsToMatch("/**")
				.build();
	}
	
	/* Maneira mais verbosa */
//	 public static final String SCHEME_NAME = "BearerScheme";
//	    public static final String SCHEME = "Bearer";
//
//	    @Bean
//	    public OpenAPI customOpenAPI() {
//	        var openApi = new OpenAPI().info(this.apiInfo());
//	        this.addSecurity(openApi);
//	        return openApi;
//	    }
//
//	    private Info apiInfo() {
//	        var contact = new Contact();
//	        contact.setEmail("mailbox@product.com");
//	        contact.setName("product_admin");
//	        contact.setUrl("http://product.com");
//	        return new Info()
//	            .title("Product API")
//	                .description("Product description")
//	                .termsOfService("http://product.com/terms_of_service")
//	                .contact(contact)
//	                // TODO: Version should be dynamically
//	                .version("0.5.1");
//	    }
//
//	    private void addSecurity(OpenAPI openApi) {
//	        var components = this.createComponents();
//	        var securityItem = new SecurityRequirement().addList(SCHEME_NAME);
//	        openApi.components(components).addSecurityItem(securityItem);
//	    }
//
//	    private Components createComponents() {
//	        var components = new Components();
//	        components.addSecuritySchemes(SCHEME_NAME, this.createSecurityScheme());
//	        return components;
//	    }
//
//	    private SecurityScheme createSecurityScheme() {
//	        return new SecurityScheme().name(SCHEME_NAME).type(SecurityScheme.Type.HTTP).scheme(SCHEME);
//	    }
}
