package za.ac.cput.ermotorsports.conf.factory;

import za.ac.cput.ermotorsports.domain.Engine;

import java.util.Map;

/**
 * Created by Rudi.Zeeman on 15.10.15.
 */
public class EngineFactory
{
    public static Engine createEngine(Map<String,String> value)
    {
        Engine engine = new Engine.Build(value.get("brand"))
                .cubicCapacity(value.get("cubicCapacity"))
                .cylinders(value.get("cylinders"))
                .model(value.get("model"))
                .price(value.get("price"))
                .units(value.get("units")).build();
        return engine;
    }
}
