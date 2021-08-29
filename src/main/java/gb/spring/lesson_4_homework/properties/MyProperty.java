package gb.spring.lesson_4_homework.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "my")
@Data
@Component
public class MyProperty {
    private String name;
    private Integer age;
    private String email;

}
