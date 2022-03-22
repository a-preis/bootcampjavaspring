package com.example.demo.DTO;

import com.example.demo.Modules.Vehicle;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VehicleDTO {

    private String brand;
    private String model;
    private LocalDate manufacturingDate;
    private int numberOfKilometers;
    private int doors;
    private BigDecimal price;
    private String currency;
    private List<Object> services;
    private int countOfOwners;

        public Vehicle convert() {
            return new Vehicle(0, this.brand, this.model, this.manufacturingDate, this.numberOfKilometers, this.doors
                    , this.price , this.currency, this.services, this.countOfOwners);
    }

    public VehicleDTO convert(Vehicle vehicle){
        this.brand = vehicle.getBrand();
        this.model = vehicle.getModel();
        this.manufacturingDate = vehicle.getManufacturingDate();
        this.numberOfKilometers = vehicle.getNumberOfKilometers();
        this.doors = vehicle.getDoors();
        this.price = vehicle.getPrice();
        this.currency = vehicle.getCurrency();
        this.services = vehicle.getServices();
        this.countOfOwners = vehicle.getCountOfOwners();
        return this;
    }

    public static List<VehicleDTO> convert(List<Vehicle> vehicles) {
       return vehicles.stream().map(a-> new VehicleDTO(a.getBrand(), a.getModel(), a.getManufacturingDate()
               , a.getNumberOfKilometers(), a.getDoors(), a.getPrice(), a.getCurrency(), a.getServices() , a.getCountOfOwners()))
                   .collect(Collectors.toList());
    }
}
