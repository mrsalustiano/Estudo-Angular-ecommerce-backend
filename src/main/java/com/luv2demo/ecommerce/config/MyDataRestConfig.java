package com.luv2demo.ecommerce.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;

import com.luv2demo.ecommerce.entity.Product;
import com.luv2demo.ecommerce.entity.ProductCategory;

@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer{

	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
	
		HttpMethod[] theUnsupportedActions = {HttpMethod.PUT, HttpMethod.DELETE, HttpMethod.PATCH,HttpMethod.POST };
		config.getExposureConfiguration()
			.forDomainType(Product.class)
			.withItemExposure((metdata, httpMethods ) -> httpMethods.disable(theUnsupportedActions) )
			.withCollectionExposure((metdata, httpMethods ) ->httpMethods.disable(theUnsupportedActions));
		

		config.getExposureConfiguration()
			.forDomainType(ProductCategory.class)
			.withItemExposure((metdata, httpMethods ) -> httpMethods.disable(theUnsupportedActions) )
			.withCollectionExposure((metdata, httpMethods ) ->httpMethods.disable(theUnsupportedActions));
	
		
		
	}
	

	
}
