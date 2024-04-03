package br.com.devcave.graalvm.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Person{
  private int id;
  private String name;
}
