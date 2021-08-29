package gb.spring.lesson_4_homework.model;

import gb.spring.lesson_4_homework.validation.Company;
import gb.spring.lesson_4_homework.validation.LowerCase;
import lombok.*;

import javax.validation.constraints.*;

@Data
@Builder
@AllArgsConstructor
public class Product {


    private Long id;

    @NonNull
    @NotEmpty
    @Size(min = 1, max = 10, message = "size not correct")
    @LowerCase
    private String title;

    @NotNull
    @NotEmpty
    @Company
    private String company;

    @NotNull
    @Min(value = 5, message = "to low")
    @Positive
    private Integer cost;

}
