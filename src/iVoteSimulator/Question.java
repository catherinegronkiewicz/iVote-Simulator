package iVoteSimulator;

import java.util.ArrayList;

/*
 * Catherine Gronkiewicz
 * Professor Sun
 * CS 3560, Section 01
 * 29 September 2020
 */

public interface Question {
	
    public String getQuestion();
	
    // store student responses in array list
    public ArrayList<String> getResponse();
	
    // condition if question is multiple choice or single choice
    public boolean isMultipleChoice();

}
