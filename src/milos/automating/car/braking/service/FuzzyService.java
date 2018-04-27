package milos.automating.car.braking.service;

import java.util.ArrayList;
import milos.automating.car.braking.fuzzy.FuzzySet;

/**
 * @author Ervin Milos
 * 
 * This class fills fuzzy set list of inputs and output
 * 
 *  FuzzySet constructor accepts 3 parameters - 
 *  1. Linguistic variable
 *  2. Minimum boundary
 *  3. Maximum boundary
 */
public class FuzzyService {
	public ArrayList<FuzzySet> fillDistanceSet() {
		ArrayList<FuzzySet> distanceSet = new ArrayList<>();
		distanceSet.add(new FuzzySet("Small", 1, 50));
		distanceSet.add(new FuzzySet("Medium", 20, 70));
		distanceSet.add(new FuzzySet("Long", 30, 90));
		return distanceSet;
	}
	
	public ArrayList<FuzzySet> fillDistanceRateSet() {
		ArrayList<FuzzySet> distanceRateSet = new ArrayList<>();
		distanceRateSet.add(new FuzzySet("Slow", 0.5, 2.5));
		distanceRateSet.add(new FuzzySet("Medium", 1, 3));
		distanceRateSet.add(new FuzzySet("Fast", 1.5, 4.5));
		return distanceRateSet;
	}
	
	public ArrayList<FuzzySet> fillBrakingSet() {
		ArrayList<FuzzySet> brakingSet = new ArrayList<>();
		brakingSet.add(new FuzzySet("Slight", 5, 40));
		brakingSet.add(new FuzzySet("Medium", 20, 70));
		brakingSet.add(new FuzzySet("Heavy", 55, 100));
		return brakingSet;
	}
	
	/**
	 * Print given fuzzy set list - name with its membership
	 */
	public void printFuzzySet(ArrayList<FuzzySet> list) {
		for (FuzzySet set : list) {
			System.out.println(set.getName() + " " +  set.getMemberShipValue());   
		} 
	}
}

