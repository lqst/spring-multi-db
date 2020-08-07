package neo4j.multidb.demo;


import org.neo4j.driver.Driver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.core.DatabaseSelection;
import org.springframework.data.neo4j.core.transaction.Neo4jTransactionManager;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableNeo4jRepositories(basePackages = "neo4j.multidb.demo.repository2", transactionManagerRef = "tm2")
@EnableTransactionManagement
public class Domain2Configuration {

    private final Driver driver;

    public Domain2Configuration(Driver driver) {
        this.driver = driver;
    }

    @Bean
    Neo4jTransactionManager tm2() {
        return new Neo4jTransactionManager(driver,  () -> DatabaseSelection.byName("db2"));
    }


}
