package org.example.dao;

import org.example.model.Cars;
import org.example.util.Util;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CarsDAOimpl implements CarsDAO{
    @Override
    public void createCarsTable(){
        try (Statement statement = Util.getconnection().createStatement()) {
            statement.execute("CREATE TABLE IF NOT EXISTS cars (id BIGINT PRIMARY KEY AUTO_INCREMENT,"+
                    "Brand VARCHAR(20), Model VARCHAR(20), Carbodytype VARCHAR(20), Horsepower INT,"+
                    "Price INT)");
            System.out.println("Таблица cars успешно добавлена в базу данных");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void dropCarsTable(){
        try (Statement statement = Util.getconnection().createStatement()){
            statement.execute("DROP TABLE IF EXISTS cars");
            System.out.println("База данных cars успешно удалена");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void saveCar(String brand, String model, String carBodyType, int horsePower, int price){
        try (PreparedStatement statement = Util.getconnection()
                .prepareStatement("INSERT INTO cars (Brand, Model, Carbodytype, Horsepower, Price)"+
                        " VALUES (?,?,?,?,?)")){
            statement.setString(1, brand);
            statement.setString(2, model);
            statement.setString(3, carBodyType);
            statement.setInt(4, horsePower);
            statement.setInt(5, price);
            statement.execute();
            System.out.println("Автомобиль " + brand + " " + model + " успешно добавлен в таблицу cars" );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void removeCarById(long id) {
        try (PreparedStatement statement = Util.getconnection()
                .prepareStatement("DELETE FROM cars WHERE id = ?")){
            statement.setLong(1, id);
            statement.execute();
            System.out.println("Автомобиль с id " + id + " успешно удален");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public Cars getCarById(long id){
        try (PreparedStatement statement = Util.getconnection()
                .prepareStatement("SELECT * FROM cars WHERE ID = ?")){
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            Cars cars = new Cars();
            cars.setId(resultSet.getInt(1));
            cars.setBrand(resultSet.getString(2));
            cars.setModel(resultSet.getString(3));
            cars.setCarBodyType(resultSet.getString(4));
            cars.setHorsePower(resultSet.getInt(5));
            cars.setPrice(resultSet.getInt(6));
            System.out.println(cars);
            return cars;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public List<Cars> getAllCars(){
        List<Cars> carsList = new ArrayList<>();
        try (ResultSet resultSet = Util.getconnection().createStatement().executeQuery("SELECT * FROM cars")){
            while (resultSet.next()){
                Cars cars = new Cars();
                cars.setId(resultSet.getInt(1));
                cars.setBrand(resultSet.getString(2));
                cars.setModel(resultSet.getString(3));
                cars.setCarBodyType(resultSet.getString(4));
                cars.setHorsePower(resultSet.getInt(5));
                cars.setPrice(resultSet.getInt(6));
                carsList.add(cars);
                System.out.println(cars);
            }
            return carsList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void cleanCarsTable(){
        try (Statement statement = Util.getconnection().createStatement()){
            statement.execute("TRUNCATE TABLE cars");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
