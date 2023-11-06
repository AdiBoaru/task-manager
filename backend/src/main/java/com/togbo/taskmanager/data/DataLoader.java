package com.togbo.taskmanager.data;

import com.togbo.taskmanager.enums.Role;
import com.togbo.taskmanager.model.Account;
import com.togbo.taskmanager.model.Employee;
import com.togbo.taskmanager.repository.AccountRepository;
import jakarta.annotation.PostConstruct;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.time.LocalDate;
import java.util.UUID;

@Component
public class DataLoader {

    private final SessionFactory sessionFactory;
    @Autowired
    private DataSource dataSource;
    @Autowired
    public DataLoader(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @PostConstruct
    @Transactional
    public void load() {
        try (Session session = sessionFactory.openSession()) {
            // Begin a transaction
            session.beginTransaction();

            // Execute the SQL script
       //     session.createQuery(getSqlScript("data_employee.sql")).executeUpdate();

            // Commit the transaction
            session.getTransaction().commit();
        }
    }

 /*   private String getSqlScript(String scriptName) {
        return new String(getClass().getClassLoader().getResourceAsStream(scriptName).readAllBytes());
    }

  */



    @Bean
    public DataSourceInitializer dataSourceInitializer() {
        DataSourceInitializer initializer = new DataSourceInitializer();
        initializer.setDataSource(dataSource);
        initializer.setDatabasePopulator(databasePopulator());
        return initializer;
    }

    private ResourceDatabasePopulator databasePopulator() {
        ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
        Resource sqlAccount = new ClassPathResource("data_account.sql");
        Resource sqlTask = new ClassPathResource("data_task.sql");
        Resource sqlEmployee = new ClassPathResource("data_employee.sql");
        Resource sqlProject = new ClassPathResource("data_project.sql");
        populator.addScript(sqlAccount);
        populator.addScript(sqlTask);
        populator.addScript(sqlEmployee);
        populator.addScript(sqlProject);
        return populator;
    }

}
