package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import static com.example.demo.Morse.converterEmPt;

@Controller
public class MyController {

    @GetMapping("/morse")
    @ResponseBody
    public String codigoMorse(@RequestParam String morse) {
        return converterEmPt(morse);
    }
}
