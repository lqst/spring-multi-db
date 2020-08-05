package neo4j.multidb.demo;

import neo4j.multidb.demo.domain1.Domain1Entity;
import neo4j.multidb.demo.domain2.Domain2Entity;
import neo4j.multidb.demo.repository1.Domain1Repository;
import neo4j.multidb.demo.repository2.Domain2Repository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
@EnableAutoConfiguration
public class DemoApplication {


	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);



	}

	@Transactional
	@Bean
	CommandLineRunner demo(Domain1Repository domain1Repository, Domain2Repository domain2Repository) {
		return args -> {

			domain1Repository.deleteAll();
			domain2Repository.deleteAll();
			Domain1Entity db1 = new Domain1Entity("Hello db1");
			Domain2Entity db2 = new Domain2Entity("Hello db2");
			domain1Repository.save(db1);
			domain2Repository.save(db2);

		};
	}

}
