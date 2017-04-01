package com.cestarcollege;
import com.cestarcollege.model.Pie;
import com.cestarcollege.model.PieRepository;
import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RestApiExampleApplication {

        private final Faker faker = new Faker();
	public static void main(String[] args) {
		SpringApplication.run(RestApiExampleApplication.class, args);
	}
        
        
        @Bean
        public CommandLineRunner initializeDb(PieRepository repository){
            return (args) -> {
                repository.deleteAll();
                for(int i =0;i<20;i++){
                 repository.save(new Pie(faker.lorem().word(), faker.lorem().sentence()));
                }
            };
        }
        
}
