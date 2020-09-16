package com.delivery.web.core.config;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.flywaydb.core.Flyway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

/**
 * Copyright: Copyright (c) 2020 <a href="http://www.jcohy.com" target="_blank">jcohy.com</a>
 *
 * <p> Description:
 *
 * @author jiac
 * @version 1.0.0 2020/8/19:16:44
 * @since 1.0.0
 */
@Configuration
public class FlywayConfig {

	@Autowired
	private DataSource dataSource;

	@PostConstruct
	public void migrate() {
		Flyway flyway = Flyway.configure()
				.dataSource(dataSource)
				.locations("db/migration")
				.baselineOnMigrate(true)
				.load();
		flyway.migrate();
	}

}
