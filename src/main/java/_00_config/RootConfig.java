package _00_config;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan(basePackages = { "com.ctbc.dao.**" , "com.ctbc.service.**"  })
public class RootConfig {

	@Bean
	public DataSource driverManagerDatasource() {
//		db.sqlite.url = emp_dept.db
//		db.sqlite.driverClassName = org.sqlite.JDBC
		System.out.println("======= 建立DriverManagerDataSource ========");
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setUrl("jdbc:sqlite:" + System.getProperty("user.dir") + "/" + "testDB.db");
		ds.setDriverClassName("org.sqlite.JDBC");
		return ds;
	}

	@Bean
	public JdbcTemplate jdbcTemplate(DataSource ds) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(ds);
		return jdbcTemplate;
	}

	public static void main(String[] args) throws SQLException {
		ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(RootConfig.class);
		DataSource ds = context.getBean(DataSource.class);
		try {
			Connection conn = ds.getConnection();
			String dbProduct = conn.getMetaData().getDatabaseProductName();
			System.out.println("dbProduct : " + dbProduct);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		context.close();
	}
}
