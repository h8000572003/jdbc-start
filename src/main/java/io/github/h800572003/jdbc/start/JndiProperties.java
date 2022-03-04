package io.github.h800572003.jdbc.start;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "connect.jndi")
public class JndiProperties {

	private String jndiName = "";
	private String contextFactory = "";
	private String providerUrl = "";
	private String securityPrincipal = "";
	private String alwaysLookup = "";
	private String authHandler = "";
	private String applicationId;

	public String getJndiName() {
		return jndiName;
	}

	public void setJndiName(String jndiName) {
		this.jndiName = jndiName;
	}

	public String getContextFactory() {
		return contextFactory;
	}

	public void setContextFactory(String contextFactory) {
		this.contextFactory = contextFactory;
	}

	public String getProviderUrl() {
		return providerUrl;
	}

	public void setProviderUrl(String providerUrl) {
		this.providerUrl = providerUrl;
	}

	public String getSecurityPrincipal() {
		return securityPrincipal;
	}

	public void setSecurityPrincipal(String securityPrincipal) {
		this.securityPrincipal = securityPrincipal;
	}

	public String getAlwaysLookup() {
		return alwaysLookup;
	}

	public void setAlwaysLookup(String alwaysLookup) {
		this.alwaysLookup = alwaysLookup;
	}

	public String getAuthHandler() {
		return authHandler;
	}

	public void setAuthHandler(String authHandler) {
		this.authHandler = authHandler;
	}

	public String getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(String applicationId) {
		this.applicationId = applicationId;
	}

}
