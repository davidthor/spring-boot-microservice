package com.example.microserviceexample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WebController {
  @Autowired
  private SigninRepository signinRepository;

  @GetMapping(path="/")
  public String getAllSignins(Model model) {
    Iterable<Signin> signins = signinRepository.findAll();
    model.addAttribute("signins", signins);
    return "index";
  }

  @PostMapping(path="/")
  public String newSignin(@RequestParam String name, Model model) {
    // Add a new item
    Signin obj = new Signin();
    obj.setName(name);
    signinRepository.save(obj);
    
    // Render the results
    Iterable<Signin> signins = signinRepository.findAll();
    model.addAttribute("signins", signins);
    return "index";
  }
}
