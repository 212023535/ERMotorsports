package za.ac.cput.ermotorsports.api.intergrations;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by Rudi.Zeeman on 30.10.15.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses(
        {
                CarAPITest.class,
                CustomerAPITest.class,
                EngineAPITest.class,
                ExtraAPITest.class,
                TransactionAPITest.class
        }
)
public class ApiTestSuite {
}
