
public class PercentGradeCalc {
	// global variable
	private int total = 0;
	private double[][] criteria;
	
	// constructor
	public PercentGradeCalc() {
		criteria = new double[6][2];
	}
	
	// mutator method for the 2D array
	public void setCell(int i, int j, double d) {
		this.criteria[i][j] = d;
	}

	// calculates the total final grade and returns a String with the total
	public String getFinalGrade() {
		for (int i = 0; i < criteria.length; i++)
			total += criteria[i][0] * criteria[i][1];
		if (total > 90) {
			return "\nYour final grade in this class is: " + this.total + "%.\nCongratulations!"
					+ " Get a cookie. You earned it.";
		}
		else {
			return "\nYour final grade in this class is: " + this.total + "%.";
		}
			
	}
	
}
