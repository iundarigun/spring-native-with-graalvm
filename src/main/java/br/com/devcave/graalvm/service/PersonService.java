package br.com.devcave.graalvm.service;

import br.com.devcave.graalvm.domain.Person;
import br.com.devcave.graalvm.repository.PersonRepository;
import jakarta.annotation.PostConstruct;
import java.util.stream.IntStream;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PersonService {
  private final PersonRepository personRepository;

  public Person getById(final int id) {
    return personRepository.findById(id).orElse(null);
  }

  @Transactional
  public void save(final Person person) {
    personRepository.save(person);
  }

  @PostConstruct
  public void fillRepository() {
    personRepository.saveAll(IntStream.range(0, 10)
        .mapToObj(it -> new Person(null, "Person number " + it, "last name " + it, null, null, null))
        .toList());

  }
}
