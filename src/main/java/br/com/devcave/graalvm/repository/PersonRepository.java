package br.com.devcave.graalvm.repository;

import br.com.devcave.graalvm.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Integer> {
}
