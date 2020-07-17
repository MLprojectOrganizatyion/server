package ci.microservice.notification;

import ci.microservice.notification.machineLearning.dao.AdresseMailRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.Configuration;


@SpringBootApplication
@Configuration
public class NotificationApplication {

    public static void main(String[] args) {

        SpringApplication.run(NotificationApplication.class, args);
    }

//    @Bean
//    CommandLineRunner runner(AdresseMailRepository adresseMailRepository) {
//        return new CommandLineRunner() {
//            @Override
//            public void run(String... args) throws Exception {
//                adresseMailRepository.deleteAll();
//                adresseMailRepository.saveAll(
//                        List.of(
//                                new AdresseMail("mouna89@gmail.com")
//                        )
//                );
//
//            }
//        };
//    }

//    @Bean
//    public ApplicationRunner runner() {
//        return new Runner();
//    }
}
