package org.example.dao;

import org.example.model.Cars;

import java.util.List;

public interface CarsDAO {
    void createCarsTable();
    void dropCarsTable();
    void saveCar(String brand, String model, String carBodyType, int horsePower, int price);
    void removeCarById(long id);
    Cars getCarById(long id);
    List<Cars> getAllCars();
    void cleanCarsTable();
}
