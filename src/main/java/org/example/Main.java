package org.example;

import org.example.dao.CarsDAOimpl;
import org.example.service.CarsService;
import org.example.service.CarsServiceimpl;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        CarsService carsService = new CarsServiceimpl();
        carsService.dropCarsTable();
        carsService.createCarsTable();
        carsService.saveCar("KIA", "K5", "Sedan", (int) 194, (int) 2759794);
        carsService.saveCar("HYUNDAI", "SONATA", "Sedan", (int) 179, (int) 5047640);
        carsService.saveCar("HYUNDAI", "SANTAFE", "Universal", (int) 180, (int) 4364100);
        carsService.saveCar("BMW", "X5", "Crossover", (int) 306, (int) 8619166);
        carsService.saveCar("TOYOTA", "LAND_CRUISER150", "Crossover", (int) 249, (int) 7879000);
        carsService.getAllCars();
        carsService.removeCarById(5);
        carsService.getCarById(4);
    }
}