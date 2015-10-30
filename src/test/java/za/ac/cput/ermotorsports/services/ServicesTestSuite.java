package za.ac.cput.ermotorsports.services;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by Rudi.Zeeman on 30.10.15.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses(
        {
                CarServiceTest.class,
                CustomerServiceTest.class,
                EngineServiceTest.class,
                ExtraServiceTest.class,
                ListOfPartsServiceTest.class,
                TransactionServiceTest.class
        }
)
public class ServicesTestSuite {
}
