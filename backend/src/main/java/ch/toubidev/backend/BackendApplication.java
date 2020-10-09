package ch.toubidev.backend;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

@SpringBootApplication(exclude = {HibernateJpaAutoConfiguration.class, DataSourceAutoConfiguration.class})
public class BackendApplication {

    private static final Logger log = LoggerFactory.getLogger(BackendApplication.class);

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(BackendApplication.class, args);
        log.info("##############################################################");
        log.info("MyBudget Backend was started");
        log.info("ApplicationName={}", run.getApplicationName());
        log.info("DisplayName={}", run.getDisplayName());
        log.info("Environment={}", run.getEnvironment());
        log.info("Id={}", run.getId());
        log.info("StartupDate={}", DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(Instant.ofEpochMilli(run.getStartupDate()).atZone(ZoneId.systemDefault()).toLocalDateTime()));
        log.info("##############################################################");
    }

}
