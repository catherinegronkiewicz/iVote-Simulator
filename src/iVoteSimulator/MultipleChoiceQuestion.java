package iVoteSimulator;

/*
 * Catherine Gronkiewicz
 * Professor Sun
 * CS 3560, Section 01
 * 29 September 2020
 */

import java.util.ArrayList;

public class MultipleChoiceQuestion implements Question {
	
	// either multiple choice or single choice question
	private String question;
	
	// stores multiple choice responses
	private ArrayList<String> studentResponse;
	
	public MultipleChoiceQuestion(String mcQuestion, ArrayList<String> response)
	{
		this.question = mcQuestion;
		this.studentResponse = response;
	}
	
	public String getQuestion() {
		return question;
	}

	// returns multiple choice responses in array list
	public ArrayList<String> getResponse() {
		return studentResponse;
	}
	
	// condition if question is multiple choice (true)
	public boolean isMultipleChoice() {
		return true;
	}
}
