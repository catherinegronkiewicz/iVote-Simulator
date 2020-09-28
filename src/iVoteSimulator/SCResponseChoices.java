package iVoteSimulator;

/*
 * Catherine Gronkiewicz
 * Professor Sun
 * CS 3560, Section 01
 * 29 September 2020
 */

public class SCResponseChoices implements ResponseChoices {

    // variables for single question choices
    private String firstChoice = "Right?";
    private String secondChoice = "Wrong?";
	
    // prints out single choice question options
    public String getResponseChoices() {
	String scQuestion = "Is it right or wrong to steal from a store?";
	String choice = "\nChoice 1: " + firstChoice + "\nChoice 2: " + secondChoice;
	return scQuestion + choice;
    }
}
