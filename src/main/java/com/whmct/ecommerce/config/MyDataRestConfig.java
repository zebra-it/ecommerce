package com.whmct.ecommerce.config;

import com.whmct.ecommerce.entity.Product;
import com.whmct.ecommerce.entity.ProductCategory;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;

@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer {
    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        HttpMethod[] theUnsupportedAction = {HttpMethod.PUT, HttpMethod.DELETE, HttpMethod.POST};

        // disable method for Product : PUT, POST and DELETE
        config.getExposureConfiguration()
                .forDomainType(Product.class)
                .withItemExposure(((metdata, httpMethods)
                        -> httpMethods.disable(theUnsupportedAction)))
                .withCollectionExposure((metdata, httpMethods)
                        -> httpMethods.disable(theUnsupportedAction));

        // disable method for Product Category : PUT, POST and DELETE
        config.getExposureConfiguration()
                .forDomainType(ProductCategory.class)
                .withItemExposure(((metdata, httpMethods)
                        -> httpMethods.disable(theUnsupportedAction)))
                .withCollectionExposure((metdata, httpMethods)
                        -> httpMethods.disable(theUnsupportedAction));
    }
}
