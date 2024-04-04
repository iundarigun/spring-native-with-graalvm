package br.com.devcave.graalvm.client;

import br.com.devcave.graalvm.domain.response.UniversityResponse;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "universityClient")
public interface UniversityClient {
  @GetMapping("/search")
  List<UniversityResponse> getUniversities(@RequestParam String country);
}
