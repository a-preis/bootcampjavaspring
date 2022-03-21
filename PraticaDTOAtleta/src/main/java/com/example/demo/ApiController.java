package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class ApiController {

    @GetMapping("/findSports")
    public List<String> returnList() {
        return Service.getInstance().printListOfSports();
    }

    @GetMapping("/findSports/{name}")
    public int returnLevel(@PathVariable(name="name") String name) {
        return Service.getInstance().getLevelByName(name);
    }

    @GetMapping("/findSportsPersons")
    public List<PessoaDTO> returnSportsPerson() {
        return PessoaDTO.convert(Service.getInstance().getListOfPeople());
    }
}
