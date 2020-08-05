package neo4j.multidb.demo.repository2;


import neo4j.multidb.demo.domain2.Domain2Entity;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface Domain2Repository extends Neo4jRepository<Domain2Entity, Long> {
    Iterable<Domain2Entity> findAll();
}
