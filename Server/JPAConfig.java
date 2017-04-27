package saniya.egenProject;

import javax.sql.DataSource;

import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class JPAConfig {
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
		
		emf.setDataSource(dataSource());
		emf.setPackagesToScan("saniya.egenProject.entity");
		JpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
		emf.setJpaVendorAdapter(adapter);
		emf.setJpaProperties(properties());		
		
		return emf;
	}
	
	@Bean
	public PlatformTransactionManager txnManager(EntityManagerFactory emf)
	{
		JpaTransactionManager txnmgr = new JpaTransactionManager(emf);
		return txnmgr;
	}
	
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/example-db");
		ds.setUsername("root");
		ds.setPassword("root");
		return ds;
	}
	
	private Properties properties() {
		Properties prop = new Properties();
		prop.setProperty("hibernate.dialect","org.hibernate.dialect.MySQLDialect");
		prop.setProperty("hibernate.hbm2ddl.auto", "create");
		prop.setProperty("hibernate.show_sql", "true");
		prop.setProperty("hibernate.format_sql", "true");
		
		return prop;
	}
}
