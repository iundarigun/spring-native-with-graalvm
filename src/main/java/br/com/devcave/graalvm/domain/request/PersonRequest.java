package br.com.devcave.graalvm.domain.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class PersonRequest {
  @Positive
  private final int id;
  @NotBlank
  private final String name;
}
