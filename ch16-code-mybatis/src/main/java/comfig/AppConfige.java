package comfig;

import com.alibaba.druid.pool.DruidDataSource;
import com.github.pagehelper.PageInterceptor;
import org.apache.ibatis.logging.stdout.StdOutImpl;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import javax.swing.plaf.DimensionUIResource;
import java.util.Properties;

@Configuration
@PropertySource("classpath:db.properties")  //读取外部文件
@MapperScan("com.dao")   //mybatis-spring提供的扫描mapper接口用来创建实现类
@ComponentScan({"com.service","com.aspect"})  //扫描业务类
@EnableTransactionManagement                //开启事务功能
@EnableAspectJAutoProxy
public class AppConfige {
    @Value("jdbc:mysql://localhost:3306/demo")
    private String url;
    @Value("root")
    private String username;
    @Value("root")
    private String password;

    @Bean
    public DataSource dataSource(){
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUrl(url);
        druidDataSource.setUsername(username);
        druidDataSource.setPassword(password);
        return druidDataSource;
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource());

        PathMatchingResourcePatternResolver patternResolver = new PathMatchingResourcePatternResolver();
        Resource[] resources = patternResolver.getResources("classpath*:com/dao/mappers/*.xml");
        sqlSessionFactoryBean.setMapperLocations(resources);

        //处理配置信息，日志功能
        sqlSessionFactoryBean.setConfiguration(configuration());

        //配置分页用的插件
        sqlSessionFactoryBean.setPlugins(pageInterceptor());

        return sqlSessionFactoryBean.getObject();
    }


    @Bean
    public DataSourceTransactionManager txManager(){
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
        transactionManager.setDataSource(dataSource());
        return transactionManager;
    }


    private org.apache.ibatis.session.Configuration configuration(){
        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        //用哪个日志类输出，StdOutImpl这个类输出到控制台
        configuration.setLogImpl(StdOutImpl.class);
        //开启驼峰命名b_id---->b_Id
        configuration.setMapUnderscoreToCamelCase(true);
        return configuration;
    }

    private PageInterceptor pageInterceptor(){

        PageInterceptor pageInterceptor = new PageInterceptor();
        Properties properties = new Properties();

        properties.put("supportMethodsArguments","true");
        properties.put("reasonable","true");
        pageInterceptor.setProperties(properties);
        return pageInterceptor;
    }


}
