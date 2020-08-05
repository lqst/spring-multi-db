package neo4j.multidb.demo;

import org.neo4j.ogm.config.ClasspathConfigurationSource;
import org.neo4j.ogm.config.ConfigurationSource;
import org.neo4j.ogm.session.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.transaction.Neo4jTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableNeo4jRepositories(basePackages = "neo4j.multidb.demo.repository1", sessionFactoryRef = "sessionFactory1", transactionManagerRef = "transactionManager1")
@EnableTransactionManagement
public class Domain1Configuration {
    @Bean
    public SessionFactory sessionFactory1() {
        // with domain entity base package(s)
        return new SessionFactory(configuration1(), "neo4j.multidb.demo.domain1");
    }

    @Bean
    public org.neo4j.ogm.config.Configuration configuration1() {
        ConfigurationSource properties = new ClasspathConfigurationSource("db1.properties");
        return new org.neo4j.ogm.config.Configuration.Builder(properties).build();
    }

    @Bean
    public Neo4jTransactionManager transactionManager1() {
        return new Neo4jTransactionManager(sessionFactory1());
    }
}
