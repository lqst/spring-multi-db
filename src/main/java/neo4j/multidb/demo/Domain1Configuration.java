package neo4j.multidb.demo;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.core.DatabaseSelection;
import org.springframework.data.neo4j.core.DatabaseSelectionProvider;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableNeo4jRepositories(basePackages = "neo4j.multidb.demo.repository1")
@EnableTransactionManagement
public class Domain1Configuration {

    @Bean
    DatabaseSelectionProvider databaseSelectionProvider1() {
        return () -> DatabaseSelection.byName("db1");
    }

}
