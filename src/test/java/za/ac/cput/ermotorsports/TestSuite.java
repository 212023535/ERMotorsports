package za.ac.cput.ermotorsports;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import za.ac.cput.ermotorsports.domain.DomainTestSuite;
import za.ac.cput.ermotorsports.repository.RepositoryTestSuite;
import za.ac.cput.ermotorsports.services.ServicesTestSuite;

/**
 * Created by Rudi.Zeeman on 30.10.15.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses(
        {
                DomainTestSuite.class,
                RepositoryTestSuite.class,
                ServicesTestSuite.class
        }
)
public class TestSuite {
}
