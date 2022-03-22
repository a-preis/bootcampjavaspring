package com.example.demo.MyController;

import com.example.demo.DTO.VehicleDTO;
import com.example.demo.Modules.Vehicle;
import com.example.demo.Service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class MyController {

    @Autowired
    private Service vehicleService;

    public MyController() {
        System.out.println("Criando objetos da classe " + this.getClass().getName());
        // AutoWired faz isso pra mim:
        //vehicleService = new Service();
    }

    @PostMapping("/v1/api/veiculos/")
    public ResponseEntity<VehicleDTO> saveVehicle(@RequestBody VehicleDTO vehicledto, UriComponentsBuilder uriBuilder){
        Vehicle v = vehicledto.convert();
        vehicleService.save(v);
        URI uri = uriBuilder
                        .path("/v1/api/veiculos/{id}")
                        .buildAndExpand(v.getId())
                        .toUri();
        return ResponseEntity.created(uri).body(vehicledto);
    }

    @GetMapping("/v1/api/veiculos/")
    public ResponseEntity<List<VehicleDTO>> listVehicles() {
        List<VehicleDTO> result = VehicleDTO.convert(vehicleService.listAll());
        return ResponseEntity.ok(result);
    }

    @GetMapping("/v1/api/veiculos/{id}")
    public ResponseEntity<VehicleDTO> findVehicle(@PathVariable (name = "id") int id) {
        VehicleDTO dto = new VehicleDTO();

        VehicleDTO result = dto.convert(vehicleService.listById(id));
        return ResponseEntity.ok(result);
    }

    @GetMapping("/v1/api/veiculos/dates")
    public ResponseEntity<List<VehicleDTO>> listByDate (@RequestParam String since,
                            @RequestParam String to) {
        VehicleDTO dto = new VehicleDTO();
        List<Vehicle> list = vehicleService.listByDate(since, to);
        List<VehicleDTO> result = dto.convert(list);
        return ResponseEntity.ok(result);
    }

    @GetMapping ("/v1/api/veiculos/prices")
    public ResponseEntity<List<VehicleDTO>> returnByPrice(@RequestParam String since,
                                          @RequestParam String to) {
        VehicleDTO dto = new VehicleDTO();
        List<VehicleDTO> result = dto.convert(vehicleService.listByPrice(since, to));
        return ResponseEntity.ok(result);
    }

}
