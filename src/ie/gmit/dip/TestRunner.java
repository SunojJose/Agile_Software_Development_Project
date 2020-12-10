package ie.gmit.dip;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 * 
 * @author Sunoj Jose
 *
 */
public class TestRunner {

	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(CarInsuranceCalculatorTestSuite.class);
		for (Failure failure : result.getFailures()) {
			System.out.println(failure.toString());
		}
		if (result.wasSuccessful())
			System.out.println("All tests passed.");
		else
			System.out.println("Failure(s) occured during tests.");

	}

}
