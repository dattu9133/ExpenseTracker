package com.glzd.expenseTrackerApp;

import com.glzd.expenseTrackerApp.web.helpers.MoneyFormatter;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.math.BigDecimal;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    private final MoneyFormatter moneyFormatter;

    public WebConfig(MoneyFormatter moneyFormatter) {
        this.moneyFormatter = moneyFormatter;
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addFormatterForFieldType(BigDecimal.class, moneyFormatter);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // Custom resource handler for CSS files
        registry.addResourceHandler("/css/**")
                .addResourceLocations("classpath:/static/css/");

        // Custom resource handler for image files
        registry.addResourceHandler("/images/**")
                .addResourceLocations("classpath:/static/images/");
    }
}
