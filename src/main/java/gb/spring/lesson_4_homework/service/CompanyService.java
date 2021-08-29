package gb.spring.lesson_4_homework.service;

import gb.spring.lesson_4_homework.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CompanyService {

    private final CompanyRepository companyRepository;

    public boolean presenceInTheList(String comparable) {
        return companyRepository.presenceInTheList(comparable);
    }
}
