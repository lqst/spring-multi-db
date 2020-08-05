package neo4j.multidb.demo.domain1;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
public class Domain1Entity {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private Domain1Entity() {
    };

    public Domain1Entity(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
