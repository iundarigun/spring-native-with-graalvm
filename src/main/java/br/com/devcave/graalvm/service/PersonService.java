package br.com.devcave.graalvm.service;

import br.com.devcave.graalvm.domain.Person;
import br.com.devcave.graalvm.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PersonService {
  private final PersonRepository personRepository;

  @Transactional(readOnly = true)
  public Person getById(final int id) {
    return personRepository.findById(id).orElse(null);
  }

  @Transactional
  public void save(final Person person) {
    personRepository.save(person);
  }
}
