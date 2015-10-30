package za.ac.cput.ermotorsports.repository;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by Rudi.Zeeman on 30.10.15.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses(
        {
                CarCrudTest.class,
                CustomerCrudTest.class,
                EngineCrudTest.class,
                ExtraCrudTest.class,
                ListOfPartsCrudTest.class,
                TransactionCrudTest.class
        }
)
public class RepositoryTestSuite {
}
