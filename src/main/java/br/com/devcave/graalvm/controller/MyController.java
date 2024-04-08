package br.com.devcave.graalvm.controller;

import br.com.devcave.graalvm.client.UniversityClient;
import br.com.devcave.graalvm.domain.Person;
import br.com.devcave.graalvm.domain.mapper.PersonMapper;
import br.com.devcave.graalvm.domain.request.PersonRequest;
import br.com.devcave.graalvm.domain.response.PersonResponse;
import br.com.devcave.graalvm.domain.response.UniversityResponse;
import br.com.devcave.graalvm.service.PersonService;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("test")
public class MyController {

  private final PersonService personService;
  private final PersonMapper mapper;
  private final UniversityClient universityClient;
  private final KafkaTemplate<String, PersonResponse> kafkaTemplate;

  @GetMapping
  public String test() {
    return "test";
  }

  @GetMapping("{id}")
  public PersonResponse getById(@PathVariable int id) {
    final Person byId = personService.getById(id);

    return Optional.ofNullable(byId).map(mapper::toResponse).orElse(null);
  }

  @PostMapping
  public void postPerson(@RequestBody @Valid final PersonRequest person) {
    final Person saved = personService.save(mapper.toPerson(person));
    kafkaTemplate.send("person-topic", saved.getId().toString(), mapper.toResponse(saved));
  }

  @GetMapping("external-call")
  public List<UniversityResponse> externalCall(@RequestParam String country) {
    return universityClient.getUniversities(country);
  }
}
