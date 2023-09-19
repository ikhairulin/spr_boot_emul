package com.example.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@SpringBootApplication
@RestController
public class MockApplication {

   public static void main(String[] args) {
      SpringApplication.run(MockApplication.class, args);
   }

   @GetMapping("/ok")
   public String ok() {
      return "Hello World!";
   }

   @PostMapping("/api/test")
   public ResponseData handleRequest(@RequestBody RequestData requestData) {

      ResponseData responseData = new ResponseData();
      responseData.setMessage("Здравствуйте, " + requestData.getName() + "! Сумма ваших чисел " + requestData.calcSumNumbers());

      return responseData;
   }

}
