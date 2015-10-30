package za.ac.cput.ermotorsports.domain;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by Rudi.Zeeman on 30.10.15.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses(
        {
                CarTest.class,
                CustomerTest.class,
                EngineTest.class,
                ExtraTets.class,
                ListOfParts.class,
                TransactionTest.class
        }
)
public class DomainTestSuite {
}
