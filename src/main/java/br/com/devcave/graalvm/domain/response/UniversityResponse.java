package br.com.devcave.graalvm.domain.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class UniversityResponse {
  private final String country;
  private final List<String> domains;
  private final List<String> webPages;
  private final String alphaTwoCode;
  private final String name;
}
