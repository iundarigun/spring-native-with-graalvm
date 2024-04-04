package br.com.devcave.graalvm.service;

import br.com.devcave.graalvm.domain.Person;
import br.com.devcave.graalvm.repository.PersonRepository;
import jakarta.annotation.PostConstruct;
import java.util.stream.IntStream;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonService {
  private final PersonRepository personRepository;

  public Person getById(final int id) {
    return personRepository.findById(id).orElse(null);
  }

  public void save(final Person person) {
    personRepository.save(person);
  }

  @PostConstruct
  public void fillRepository() {
    personRepository.saveAll(IntStream.range(0, 10)
        .mapToObj(it -> new Person(it, "Person number " + it, "last name " + it))
        .toList());

  }
}
