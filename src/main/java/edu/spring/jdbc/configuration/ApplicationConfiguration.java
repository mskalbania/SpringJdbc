package edu.spring.jdbc.configuration;

import edu.spring.jdbc.service.ServiceMarker;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackageClasses = ServiceMarker.class)
@Import(DataPersistenceAccessConfiguration.class)
public class ApplicationConfiguration {
}
