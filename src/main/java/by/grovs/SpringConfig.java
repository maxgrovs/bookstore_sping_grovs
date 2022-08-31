package by.grovs;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
@ComponentScan
@PropertySource("classpath:application.properties")
public class SpringConfig {

    @Bean
    public JdbcTemplate jdbcTemplate(){
      return new JdbcTemplate(dataSource());
    }

    @Bean
    public DataSource dataSource(){

        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setDriverClassName("org.postgresql.Driver");
        hikariConfig.setUsername("postgres");
        hikariConfig.setPassword("pass");
        hikariConfig.setJdbcUrl("jdbc:postgresql://localhost:5432/bookstore_bh");


        return new HikariDataSource(hikariConfig);
    }


}
