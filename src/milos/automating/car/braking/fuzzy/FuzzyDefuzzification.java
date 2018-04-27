package milos.automating.car.braking.fuzzy;

import java.util.ArrayList;

import milos.automating.car.braking.component.FuzzyOutput;

/**
 * 
 * @author Ervin Milos
 *
 * Class that contains defuzzification method.
 */
public class FuzzyDefuzzification {
	
	/**
	 * Center of gravity function, to calculate final output
	 * 
	 * FuzzyOutputList - contains output fuzzy set list of middle values and membership values
	 */
	public double calculateFinalOutput(ArrayList<FuzzyOutput> fuzzyOutputList) {
		double upperSum = 0.0;
		double bounderSum = 0.0;
		
		for (FuzzyOutput output : fuzzyOutputList) {
			upperSum += output.getMemberShipValue() * output.getValue();
			bounderSum += output.getMemberShipValue();
		}
		return upperSum / bounderSum;
	}
}
