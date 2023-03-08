package org.example.service;

import org.example.dao.CarsDAO;
import org.example.dao.CarsDAOimpl;
import org.example.model.Cars;

import java.util.List;

public class CarsServiceimpl implements CarsService{
    private final CarsDAO carsDAO;

    public CarsServiceimpl() {carsDAO = new CarsDAOimpl();}
    @Override
    public void createCarsTable() {
        carsDAO.createCarsTable();
    }
    @Override
    public void dropCarsTable(){
        carsDAO.dropCarsTable();
    }
    @Override
    public void saveCar(String brand, String model, String carBodyType, int horsePower, int price) {
        carsDAO.saveCar(brand, model, carBodyType, horsePower, price);
    }
    @Override
    public void removeCarById(long id) {
        carsDAO.removeCarById(id);
    }
    @Override
    public Cars getCarById(long id) {
        return carsDAO.getCarById(id);
    }
    @Override
    public List<Cars> getAllCars() {
       return carsDAO.getAllCars();
    }
    @Override
    public void cleanCarsTable() {
        carsDAO.cleanCarsTable();
    }
}
