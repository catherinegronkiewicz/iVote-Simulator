package iVoteSimulator;

/*
 * Catherine Gronkiewicz
 * Professor Sun
 * CS 3560, Section 01
 * 29 September 2020
 */

public class MCResponseChoices implements ResponseChoices {

    // variables for multiple question choices 
    private String aChoice = "Red";
    private String bChoice = "Orange";
    private String cChoice = "Yellow";
    private String dChoice = "Green";
    private String eChoice = "Blue";
	
    // prints out multiple choice question options
    public String getResponseChoices() {	
	String scQuestion = "What are your favorite colors?";
	String choice = "\nA: " + aChoice 
			+ "\nB: " + bChoice
			+ "\nC: " + cChoice
			+ "\nD: " + dChoice
			+ "\nE: " + eChoice;
	return scQuestion + choice;
    }
}
