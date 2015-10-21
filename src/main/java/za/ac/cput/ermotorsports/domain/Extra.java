package za.ac.cput.ermotorsports.domain;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by Rudi.Zeeman on 13.10.15.
 */
@Entity
public final class Extra
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String brand;
    private String price;
    private String units;
    private String description;

    private Extra()
    {

    }

    private Extra(Build build)
    {
        id = build.id;
        brand = build.brand;
        price = build.price;
        units = build.units;
        description = build.description;
    }

    public static class Build
    {
        private Long id;
        private String brand;
        private String price;
        private String units;
        private String description;

        public Build copy(Extra extra)
        {
            this.id = extra.id;
            this.brand = extra.units;
            this.price = extra.price;
            this.units = extra.units;
            this.description = extra.description;

            return this;
        }

        //Mandatory Builder
        public Build(String brand){this.brand = brand;}

        //Getters
        public Build id(Long id)
        {
            this.id = id;
            return this;
        }

        public Build price(String price)
        {
            this.price = price;
            return this;
        }

        public Build units(String units)
        {
            this.units = units;
            return this;
        }

        public Build description(String description)
        {
            this.description = description;
            return this;
        }

        public Extra build(){return new Extra(this);}
    }

    //Getters
    public Long getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public String getPrice() {
        return price;
    }

    public String getUnits() {
        return units;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Extra extra = (Extra) o;

        return id.equals(extra.id);

    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "Extra{" +
                "brand='" + brand + '\'' +
                ", price='" + price + '\'' +
                ", units='" + units + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
