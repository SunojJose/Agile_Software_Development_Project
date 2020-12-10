package ie.gmit.dip;

import static org.junit.jupiter.api.Assertions.*;

import java.util.InputMismatchException;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * 
 * @author Sunoj Jose
 *
 */

class CarInsuranceCalculatorTest {

	public static CarInsuranceCalculator ca;

	@ParameterizedTest
	@CsvSource({ "0, 0", "50, 1", "125, 2", "225, 3", "375, 4", "575, 5" })
	@Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
	public void generateAdditionalSurchargeTest(int expectedResult, int accidents) {
		System.out.println(
				"Parameterised test; generateAdditionalSurchargeTest(int expectedResult, int accidents) starts...");
		assertEquals(expectedResult, ca.generateAdditionalSurcharge(accidents));

	}

	@ParameterizedTest
	@CsvSource({ "825, 24, 3", "550, 50, 1", "725, 25, 3", "500, 30, 0", "1175, 18, 5" })
	@Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
	public void generateTotalPremiumTest(int expectedResult, int age, int accidents) {
		System.out.println(
				"Parameterised test;generateTotalPremiumTest(int expectedResult,int age, int accidents) starts... ");
		assertEquals(expectedResult, ca.generateTotalPremium(age, accidents));
	}

	@ParameterizedTest
	@CsvSource({ "0, 25", "100, 17", "0, 50", "100, 24", "0, 26", "0, 50", "100, 20" })
	@Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
	public void generatetSurchargeTest(int expectedResult, int age) {
		System.out.println("Parameterised test;generatetSurchargeTest(int expectedResult, int age) starts...");
		assertEquals(expectedResult, ca.generateSurcharge(age));
	}

	@Test
	@Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
	public void getBasicInsuranceTest() {
		System.out.println("The test; getBasicInsuranceTest() starts... ");
		int actualValue = ca.getBasicInsurance();
		assertEquals(500, actualValue);
	}

	@BeforeAll
	public static void SetUp() {
		System.out.println("The tests of CarInsuranceCalculatorTest are starting...");

	}

	@BeforeEach
	public void startUpMessage() {
		ca = new CarInsuranceCalculator();
	}

	@AfterAll
	public static void finalMessage() {
		System.out.println("All tests of CarInsurnaceCalculatorTest are done.");

	}

	@AfterEach
	public void endOfTestMessage() {
		System.out.println("This test ended.");
	}

	@Test
	public void InputMismatchExceptionTest() {
		System.out.println("InputMismatchExceptionTest() starts...");
		assertThrows(InputMismatchException.class, () -> {
			Object input = "one";
			if (input instanceof String)
				throw new InputMismatchException("Incorrect entry. Please input a positive integer");
		});
	}

	@Test
	public void IllegalArgumentExceptionTest() {
		System.out.println("IllegalArgumentExceptionTest() starts...");
		int age = 16;
		int accidents = 6;
		assertThrows(IllegalArgumentException.class, () -> {
			if (age < 17 || accidents >= 6)
				throw new IllegalArgumentException("Inavlid entry.");

		});
	}

	@Test
	public void NullPointerExceptionTest() {
		System.out.println("NullPointerExceptionTest() strats...");
		assertThrows(NullPointerException.class, () -> {
			Object obj = null;
			if (obj == null)
				throw new NullPointerException("Null pointer Exception;Object can't be null");
		});
	}

}
