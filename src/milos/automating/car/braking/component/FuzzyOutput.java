package milos.automating.car.braking.component;

/**
 *  @author Ervin Milos
 *	This class contains output information, value and its membership
 */
public class FuzzyOutput {
	private double memberShipValue;
	private double value;
	
	public FuzzyOutput(double memberShipValue, double value) {
		this.memberShipValue = memberShipValue;
		this.value = value;
	}
	
	public double getMemberShipValue() {
		return memberShipValue;
	}
	public void setMemberShipValue(double memberShipValue) {
		this.memberShipValue = memberShipValue;
	}
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}
	
}
