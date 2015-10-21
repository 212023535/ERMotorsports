package za.ac.cput.ermotorsports.conf.factory;

import za.ac.cput.ermotorsports.domain.Extra;

import java.util.Map;

/**
 * Created by Rudi.Zeeman on 15.10.15.
 */
public class ExtraFactory
{
    public static Extra createExtra(Map<String , String> value)
    {
        Extra extra = new Extra.Build(value.get("brand"))
                .description(value.get("description"))
                .price(value.get("price"))
                .units(value.get("units")).build();

        return extra;
    }
}
