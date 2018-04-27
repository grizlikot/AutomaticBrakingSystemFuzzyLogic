package milos.automating.car.braking.main;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

import milos.automating.car.braking.component.FuzzyOutput;
import milos.automating.car.braking.fuzzy.*;
import milos.automating.car.braking.service.FuzzyService;

/**
 * 
 * @author Ervin Milos
 *
 * Main class for initiating and working with FuzzyLogic, FuzzyService and FuzzyDefuzzification classes
 */
public class Application {
	
	private static Scanner scanner;

	public static void main(String args[]) {
		
		// Initiating all classes
		FuzzyLogic fuzzyLogic = new FuzzyLogic();
		FuzzyService fuzzyService = new FuzzyService();
		FuzzyDefuzzification fuzzyDefuzzification = new FuzzyDefuzzification();
		
		// Filling fuzzy sets for each input and output
		ArrayList<FuzzySet> distanceSetList = fuzzyService.fillDistanceSet();
		ArrayList<FuzzySet> distanceRateSetList = fuzzyService.fillDistanceRateSet();
		ArrayList<FuzzySet> brakingSetList = fuzzyService.fillBrakingSet();

		scanner = new Scanner(System.in);
		Scanner in = scanner.useLocale(Locale.US);
		
		// Requesting to input the current distance between vehicle and obstacle
		System.out.println("Enter distance between 1 and 90");
		double input = in.nextDouble();

		// Setting and printing memberships for distance fuzzy set list
		fuzzyLogic.setMemberships(input, distanceSetList);
		fuzzyService.printFuzzySet(distanceSetList);
		
		// Requesting to input the current distance rate between vehicle and obstacle
		System.out.println("Enter distance rate between 0.5 and 4.5");
		input = in.nextDouble();
		
		// Setting and printing memberships for distance rate fuzzy set list
		fuzzyLogic.setMemberships(input, distanceRateSetList);
		fuzzyService.printFuzzySet(distanceRateSetList);

		// Calculating memberships for output by using intersection between inputs
		ArrayList<FuzzyOutput> outputMemberships = fuzzyLogic.calculateOutputMembership(
				distanceSetList, 
				distanceRateSetList, 
				brakingSetList
		);
		
		// Calculating actual result
		double finalOutput = fuzzyDefuzzification.calculateFinalOutput(outputMemberships);
		
		System.out.println("Car has to push brakes at: " + finalOutput + " %");
		
		in.close();
	}
}
