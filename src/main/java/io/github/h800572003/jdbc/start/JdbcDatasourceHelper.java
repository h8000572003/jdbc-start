package io.github.h800572003.jdbc.start;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;

public class JdbcDatasourceHelper {
	JdbcProperties jdbcProperties;
	IPasserService tvPasser;

	JdbcDatasourceHelper(JdbcProperties jdbcProperties, IPasserService tvPasser) {
		this.jdbcProperties = jdbcProperties;
		this.tvPasser = tvPasser;
	}

	public DataSource toDataSource() throws Exception {
		final DataSourceProperties dataSourceProperties = new DataSourceProperties();
		dataSourceProperties.setUrl(jdbcProperties.getUrl());
		dataSourceProperties.setUsername(jdbcProperties.getUsername());
		dataSourceProperties.setPassword(this.tvPasser.toPw());
		return dataSourceProperties.initializeDataSourceBuilder().build();
	}
}
