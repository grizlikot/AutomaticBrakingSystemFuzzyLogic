package milos.automating.car.braking.fuzzy;

/**
 * 
 * @author Ervin Milos
 * 
 * This class accepts as parameters, two linguistic variables:
 * 1. Linguistic variable for distance
 * 2. Linguistic variable for distance change rate
 * @return Linguistic variable for output
 */
public class FuzzyRules {
	
	public String retrieveLinguisticOutput(String v1, String v2) {
		if (v1.equals("Small")  && v2.equals("Slow"))   return "Medium";
		if (v1.equals("Medium") && v2.equals("Slow"))   return "Slight";
		if (v1.equals("Long")   && v2.equals("Slow"))   return "Slight";
		if (v1.equals("Small")  && v2.equals("Medium")) return "Heavy";
		if (v1.equals("Medium") && v2.equals("Medium")) return "Slight";
		if (v1.equals("Long")   && v2.equals("Medium")) return "Slight";
		if (v1.equals("Small")  && v2.equals("Fast"))   return "Heavy";
		if (v1.equals("Medium") && v2.equals("Fast"))   return "Medium";
		if (v1.equals("Long")   && v2.equals("Fast"))   return "Medium";
		
		return null;
	}
}

