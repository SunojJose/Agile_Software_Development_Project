package ie.gmit.dip;

import java.util.Scanner;

/**
 * a java program to calculate car insurance
 * 
 * @author Sunoj Jose
 *
 */
public class CarInsuranceCalculator {
	
	private static final int BASIC_INSURANCE = 500;
	private int surcharge;
	private int additionalSurcharge;
	private int totalPremium;
	
	/**
	 * When executes it prints the results to the console
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter your age: ");
		int age = input.nextInt();
		if (age < 17) {
			System.out.println("Under 17 are not eligible.");
		}else {
			System.out.print("\n How many accidents did you have? ");
			int accidents = input.nextInt();
			if (accidents >= 6) {
				System.out.println("You are not eligible.Can't issue an insurance this time.");
			}else {
				System.out.println("Basic Insurance: " + new CarInsuranceCalculator().getBasicInsurance());
				System.out.println("Surcharge: " + new CarInsuranceCalculator().generateSurcharge(age));
				System.out.println("Additional surcharge for accident: " + new CarInsuranceCalculator().generateAdditionalSurcharge(accidents));
				System.out.println("Total Premium : " + new CarInsuranceCalculator().generateTotalPremium(age, accidents)); 
				
			}
		}	
		input.close();
	}
	
	/**
	 * a method to get basic insurance
	 * @return
	 */
	public int getBasicInsurance() {
		return BASIC_INSURANCE;
	}
	
	/**
	 * a method to generate total premium
	 * 
	 * @param age
	 * @param accidents
	 * @return
	 */
	protected int generateTotalPremium(int age, int accidents) {
		if (age < 25 && age >= 17) {
			surcharge = generateSurcharge(age);
			additionalSurcharge = generateAdditionalSurcharge(accidents);
			totalPremium = BASIC_INSURANCE + surcharge + additionalSurcharge; 
		}else {
			additionalSurcharge = generateAdditionalSurcharge(accidents);
			totalPremium = BASIC_INSURANCE + additionalSurcharge;
		}
		return totalPremium;
	}
	
	/**
	 * a method to generate surcharge
	 * 
	 * @param age
	 * @return
	 */
	protected int generateSurcharge(int age) {
		if (age< 25 && age >= 17) {
			surcharge = 100;
		}else {
			surcharge = 0;
		}
		return surcharge;
	}
	
	/**
	 * a method to generate additional surcharge
	 * 
	 * @param accidents
	 * @return
	 */
	protected int generateAdditionalSurcharge(int accidents) {
		switch(accidents) {
			case 0: 
				additionalSurcharge = 0;
	        break;
			case 1:
				additionalSurcharge = 50;
		    break;
			case 2:
				additionalSurcharge = 125;
		    break;
			case 3:
				additionalSurcharge = 225;
		    break;
			case 4:
				additionalSurcharge = 375;
		    break;
			case 5:
				additionalSurcharge = 575;
	        break;
	        default:
	        	additionalSurcharge = 0;
		}
		return additionalSurcharge;
	}
	

}
