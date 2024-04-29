package se.enso.hokku.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import se.enso.hokku.utils.custom_annotations.DomainService;

@Configuration
@ComponentScan(
    basePackages = "se.enso.hokku",
    includeFilters =
        @ComponentScan.Filter(type = FilterType.ANNOTATION, value = DomainService.class))
public class DomainConfiguration {}
