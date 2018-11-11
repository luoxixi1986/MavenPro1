package day05;

import day03.Test3;
import junit.framework.JUnit4TestAdapter;
import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests3 {
	public static Test suite() {
	TestSuite suite = new TestSuite("Test for day01");
	//$JUnit-BEGIN$
	suite.addTest(new JUnit4TestAdapter(Test15.class));
	suite.addTest(new JUnit4TestAdapter(Test16.class));
	suite.addTest(new JUnit4TestAdapter(Test17.class));
	//$JUnit-END$
	return suite;
	}
}
