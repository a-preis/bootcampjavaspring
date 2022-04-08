package com.example.demo.service;

import com.example.demo.models.Joia;
import com.example.demo.repository.JoiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JoiaService {

    @Autowired
    JoiaRepository joiaRepository;

    public Joia saveJoia(Joia joia) {
        joiaRepository.save(joia);
        return joia;
    }

    public List<Joia> listJoias(){
        return joiaRepository.findAll();
    }

    public Optional<Joia> findJoiaById(Integer id) {
        return joiaRepository.findById(id);
    }

    public Integer deleteJoia(Joia joia) {
        joiaRepository.delete(joia);
        return joia.getId();
    }

    public Joia updateJoiaById(Joia joia, Integer id) {
        Joia joiaUpdate = joiaRepository.findById(id).get();
        joiaUpdate.setMaterial(joia.getMaterial());
        joiaUpdate.setPeso(joia.getPeso());
        joiaUpdate.setQuilates(joia.getQuilates());
        return joiaRepository.save(joiaUpdate);
    }

}
