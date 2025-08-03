package com.happycoding.ecommarce.config;

import com.happycoding.ecommarce.entity.Country;
import com.happycoding.ecommarce.entity.Product;
import com.happycoding.ecommarce.entity.ProductCategory;
import com.happycoding.ecommarce.entity.State;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import javax.persistence.EntityManager;
import javax.persistence.metamodel.EntityType;
import java.util.ArrayList;
import java.util.Set;

@Configuration
public class MyDataRestConfigure implements RepositoryRestConfigurer {

    @Value("${allowed.origins}")
    private String[] theAllowedOrigins;

    @Autowired
    EntityManager entityManager;

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {

        HttpMethod[] unSupportedActions = {HttpMethod.POST, HttpMethod.PUT, HttpMethod.DELETE};

        disableHttpMethods(config, unSupportedActions, Product.class);
        disableHttpMethods(config, unSupportedActions, ProductCategory.class);
        disableHttpMethods(config, unSupportedActions, Country.class);
        disableHttpMethods(config, unSupportedActions, State.class);

        exposeIds(config);
        cors.addMapping("/**").allowedOrigins(theAllowedOrigins);
    }

    private static void disableHttpMethods(RepositoryRestConfiguration config, HttpMethod[] unSupportedActions, Class theClass) {
        config.getExposureConfiguration()
                .forDomainType(theClass)
                .withItemExposure((metadata, httpMethods) -> httpMethods.disable(unSupportedActions))
                .withCollectionExposure((metadata, httpMethods) -> httpMethods.disable(unSupportedActions));
    }

    private void exposeIds(RepositoryRestConfiguration configuration){
        Set<EntityType<?>> entities = entityManager.getMetamodel().getEntities();

        ArrayList<Object> entityClasses = new ArrayList<>();
        entities.forEach(i -> entityClasses.add(i.getJavaType()));

        Class[] domainTypes = entityClasses.toArray((new Class[0]));
        configuration.exposeIdsFor(domainTypes);

    }
}
