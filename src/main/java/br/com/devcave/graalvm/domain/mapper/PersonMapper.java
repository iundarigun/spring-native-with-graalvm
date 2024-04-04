package br.com.devcave.graalvm.domain.mapper;

import br.com.devcave.graalvm.domain.Person;
import br.com.devcave.graalvm.domain.request.PersonRequest;
import br.com.devcave.graalvm.domain.response.PersonResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PersonMapper {
  @Mapping(target = "id", ignore = true)
  Person toPerson(PersonRequest request);

  PersonResponse toResponse(Person person);
}
