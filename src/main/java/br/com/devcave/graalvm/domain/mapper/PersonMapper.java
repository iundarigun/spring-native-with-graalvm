package br.com.devcave.graalvm.domain.mapper;

import br.com.devcave.graalvm.domain.Person;
import br.com.devcave.graalvm.domain.request.PersonRequest;
import br.com.devcave.graalvm.domain.response.PersonResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PersonMapper {
  Person toPerson(PersonRequest request);

  PersonResponse toResponse(Person person);
}
