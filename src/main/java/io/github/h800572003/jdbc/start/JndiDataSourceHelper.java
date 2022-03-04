package io.github.h800572003.jdbc.start;

import java.util.Properties;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.apache.commons.lang3.StringUtils;

public class JndiDataSourceHelper {
	private JndiProperties jdbcProperties;
	private IPasserService tvPasser;

	JndiDataSourceHelper(JndiProperties jdbcProperties, IPasserService tvPasser) {
		this.jdbcProperties = jdbcProperties;
		this.tvPasser = tvPasser;
	}

	public DataSource toDatasource() throws Exception {
		Properties h = new Properties();
		if (!StringUtils.isEmpty(jdbcProperties.getContextFactory())) {
			h.put("java.naming.factory.initial", jdbcProperties.getContextFactory());
		}
		if (!StringUtils.isEmpty(this.jdbcProperties.getProviderUrl())) {
			h.put("java.naming.provider.url", this.jdbcProperties.getProviderUrl());
		}
		if (!StringUtils.isEmpty(this.jdbcProperties.getSecurityPrincipal())) {
			h.put("java.naming.security.principal", this.jdbcProperties.getSecurityPrincipal());
		}
		if (!StringUtils.isEmpty(tvPasser.toPw())) {
			h.put("java.naming.security.credentials", tvPasser.toPw());
		}
		synchronized (JndiDataSourceHelper.class) {
			InitialContext context = null;
			try {
				context = new InitialContext(h);
				return (DataSource) context.lookup(jdbcProperties.getJndiName());
			} finally {
				if (context != null) {
					context.close();
				}
			}
		}

	}
}
