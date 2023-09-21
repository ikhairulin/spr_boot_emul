package com.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@SpringBootApplication
@RestController
public class Main {

   public static void main(String[] args) {
      SpringApplication.run(Main.class, args);
   }

   @GetMapping("/ok")
   public String ok() {
      return "Hello World!";
   }

   @GetMapping("/test")
   public String test() {
      return "Привет! Я умею складывать целые числа. Пришли мне данные методом POST в формате json по типу " +
              "{\"name\": \"John Silver\", \"first_num\": \"5\", \"second_num\": \"2\"}" +
              " и получишь ответ";
   }

   @PostMapping("/test")
   public ResponseData handleRequest(@RequestBody RequestData request) {

      ResponseData response = new ResponseData();
      response.setMessage("Здравствуйте, " + request.getName() + "! " + request.calcSumNumbers());

      return response;
   }

}
