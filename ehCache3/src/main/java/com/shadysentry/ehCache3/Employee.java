package com.shadysentry.ehCache3;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee implements Serializable {

  private Long id;
  private String firstName;
  private String lastName;
}