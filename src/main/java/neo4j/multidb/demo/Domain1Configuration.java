package neo4j.multidb.demo;


import org.neo4j.driver.AuthTokens;
import org.neo4j.driver.Driver;
import org.neo4j.driver.GraphDatabase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.core.DatabaseSelection;
import org.springframework.data.neo4j.core.transaction.Neo4jTransactionManager;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableNeo4jRepositories(basePackages = "neo4j.multidb.demo.repository1", transactionManagerRef = "tm1")
@EnableTransactionManagement
public class Domain1Configuration {

    private final Driver driver;

    public Domain1Configuration(Driver driver) {
        this.driver = driver;
    }

    @Bean
    Neo4jTransactionManager tm1() {
        return new Neo4jTransactionManager(driver, () -> DatabaseSelection.byName("db1"));
    }

}
