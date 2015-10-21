package za.ac.cput.ermotorsports.conf.factory;

import za.ac.cput.ermotorsports.domain.Car;
import za.ac.cput.ermotorsports.domain.Engine;
import za.ac.cput.ermotorsports.domain.Extra;
import za.ac.cput.ermotorsports.domain.ListOfParts;

/**
 * Created by Rudi.Zeeman on 15.10.15.
 */
public class ListOfPartFactory
{
    public static ListOfParts createListOfParts(Long car, Long engine,Long extra)
    {
        ListOfParts listOfParts = new ListOfParts.Build(car)
                .engineNo(engine)
                .partID(extra).build();
        return listOfParts;
    }
}
