import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.WebApplicationInitializer;

import javax.sql.DataSource;

@SpringBootApplication
//springboot中开启事务注解很简单，首先在Application类上标注@EnableTransactionManagement 注解，接着在访问Service方法上标注@Transactional注解即可。
//通过@EnableTransactionManagement注解，Boot为应用应用自动装配了事务支持。这对用户并不透明，用户如果想自己定义事务管理器，则在Application类中添加一个即可
@EnableTransactionManagement

//在springboot中配置MVC很简单，只需要Application类继承Spring Boot提供的Servlet初始化器SpringBootServletInitializer，重写SpringBootServletInitializer的configure()方法。·
public class Application extends SpringBootServletInitializer implements WebApplicationInitializer {
    @Bean
    public PlatformTransactionManager txManager(@Qualifier("dataSource") DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }

    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }
    public static void main(String[] args) throws Exception{
        SpringApplication.run(Application.class,args);
    }
}
