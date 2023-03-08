package org.example.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;
@Getter @Setter @ToString @NoArgsConstructor
public class Cars {
    private long id;
    private String brand;
    private String model;
    private String carBodyType;
    private int horsePower;
    private int price;

    public Cars(String brand, String model, String carBodyType, byte horsePower, int price) {
        this.brand = brand;
        this.model = model;
        this.carBodyType = carBodyType;
        this.horsePower = horsePower;
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cars cars = (Cars) o;
        return id == cars.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
