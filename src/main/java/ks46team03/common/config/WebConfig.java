package ks46team03.common.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.PathResourceResolver;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Value("${files.path}")
    private String filePath;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        String os = System.getProperty("os.name").toLowerCase();
        String resourcePath = "file:///" + filePath + "resources/";

        if(os != null && os.contains("win")){
            resourcePath = "file:///" + filePath + "resources/";
        }
        //System.out.println(resourcePath + "<<<<<<<<resourcePath");
        registry.addResourceHandler("/resources/**")
                .addResourceLocations(resourcePath)
                .setCachePeriod(3600)
                .resourceChain(true)
                .addResolver(new PathResourceResolver());
        WebMvcConfigurer.super.addResourceHandlers(registry);
    }
}
