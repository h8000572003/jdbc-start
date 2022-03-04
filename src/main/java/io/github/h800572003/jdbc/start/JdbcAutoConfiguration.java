package io.github.h800572003.jdbc.start;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(JdbcProperties.class)
public class JdbcAutoConfiguration {

	@Bean
	@ConditionalOnMissingBean
	public DataSource dataSource(JdbcProperties jdbcProperties, IPasserService tvPasser) throws Exception {
		return new JdbcDatasourceHelper(jdbcProperties, tvPasser).toDataSource();
	}

}
