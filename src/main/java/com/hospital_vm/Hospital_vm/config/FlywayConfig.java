package com.hospital_vm.Hospital_vm.config;

import javax.sql.DataSource;

import org.flywaydb.core.Flyway;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FlywayConfig {

    @Bean(initMethod = "migrate")
    public Flyway flyway(DataSource dataSource) {
        return Flyway.configure()
                .dataSource(dataSource)
                .locations("classpath:db/migration")
                .baselineOnMigrate(false)
                .load();
    }

    @Bean
    public static BeanFactoryPostProcessor entityManagerFactoryDependsOnFlyway() {
        return new BeanFactoryPostProcessor() {
            @Override
            public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
                if (!beanFactory.containsBeanDefinition("entityManagerFactory")) {
                    return;
                }
                BeanDefinition definition = beanFactory.getBeanDefinition("entityManagerFactory");
                definition.setDependsOn(appendDependsOn(definition.getDependsOn(), "flyway"));
            }
        };
    }

    private static String[] appendDependsOn(String[] dependsOn, String beanName) {
        if (dependsOn == null || dependsOn.length == 0) {
            return new String[] { beanName };
        }
        for (String existing : dependsOn) {
            if (beanName.equals(existing)) {
                return dependsOn;
            }
        }
        String[] updated = new String[dependsOn.length + 1];
        System.arraycopy(dependsOn, 0, updated, 0, dependsOn.length);
        updated[dependsOn.length] = beanName;
        return updated;
    }
}
