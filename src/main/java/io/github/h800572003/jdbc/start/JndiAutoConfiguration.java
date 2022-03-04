package io.github.h800572003.jdbc.start;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(JndiProperties.class)
public class JndiAutoConfiguration {

	@Bean
	@ConditionalOnMissingBean
	public DataSource dataSource(JndiProperties jndiProperties, IPasserService tvPasser) throws Exception {
		return new JndiDataSourceHelper(jndiProperties, tvPasser).toDatasource();
	}

}
