import java.text.DecimalFormat;

public class FinalGradeCalc {
	// global variables
	double current;
	double desired;
	double examWeight;			
	double finalGrade;
	
	// constructors
	public FinalGradeCalc(double current, double desired, double examWeight) {
		this.current = current / 100;
		this.desired = desired / 100;
		this.examWeight = examWeight / 100;
	}
	
	// calculates what grade you need to get. returns a message, as well as the score needed
	public String getFinalGrade() {
		DecimalFormat decimal = new DecimalFormat("0.0");
		finalGrade = ((desired - ((1 - examWeight) * current)) / examWeight) * 100;
		if (finalGrade < 0)
			return "You need to get a 0. Woohoo!";
		else
			return "\nTo get a " + desired * 100 + "%, you need a " + decimal.format(finalGrade) + "%";
	}
}
