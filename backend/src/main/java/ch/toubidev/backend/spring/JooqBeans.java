package ch.toubidev.backend.spring;

import org.jooq.ConnectionProvider;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.conf.Settings;
import org.jooq.impl.DSL;
import org.jooq.impl.DataSourceConnectionProvider;
import org.jooq.impl.DefaultConfiguration;
import org.jooq.impl.DefaultExecuteListenerProvider;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.JdbcProperties;
import org.springframework.boot.autoconfigure.jooq.JooqExceptionTranslator;
import org.springframework.boot.autoconfigure.jooq.SpringTransactionProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
public class JooqBeans {

    @Value("${spring.jooq.sqlDialect}")
    private String dataSourceDialect;

    @Bean
    @Qualifier("jooqSettings")
    public Settings jooqSettings(JdbcProperties properties) {
        Settings settings = new Settings();
        JdbcProperties.Template template = properties.getTemplate();
        if (template.getMaxRows() >= 0) {
            settings.setMaxRows(Integer.valueOf(template.getMaxRows()));
        }
        if (template.getFetchSize() >= 0) {
            settings.setFetchSize(Integer.valueOf(template.getFetchSize()));
        }
        if (template.getQueryTimeout() != null) {
            settings.setQueryTimeout(Integer.valueOf((int) template.getQueryTimeout().getSeconds()));
        }
        return settings;
    }

    @Bean
    @Primary
    public DataSourceConnectionProvider connectionProvider(DataSource dataSource) {
        return new DataSourceConnectionProvider(new TransactionAwareDataSourceProxy(dataSource));
    }

    @Bean
    @Qualifier("jooqConfig")
    public org.jooq.Configuration jooqConfiguration(ConnectionProvider connectionProvider, PlatformTransactionManager txManager,
                                                    @Qualifier("jooqSettings") Settings settings) {
        return new DefaultConfiguration()
                .derive(settings).derive(connectionProvider)
                .derive(SQLDialect.valueOf(dataSourceDialect))
                .derive(new DefaultExecuteListenerProvider(new JooqExceptionTranslator()))
                .derive(new SpringTransactionProvider(txManager));
    }

    @Bean
    @Qualifier("DSLContext")
    public DSLContext jooqDslContext(@Qualifier("jooqConfig") org.jooq.Configuration configuration) {
        return DSL.using(configuration);
    }
}
