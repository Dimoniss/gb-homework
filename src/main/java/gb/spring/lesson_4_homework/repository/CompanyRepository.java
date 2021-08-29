package gb.spring.lesson_4_homework.repository;

import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class CompanyRepository {
    private final Map<String, String> manufactureDb;

    public CompanyRepository() {
        this.manufactureDb = new ConcurrentHashMap<>();
        manufactureDb.put("Jonson", "Jonson");
        manufactureDb.put("Sony", "Sony");
        manufactureDb.put("Sputnik", "Sputnik");
        manufactureDb.put("Mask", "Mask");

    }

    public boolean presenceInTheList(String comparable) {
        String value = manufactureDb.get(comparable);
        return value != null;
    }

}
