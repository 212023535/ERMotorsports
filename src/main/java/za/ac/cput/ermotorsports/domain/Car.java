package za.ac.cput.ermotorsports.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by Rudi.Zeeman on 13.10.15.
 */
@Entity
public class Car implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String brand;
    private String year;
    private String model;
    private String colour;

    private Car() {
    }

    public Car(Builder builder) {
        this.id=builder.id;
        this.brand=builder.brand;
        this.year=builder.year;
        this.model=builder.model;
        this.colour=builder.colour;
    }

    public static class Builder{
        private Long id;
        private String brand;
        private String year;
        private String model;
        private String colour;

        public Builder(String brand) {
            this.brand = brand;
        }

        public Builder id(Long value){
            this.id=value;
            return this;
        }

        public Builder year(String value){
            this.year=value;
            return this;
        }

        public Builder model(String value){
            this.model=value;
            return this;
        }

        public Builder colour(String value){
            this.colour=value;
            return this;
        }

        public Builder copy(Car value){
            this.id=value.id;
            this.brand=value.brand;
            this.year=value.year;
            this.model=value.model;
            this.colour=value.colour;
            return this;
        }

        public Car build(){
            return new Car(this);
        }

    }

    public Long getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public String getYear() {
        return year;
    }

    public String getModel() {
        return model;
    }

    public String getColour() {
        return colour;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        return id.equals(car.id);

    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", year='" + year + '\'' +
                ", model='" + model + '\'' +
                ", colour='" + colour + '\'' +
                '}';
    }
}