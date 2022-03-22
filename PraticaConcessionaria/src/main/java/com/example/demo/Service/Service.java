package com.example.demo.Service;

import com.example.demo.Modules.Vehicle;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@org.springframework.stereotype.Service
public class Service {

    private static List<Vehicle> vehicles = new ArrayList<Vehicle>();
    //Collections.synchronizedList(
    private boolean vehicleExists(Vehicle vehicle) {
        return vehicles.stream()
                .anyMatch(a -> a.getId() == vehicle.getId() && a.getPrice().equals(vehicle.getPrice()));
    }

    public synchronized void save(Vehicle vehicle) {
        if (vehicleExists(vehicle)){
            System.out.println("veículo já existe");
        }
        vehicles.add(vehicle);
        System.out.println(vehicles.size());
        System.out.println(vehicles.get(0).getManufacturingDate());
    }

    public List<Vehicle> listAll() {
        return vehicles;
    }

    public Vehicle listById(int id){
        return vehicles.stream()
                .filter(a -> a.getId() == id)
                .findFirst()
                .get();
    }

    public List<Vehicle> listByDate(String since, String to){
        LocalDate sinceDate = fromStringToLocalDate(since);
        LocalDate toDate = fromStringToLocalDate(to);
        System.out.println(vehicles.get(0).getManufacturingDate());
        return vehicles.stream()
                .filter(a -> a.getManufacturingDate().getYear() >= sinceDate.getYear())
                .filter(a->a.getManufacturingDate().getYear() < toDate.getYear())
                .collect(Collectors.toList());

    }

    public LocalDate fromStringToLocalDate(String s) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return LocalDate.parse(s, formatter);
    }

    public List<Vehicle> listByPrice(String since, String to) {
        Integer priceSince = Integer.valueOf(since);
        Integer priceTo = Integer.valueOf(to);
        return vehicles.stream()
                .filter(a->a.getPrice().intValue() >= priceSince && a.getPrice().intValue() < priceTo)
                .collect(Collectors.toList());
    }

//    public synchronized List<Anuncio> lista(String categoria, Double preco){
//        if(categoria!=null && !categoria.isEmpty() && preco!=null) {
//            return anuncios.stream()
//                    .filter(a->a.getCategoria().equalsIgnoreCase(categoria))
//                    .filter(a->a.getValor()<=preco)
//                    .collect(Collectors.toList());
//        }
//        if(categoria!=null && !categoria.isEmpty()) {
//            return anuncios.stream()
//                    .filter(a->a.getCategoria().equalsIgnoreCase(categoria))
//                    .collect(Collectors.toList());
//        }
//        if(preco!=null) {
//            return anuncios.stream()
//                    .filter(a->a.getValor()<=preco)
//                    .collect(Collectors.toList());
//        }
//
//        return anuncios;
//    }


}
