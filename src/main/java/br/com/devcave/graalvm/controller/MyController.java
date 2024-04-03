package br.com.devcave.graalvm.controller;

import br.com.devcave.graalvm.domain.Person;
import br.com.devcave.graalvm.domain.request.PersonRequest;
import br.com.devcave.graalvm.domain.response.PersonResponse;
import br.com.devcave.graalvm.service.PersonService;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("test")
public class MyController {

  private final PersonService personService;

  @GetMapping
  public String test() {
    return "test";
  }

  @GetMapping("{id}")
  public PersonResponse getById(@PathVariable int id) {
    final Person byId = personService.getById(id);

    return Optional.ofNullable(byId).map(it -> new PersonResponse(it.getId(), it.getName(), it.getLastName())).orElse(null);
  }

  @PostMapping
  public void postPerson(@RequestBody @Valid final PersonRequest person) {
    personService.save(new Person(person.getId(), person.getName(), person.getLastName()));
  }
}
