package gb.spring.lesson_4_homework;

import gb.spring.lesson_4_homework.properties.MyProperty;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({MyProperty.class})
public class Lesson4HomeworkApplication {

    public static void main(String[] args) {
        SpringApplication.run(Lesson4HomeworkApplication.class, args);
    }

}
