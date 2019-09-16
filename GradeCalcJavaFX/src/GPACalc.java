import java.text.DecimalFormat;

public class GPACalc {
	// global variables
	private double total;
	private DecimalFormat format = new DecimalFormat("#.00");
	int numA, numAminus, numBplus, numB, numBminus, numCplus,
		numC, numCminus, numDplus, numD, numF;
	
	// constructor
	public GPACalc(int numA, int numAminus, int numBplus, int numB, int numBminus, int numCplus,
			int numC, int numCminus, int numDplus, int numD, int numF) {
		this.numA = numA;
		this.numAminus = numAminus;
		this.numBplus = numBplus;
		this.numB = numB;
		this.numBminus = numBminus;
		this.numCplus = numCplus;
		this.numC = numC;
		this.numCminus = numCminus;
		this.numDplus = numDplus;
		this.numD = numD;
		this.numF = numF;
	}
	
	// does a simple average of the cells in gpas[] and returns a String with the avg
	public String calcGPA() {
		int numClasses = numA + numAminus + numBplus + numB + numBminus + numCplus + numC
						 + numCminus + numDplus + numD + numF;
		total = (4.00 * numA) + (3.66 * numAminus) + (3.33 * numBplus) + (3.00 * numB) 
				+ (2.66 * numBminus) + (2.33 * numCplus) + (2.00 * numC) + (1.66 * numCminus)
				+ (1.33 * numDplus) + (1.00 * numD) + (0.00 * numF);
		return "Your final GPA is " + format.format(total / numClasses);
	}
}
