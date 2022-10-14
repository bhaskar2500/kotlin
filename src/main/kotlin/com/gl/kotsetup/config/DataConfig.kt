package com.gl.kotsetup.config

import com.mchange.v2.c3p0.ComboPooledDataSource
import org.springframework.boot.jdbc.DataSourceBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.transaction.annotation.EnableTransactionManagement
import java.sql.Connection
import javax.sql.DataSource


@Configuration
@EnableTransactionManagement
class DataConfig {
    @Bean
    fun jdbcTemplate(): JdbcTemplate{
        return JdbcTemplate(this.datasource(),true)
    }
    @Bean
    fun datasource(): DataSource {
        return DataSourceBuilder.create()
            .driverClassName("org.postgresql.Driver")
            .url("jdbc:postgresql://localhost:5433/postgres")
            .username("postgres")
            .password("root")
            .build()
    }
    @Bean
    open fun getDbConnection(): Connection {
        val datasource = ComboPooledDataSource().apply {
            driverClass = "org.postgresql.Driver"
            jdbcUrl = "jdbc:postgresql://localhost:5433/postgres"
            user = "postgres"
            password = "root"
            initialPoolSize = 1
            minPoolSize = 1
            acquireIncrement = 5
            maxIdleTime = 1800
            isBreakAfterAcquireFailure = false
            isAutoCommitOnClose = true
        }
        return datasource.connection
    }
}