package neo4j.multidb.demo.repository1;


import neo4j.multidb.demo.domain1.Domain1Entity;
import org.springframework.context.annotation.Bean;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface Domain1Repository extends Neo4jRepository<Domain1Entity, Long> {

}
