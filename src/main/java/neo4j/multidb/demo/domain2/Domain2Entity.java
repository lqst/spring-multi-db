package neo4j.multidb.demo.domain2;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
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
