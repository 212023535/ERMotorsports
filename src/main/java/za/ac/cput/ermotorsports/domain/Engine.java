package za.ac.cput.ermotorsports.domain;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by Rudi.Zeeman on 13.10.15.
 */

@Entity
public final class Engine
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String cubicCapacity;
    private String units;
    private String cylinders;
    private String price;
    private String brand;
    private String model;


    private Engine()
    {

    }

    private Engine(Build build)
    {
        id = build.id;
        cubicCapacity = build.cubicCapacity;
        units = build.units;
        cylinders = build.cylinders;
        price = build.price;
        brand = build.brand;
        model = build.model;
    }

    public static class Build
    {
        private Long id;
        private String cubicCapacity;
        private String units;
        private String cylinders;
        private String price;
        private String brand;
        private String model;

        public Build copy(Engine engine)
        {
            this.id = engine.id;
            this.cubicCapacity = engine.cubicCapacity;
            this.units = engine.units;
            this.cylinders = engine.cylinders;
            this.price = engine.price;
            this.brand = engine.brand;
            this.model = engine.model;

            return this;
        }

        //Mandatory Builder
        public Build(String brand){this.brand = brand;}

        //Setters
        public Build id(Long id)
        {
            this.id = id;
            return this;
        }

        public Build cubicCapacity(String cubicCapacity)
        {
            this.cubicCapacity = cubicCapacity;
            return this;
        }

        public Build units(String units)
        {
            this.units = units;
            return this;
        }

        public Build cylinders(String cylinders)
        {
            this.cylinders = cylinders;
            return this;
        }

        public Build price(String price)
        {
            this.price = price;
            return this;
        }

        public Build model(String model)
        {
            this.model = model;
            return this;
        }

        public Engine build(){return new Engine(this);}
    }

    //Getters
    public Long getId() {
        return id;
    }

    public String getCubicCapacity() {
        return cubicCapacity;
    }

    public String getUnits() {
        return units;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getCylinders() {
        return cylinders;
    }

    public String getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Engine engine = (Engine) o;

        return id.equals(engine.id);

    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "Engine{" +
                "cubicCapacity='" + cubicCapacity + '\'' +
                ", units='" + units + '\'' +
                ", cylinders='" + cylinders + '\'' +
                ", price='" + price + '\'' +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                '}';
    }
}
