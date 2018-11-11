package day04;

import day03.Test3;
import junit.framework.JUnit4TestAdapter;
import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests {
	public static Test suite() {
	TestSuite suite = new TestSuite("Test for day01");
	//$JUnit-BEGIN$
	suite.addTest(new JUnit4TestAdapter(Test5.class));
	suite.addTest(new JUnit4TestAdapter(Test6.class));

	//$JUnit-END$
	return suite;
	}
}
