package com.togbo.taskmanager.data;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class DataLoader {

    private final SessionFactory sessionFactory;
    @Autowired
    private DataSource dataSource;
    @Autowired
    public DataLoader(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Bean
    public DataSourceInitializer dataSourceInitializer() {
        DataSourceInitializer initializer = new DataSourceInitializer();
        initializer.setDataSource(dataSource);
        initializer.setDatabasePopulator(databasePopulate());
        return initializer;
    }

    private ResourceDatabasePopulator databasePopulate() {
        ResourceDatabasePopulator populate= new ResourceDatabasePopulator();
        Resource sqlAccount = new ClassPathResource("data_account.sql");
        Resource sqlTask = new ClassPathResource("data_task.sql");
        Resource sqlTeam = new ClassPathResource("data_team.sql");
        Resource sqlEmployee = new ClassPathResource("data_employee.sql");
        Resource sqlProject = new ClassPathResource("data_project.sql");
        populate.addScript(sqlAccount);
        populate.addScript(sqlTask);
        populate.addScript(sqlTeam);
        populate.addScript(sqlEmployee);
        populate.addScript(sqlProject);
        return populate;
    }

}
