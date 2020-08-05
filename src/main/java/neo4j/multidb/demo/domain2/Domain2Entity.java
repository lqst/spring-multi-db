package neo4j.multidb.demo.domain2;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Node
public class Domain2Entity {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private Domain2Entity() {
    };

    public Domain2Entity(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
