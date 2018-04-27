package milos.automating.car.braking.fuzzy;

/**
 * 
 * @author Ervin Milos
 *
 * This class contains all information about the fuzzy set
 */
public class FuzzySet {
	
	/**
	 * Middle point of fuzzy set
	 */
	public static final int midPoint = 1;

	/** 
	 * The minimum value of fuzzy set
	 */
	private double min;
	
	/**
	 * The maximum value of fuzzy set
	 */
	private double max;
	
	
	/**
	 * Membership value
	 */
	private double memberShipValue;
	
	/**
	 * Mid value
	 */
	private double midValue;
	
	/**
	 * Linguistic variable name
	 */
	private String name;
	
	/**
	 * Input value
	 */
	private double input;

	public FuzzySet(String name, double min, double max) {
		this(name, min, max, min+((max-min)/2));
	}
	
	private FuzzySet(String name, double min, double max, double midValue) {
		this.name = name;
		this.min = min;
		this.max = max;
		this.midValue = midValue;
	}
	
	/**
	 * Triangular function to calculate membership for each fuzzy input
	 */
	public void calculateMembership(double in) {
		if (in <= min || in >= max) {
			this.memberShipValue = 0;
		}
		else if (in == midValue) {
			this.memberShipValue = midPoint;
		}
		else if (in < midValue) {
			double up = in - min;
			double down = midValue - min;
			this.memberShipValue =  up / down;
		} else {
			double up = max - in;
			double down = max - midValue;
			this.memberShipValue =  up / down;
		}
	}
	
	public double getMin() {
		return min;
	}

	public void setMin(double min) {
		this.min = min;
	}

	public double getMax() {
		return max;
	}

	public void setMax(double max) {
		this.max = max;
	}

	public double getMidValue() {
		return midValue;
	}

	public void setMidValue(double midValue) {
		this.midValue = midValue;
	}
	
	public double getMemberShipValue() {
		return memberShipValue;
	}

	public void setMemberShipValue(double memberShipValue) {
		this.memberShipValue = memberShipValue;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public double getInput() {
		return input;
	}

	public void setInput(double input) {
		this.input = input;
	}
}
