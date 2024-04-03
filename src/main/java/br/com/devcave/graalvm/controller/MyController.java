package br.com.devcave.graalvm.controller;

import br.com.devcave.graalvm.domain.Person;
import java.util.List;
import java.util.stream.IntStream;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class MyController {

  private static final List<Person> persons =
      IntStream.range(0, 10).mapToObj(it -> new Person(it, "Person number " + it)).toList();

  @GetMapping
  public String test() {
    return "test";
  }

  @GetMapping("{id}")
  public Person getById(@PathVariable int id) {
    return persons.stream().filter(it -> it.id() == id).findFirst().orElse(null);
  }
}
