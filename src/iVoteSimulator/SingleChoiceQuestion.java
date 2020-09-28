package iVoteSimulator;

/*
 * Catherine Gronkiewicz
 * Professor Sun
 * CS 3560, Section 01
 * 29 September 2020
 */

import java.util.ArrayList;

public class SingleChoiceQuestion implements Question {

    // either multiple choice or single choice question
    private String question;
	
    // stores multiple choice responses
    private ArrayList<String> studentResponse;
	
    public SingleChoiceQuestion(String scQuestion, ArrayList<String> response) {
	this.question = scQuestion;
	this.studentResponse = response;
    }
	
    public String getQuestion() {
	return question;
    }
	
    // returns single choice responses in array list
    public ArrayList<String> getResponse() {
	return studentResponse;
    }
	
    // condition if question is multiple choice (false)
    public boolean isMultipleChoice() {
	return false;
    }
}
