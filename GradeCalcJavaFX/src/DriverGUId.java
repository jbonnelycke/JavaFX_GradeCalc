/*************************************************************************
 *
 *  Pace University
 *  Fall 2019
 *
 *  Team Authors: Jack Bonnelycke
 *
 *  Problem: Create a calculator for your final grade, GPA, and total percent
 *  Description: The app I used to use for this got deleted off the iOS app
 *  			 store, so I decided to make my own. Updated from the other 
 *  			 grade calc to be a JavaFX app.
 *
 *
 *************************************************************************/

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class DriverGUId extends Application {
	private Text welcomeText, tPercent, tGrade, tFinal, done;
	private TextField tFinal1, tFinal2, tFinal3, 
		t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11;
	private TextField[][] tcts = new TextField[6][2];
	Stage stageFinal = new Stage();
	Stage stagePercent = new Stage();
	Stage stageGPA = new Stage();
	Stage stageGPA2 = new Stage();
	
	// initial app selection screen. welcome msg and buttons to open new windows
	public void start(Stage stage0) {
		// welcome
		welcomeText = new Text("Welcome to the Grade Calculator!"
				+ "\n		 Select your app:");
		welcomeText.setFont(Font.font("Calibri", 20));
		
		// buttons
		Button pushGPA = new Button("GPA Calculator");
		Button pushFinal = new Button("Final Grade Calculator");
		Button pushPercent = new Button("Percent Grade Calculator");
		pushGPA.setOnAction(this::processGPAButtonPress);
		pushFinal.setOnAction(this::processFinalButtonPress);
		pushPercent.setOnAction(this::processPercentButtonPress);
		
		// JavaFX setup stuff.
		FlowPane pane = new FlowPane(welcomeText, pushGPA, pushFinal, pushPercent);
		pane.setAlignment(Pos.CENTER);
		pane.setHgap(30);
		pane.setVgap(30);
		pane.setStyle("-fx-background-color: beige"); // beige background

		Scene scene = new Scene(pane, 300, 200);

		stage0.setTitle("Grade Calculator");
		stage0.setScene(scene);
		stage0.show();
	}
	
	// GPACalc that takes in the num of each letter grade and avg's 
	// what your GPA would be
	public void processGPAButtonPress(ActionEvent event) {
		// the text that will display the answer
		done = new Text("");
		
		// welcome message and explanation
		Text welcomeGPA = new Text(
				  "	            Welcome to the GPA Calculator.\n"
				+ "               Enter the number of classes you've taken,\n"
				+ "           then enter each letter grade one by one, pressing\n"
				+ "	           \"Enter\" after each letter grade.\n"
				+ "This program assumes the following is how your school's GPA is set up:\n"
				+ "-------------------------------------------------------------------\n"
				+ "|  A  |  A- |  B+ |  B  |  B- |  C+ |  C  |  C- |  D+ |  D  |  F  |\n"
				+ "| 4.00| 3.66| 3.33| 3.00| 2.66| 2.33| 2.00| 1.66| 1.33| 1.00| 0.00|\n"
				+ "-------------------------------------------------------------------");
		welcomeGPA.setFont(Font.font("Consolas", 12));
		
		// all of the entry fields
		t1 = new TextField("Num. A's");
		t2 = new TextField("Num. A-'s");
		t3 = new TextField("Num. B+'s");
		t4 = new TextField("Num. B's");
		t5 = new TextField("Num. B-'s");
		t6 = new TextField("Num. C+'s");
		t7 = new TextField("Num. C's");
		t8 = new TextField("Num. C-'s");
		t9 = new TextField("Num. D+'s");
		t10 = new TextField("Num. D's");
		t11 = new TextField("Num. F's");
		
		// done button that will calculate
		Button pushDone = new Button("Done!");
		pushDone.setOnAction(this::processDoneButtonPress1);
		
		// JavaFX stuff
		FlowPane pane = new FlowPane(welcomeGPA, t1, t2, t3, t4, t5, t6, t7, 
				t8, t9, t10, t11, pushDone, done);
		pane.setAlignment(Pos.CENTER);
		pane.setHgap(30);
		pane.setVgap(30);
		pane.setStyle("-fx-background-color: beige");

		Scene scene = new Scene(pane, 600, 600);

		stageGPA.setTitle("GPA Calculator");
		stageGPA.setScene(scene);
		stageGPA.show();
	}
	
	// Final score needed calculator. Takes in current grade,
	// desired grade, and exam weight, to tell you the grade
	// you need to get on the final to get desired grade
	public void processFinalButtonPress(ActionEvent event) {
		// TextFields and buttons
		tFinal1 = new TextField("Enter current grade (%)");
		tFinal2 = new TextField("Enter desired grade (%)");
		tFinal3 = new TextField("Enter exam weight (%)");
		tFinal = new Text("");
		Button pushDone = new Button("Done!");
		pushDone.setOnAction(this::processDoneButtonPress2); // see processDoneButtonPress2 method
		
		// JavaFX setup stuff
		FlowPane pane = new FlowPane(tFinal1, tFinal2, tFinal3, pushDone, tFinal);
		pane.setAlignment(Pos.CENTER);
		pane.setHgap(30);
		pane.setVgap(10);
		pane.setStyle("-fx-background-color: beige");
		
		Scene scene = new Scene(pane, 600, 100);
		
		stageFinal.setTitle("Final Calculator");
		stageFinal.setScene(scene);
		stageFinal.show();
	}
	
	// Calculate the percent grade you have in the class based
	// on the criteria provided in the syllabus and your scores
	// in those areas
	public void processPercentButtonPress(ActionEvent event) {
		// welcome msg
		tPercent = new Text(
				  "  Enter how much each percent criteria is worth,\n"
				+ "and then enter your score in the respective area.\n"
				+ "	   Please enter 0 in all fields unused.");
		tGrade = new Text("");
		
		// all of the TextFields
		tcts[0][0] = new TextField("Insert criteria1 (%)");
		tcts[0][1] = new TextField("Insert score1 (%)");
		tcts[1][0] = new TextField("Insert criteria2 (%)");
		tcts[1][1] = new TextField("Insert score2 (%)");
		tcts[2][0] = new TextField("Insert criteria3 (%)");
		tcts[2][1] = new TextField("Insert score3 (%)");
		tcts[3][0] = new TextField("Insert criteria4 (%)");
		tcts[3][1] = new TextField("Insert score4 (%)");
		tcts[4][0] = new TextField("Insert criteria5 (%)");
		tcts[4][1] = new TextField("Insert score5 (%)");
		tcts[5][0] = new TextField("Insert criteria6 (%)");
		tcts[5][1] = new TextField("Insert score6 (%)");
		
		Button pushDone = new Button("Done!");
		pushDone.setOnAction(this::processDoneButtonPress3); // see processDoneButtonPress3 below
		
		// JavaFX setup stuff
		FlowPane pane = new FlowPane(tPercent, tcts[0][0], tcts[0][1], tcts[1][0], tcts[1][1], tcts[2][0], 
				tcts[2][1], tcts[3][0], tcts[3][1], tcts[4][0], tcts[4][1], 
				tcts[5][0], tcts[5][1], pushDone, tGrade);
		pane.setAlignment(Pos.CENTER);
		pane.setHgap(30);
		pane.setVgap(10);
		pane.setStyle("-fx-background-color: beige");
		
		Scene scene = new Scene(pane, 600, 300);
		
		stagePercent.setTitle("Final Calculator");
		stagePercent.setScene(scene);
		stagePercent.show();
	}
	
	// gets all of the integers inputed into the TextFields and then calculates
	// and sets done to the answer
	public void processDoneButtonPress1(ActionEvent event) {
		GPACalc calc = new GPACalc(Integer.parseInt(t1.getText()), Integer.parseInt(t2.getText()), 
				Integer.parseInt(t3.getText()), Integer.parseInt(t4.getText()), 
				Integer.parseInt(t5.getText()), Integer.parseInt(t6.getText()), 
				Integer.parseInt(t7.getText()), Integer.parseInt(t8.getText()), 
				Integer.parseInt(t9.getText()), Integer.parseInt(t10.getText()), 
				Integer.parseInt(t11.getText()));
		
		done.setText(calc.calcGPA());
	}
	
	// gets the doubles in all of the TextFields and then calculates
	// and sets tFinal to the answer
	public void processDoneButtonPress2(ActionEvent event) {
		FinalGradeCalc calc = new FinalGradeCalc((Double.parseDouble(tFinal1.getText())), 
				Double.parseDouble(tFinal2.getText()), Double.parseDouble(tFinal3.getText()));
		tFinal.setText(calc.getFinalGrade());
	}
	
	// gets all the doubles in the array of TextFields then calculates
	private void processDoneButtonPress3(ActionEvent event) {
		PercentGradeCalc calc = new PercentGradeCalc();
		for (int i = 0; i < 6; i++) {
			calc.setCell(i, 0, Double.parseDouble(tcts[i][0].getText()) / 100);
		}
		
		for (int i = 0; i < 6; i++) {
			calc.setCell(i, 1, Double.parseDouble(tcts[i][1].getText()));
		}
		
		tGrade.setText(calc.getFinalGrade());
	}
	
	// launch the program
	public static void main(String[] args) {
		launch(args);
	}
}