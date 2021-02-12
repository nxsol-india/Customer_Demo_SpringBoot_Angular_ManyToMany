package com.nxpert.CustomerDemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Pageable;

import com.sun.istack.Nullable;

import io.swagger.annotations.ApiParam;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@ApiParam(value = "Number of records per page", example = "0")
    @Nullable
    private Integer size;

    @ApiParam(value = "Results page you want to retrieve (0..N)", example = "0")
    @Nullable
    private Integer page;

    @ApiParam(value = "Sorting criteria in the format: property(,asc|desc). Default sort order is ascending. Multiple sort criteria are supported.")
    @Nullable
    private String sort;
    
    
	
	@Bean
	public Docket api() {
	    return new Docket(DocumentationType.SWAGGER_2)
	        .select()
	        .paths(PathSelectors.any())
	        .build()
	        .directModelSubstitute(Pageable.class, SwaggerConfig.class);
	}



	public Integer getSize() {
		return size;
	}



	public void setSize(Integer size) {
		this.size = size;
	}



	public Integer getPage() {
		return page;
	}



	public void setPage(Integer page) {
		this.page = page;
	}



	public String getSort() {
		return sort;
	}



	public void setSort(String sort) {
		this.sort = sort;
	}
	 
	/*
	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.nxpert.CustomerDemo"))
				.build()
				.globalOperationParameters(
						Arrays.asList(new ParameterBuilder()
								.name("Authorization")
								.description("Access Token")
								.modelRef(new ModelRef("string"))
								.parameterType("header")
								.required(false)
								.build())); 
	}
	*/
	
}


