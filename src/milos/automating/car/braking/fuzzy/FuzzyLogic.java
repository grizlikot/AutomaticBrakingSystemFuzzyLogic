package milos.automating.car.braking.fuzzy;

import java.util.ArrayList;
import milos.automating.car.braking.component.FuzzyOutput;

/**
 * @author Ervin Milos
 *
 * Class for setting memberships for both input and output
 */
public class FuzzyLogic {
	
	// Set for each input/output fuzzy set the chosen value and calculate membership
	public void setMemberships(double in, ArrayList<FuzzySet> list) {
		for (FuzzySet set : list) {
			set.setInput(in);
			set.calculateMembership(in);
		}
	}

	/* This method calculates membership for the each fuzzy output by using
 	   intersection result between the distance between vehicle and obstacle and the distance change rate */
	public ArrayList<FuzzyOutput> calculateOutputMembership(ArrayList<FuzzySet> distanceSetList,
															ArrayList<FuzzySet> distanceRateSetList,
															ArrayList<FuzzySet> brakingSetList) {
		FuzzyRules fuzzyRules = new FuzzyRules();
		ArrayList<FuzzyOutput> fuzzyOutputList = new ArrayList<>();
		
		for (FuzzySet distanceSet : distanceSetList) {
			for (FuzzySet distanceRateSet : distanceRateSetList) {
				String lingOutput = fuzzyRules.retrieveLinguisticOutput(distanceSet.getName(), distanceRateSet.getName());
				for (FuzzySet brakingSet : brakingSetList) {
					if (brakingSet.getName().equals(lingOutput)) {
						fuzzyOutputList.add(
								new FuzzyOutput(
										Math.min(distanceSet.getMemberShipValue(), distanceRateSet.getMemberShipValue()),
										brakingSet.getMidValue())
								);
						break;
					}
				}
			}
		}
		return fuzzyOutputList;
	}
}
