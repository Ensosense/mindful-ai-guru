package se.enso.hokku.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import se.enso.hokku.domain.utils.custom_annotations.DomainService;

@Configuration
@ComponentScan(
    basePackages = "se.enso.hokku.domain",
    includeFilters = @ComponentScan.Filter(
        type = FilterType.ANNOTATION, value = DomainService.class
    )
)
public class DomainConfiguration {
}
