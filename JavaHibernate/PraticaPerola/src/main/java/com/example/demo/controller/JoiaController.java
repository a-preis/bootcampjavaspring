package com.example.demo.controller;

import com.example.demo.models.Joia;
import com.example.demo.models.JoiaDTO;
import com.example.demo.service.JoiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class JoiaController {

    @Autowired
    JoiaService joiaService;

    @PostMapping("/joia/inserir")
    public ResponseEntity<JoiaDTO> saveJoia(@Valid @RequestBody Joia joia) {
        Joia joiaSalva = joiaService.saveJoia(joia);
        JoiaDTO joiaDTO = new JoiaDTO(joiaSalva.getId(), "Joia Salva!");
        return new ResponseEntity(joiaDTO, HttpStatus.CREATED);
    }

    @GetMapping("/joias")
    public ResponseEntity<List<Joia>> listJoias(){
        List<Joia> listaJoias = joiaService.listJoias();
        return ResponseEntity.ok(listaJoias);
    }

    @DeleteMapping("joia/excluir")
    private ResponseEntity<JoiaDTO> deleteJoia(@RequestParam Integer id) {
        Optional<Joia> joia = joiaService.findJoiaById(id);
        JoiaDTO joiaDTO = new JoiaDTO(joia.get().getId(), "Joia excluída");
        return new ResponseEntity(joiaDTO, HttpStatus.OK);
    }

    @PatchMapping("joia/atualziar")
    public ResponseEntity<Joia> updateJoia(@RequestParam Integer id,
                                           @RequestBody Joia joia) {
        Joia joiaAtualizada = joiaService.updateJoiaById(joia, id);
        return new ResponseEntity<>(joiaAtualizada, HttpStatus.CREATED);
    }

}
