package com.example.test.controller;

import com.example.test.servis.CalculatorServis;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.util.Objects;

@RestController
@RequestMapping("/calculator")
  public class CalculatorController {
        private final CalculatorServis calculatorServis;

        public CalculatorController(CalculatorServis calculatorServis) {
                this.calculatorServis = calculatorServis;
        }

        @GetMapping(produces = MediaType.TEXT_HTML_VALUE)
        public String greetings() {
                return " <h1>Добро пожаловать в калькулятор!</h1>";
        }

        @GetMapping("/plus")
        public String plus(@RequestParam(value = "num1", required = false) Integer a,
                           @RequestParam(value = "num2", required = false) Integer b) {
                if (Objects.isNull(a) || Objects.isNull(b)) {
                        return "надо передать два параметра ";
                }
                return buildResult(a, b, calculatorServis.plus(a, b), "+");

        }


        @GetMapping("/minus")
        public String minus(@RequestParam(value = "num1", required = false) Integer a,
                            @RequestParam(value = "num2", required = false) Integer b) {
                if (Objects.isNull(a) || Objects.isNull(b)) {
                        return "надо передать два параметра ";
                }
                return buildResult(a, b, calculatorServis.minus(a, b), "-");

        }

        @GetMapping("/umnogit")
        public String umnogit(@RequestParam(value = "num1", required = false) Integer a,
                              @RequestParam(value = "num2", required = false) Integer b) {
                if (Objects.isNull(a) || Objects.isNull(b)) {
                        return "надо передать два параметра ";
                }
                return buildResult(a, b, calculatorServis.umnogit(a, b), "*");
        }


        @GetMapping("/podelit")
        public String podelit(@RequestParam(value = "num1", required = false) Integer a,
                              @RequestParam(value = "num2", required = false) Integer b) {
                if (Objects.isNull(a) || Objects.isNull(b)) {
                        return "надо передать два параметра ";
                }
                return buildResult(a, b, calculatorServis.podelit(a, b), "/");

        }

        private String buildResult(Number a, Number b, Number result, String operation) {
                return String.format("%s %s %s=%s",a,operation,b,result);
        }
}


