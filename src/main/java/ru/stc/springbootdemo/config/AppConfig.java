package ru.stc.springbootdemo.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(
        value = {"classpath:demo.properties"},
        ignoreResourceNotFound = true)
public class AppConfig {
}
