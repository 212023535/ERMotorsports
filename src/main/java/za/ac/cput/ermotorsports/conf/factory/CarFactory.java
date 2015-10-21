package za.ac.cput.ermotorsports.conf.factory;
import za.ac.cput.ermotorsports.domain.Car;
import java.util.Map;

/**
 * Created by Rudi.Zeeman on 15.10.15.
 */
public class CarFactory
{
    public static Car createCar(Map<String,String> value)
    {
        Car car = new Car.Builder(value.get("brand"))
                .year(value.get("year"))
                .model(value.get("model"))
                .colour(value.get("colour")).build();
        return car;
    }
}
