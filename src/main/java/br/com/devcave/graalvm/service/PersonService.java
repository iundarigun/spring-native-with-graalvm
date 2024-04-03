package br.com.devcave.graalvm.service;

import br.com.devcave.graalvm.domain.Person;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
  private static final List<Person> persons =
      new ArrayList<>(IntStream.range(0, 10).mapToObj(it -> new Person(it, "Person number " +it)).toList());

  public Person getById(final int id) {
    return persons.stream().filter(it -> it.getId() == id).findFirst().orElse(null);
  }

  public void save(final Person person) {
    persons.add(person);
  }
}
