import org.junit.runner.RunWith;
import org.junit.runners.Suite;

//JUnit Suite Test
@RunWith(Suite.class)

@Suite.SuiteClasses({ 
   TestStrategy.class ,TestObserver.class, TestFactory.class
})

public class TestSuite {
}
