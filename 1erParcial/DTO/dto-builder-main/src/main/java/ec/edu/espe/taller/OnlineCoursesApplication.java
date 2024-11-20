package ec.edu.espe.taller;

import ec.edu.espe.taller.entities.Course;
import ec.edu.espe.taller.entities.Subscription;
import ec.edu.espe.taller.entities.User;
import ec.edu.espe.taller.repositories.CourseRepository;
import ec.edu.espe.taller.repositories.SubscriptionRepository;
import ec.edu.espe.taller.repositories.UserRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication
public class OnlineCoursesApplication {

    public static void main(String[] args) {
        SpringApplication.run(OnlineCoursesApplication.class, args);
    }

    @Bean
    CommandLineRunner initData(UserRepository userRepository,
            CourseRepository courseRepository,
            SubscriptionRepository subscriptionRepository) {
        return args -> {
            // Crear Usuarios
            User admin = userRepository.save(User.builder()
                    .firstName("Admin")
                    .lastName("User")
                    .email("admin@admin.com")
                    .password("12345678")
                    .userType("ADMIN")
                    .build());

            User creator1 = userRepository.save(User.builder()
                    .firstName("John")
                    .lastName("Doe")
                    .email("john.doe@creator.com")
                    .password("creator123")
                    .userType("CREATOR")
                    .build());

            User creator2 = userRepository.save(User.builder()
                    .firstName("Jane")
                    .lastName("Smith")
                    .email("jane.smith@creator.com")
                    .password("creator123")
                    .userType("CREATOR")
                    .build());

            User consumer1 = userRepository.save(User.builder()
                    .firstName("Alice")
                    .lastName("Brown")
                    .email("alice.brown@consumer.com")
                    .password("consumer123")
                    .userType("CONSUMER")
                    .build());

            User consumer2 = userRepository.save(User.builder()
                    .firstName("Bob")
                    .lastName("White")
                    .email("bob.white@consumer.com")
                    .password("consumer123")
                    .userType("CONSUMER")
                    .build());

            // Crear Cursos
            Course course1 = courseRepository.save(Course.builder()
                    .name("Java Programming")
                    .description("Learn Java from scratch")
                    .state("ACTIVE")
                    .creator(creator1)
                    .build());

            Course course2 = courseRepository.save(Course.builder()
                    .name("Spring Boot Masterclass")
                    .description("Master Spring Boot development")
                    .state("IN_CONSTRUCTION")
                    .creator(creator1)
                    .build());

            Course course3 = courseRepository.save(Course.builder()
                    .name("Frontend Development")
                    .description("Learn HTML, CSS, and JavaScript")
                    .state("ACTIVE")
                    .creator(creator2)
                    .build());

            Course course4 = courseRepository.save(Course.builder()
                    .name("Data Science Basics")
                    .description("Introduction to Data Science")
                    .state("ACTIVE")
                    .creator(creator2)
                    .build());

            // Crear Suscripciones
            subscriptionRepository.save(Subscription.builder()
                    .user(consumer1)
                    .course(course1)
                    .subscriptionDate(LocalDateTime.now())
                    .build());

            subscriptionRepository.save(Subscription.builder()
                    .user(consumer1)
                    .course(course3)
                    .subscriptionDate(LocalDateTime.now())
                    .build());

            subscriptionRepository.save(Subscription.builder()
                    .user(consumer2)
                    .course(course1)
                    .subscriptionDate(LocalDateTime.now())
                    .build());

            subscriptionRepository.save(Subscription.builder()
                    .user(consumer2)
                    .course(course4)
                    .subscriptionDate(LocalDateTime.now())
                    .build());

            // Mostrar Datos Iniciales
            System.out.println("Admin creado: " + admin);
            System.out.println("Creadores creados: " + creator1 + ", " + creator2);
            System.out.println("Consumidores creados: " + consumer1 + ", " + consumer2);
            System.out.println("Cursos creados: " + course1 + ", " + course2 + ", " + course3 + ", " + course4);
            System.out.println("Suscripciones creadas: ");
            subscriptionRepository.findAll().forEach(System.out::println);
        };
    }
}