package com.example.microserviceexample;

import org.springframework.data.repository.CrudRepository;
import com.example.microserviceexample.Signin;

public interface SigninRepository extends CrudRepository<Signin, Integer> {
  
}
