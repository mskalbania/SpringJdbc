package edu.spring.jdbc.configuration;

import edu.spring.jdbc.repository.RepositoryMarker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackageClasses = RepositoryMarker.class)
public class DataPersistenceAccessConfiguration {

    @Bean
    public DataSource dataSource(){
        EmbeddedDatabaseBuilder databaseBuilder = new EmbeddedDatabaseBuilder();
        return databaseBuilder
                .setType(EmbeddedDatabaseType.H2)
                .addScripts("db/scripts/init.sql", "db/scripts/data.sql")
                .build();
    }

    @Bean
    public JdbcTemplate jdbcTemplate (DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}
