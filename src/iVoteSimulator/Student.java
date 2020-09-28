package iVoteSimulator;

/*
 * Catherine Gronkiewicz
 * Professor Sun
 * CS 3560, Section 01
 * 29 September 2020
 */

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;

public class Student {

    // holds unique student ID
    private int uniqueID;
	
    // holds number of randomly generated students
    private static int randStudents;
	
    // need to use both hashmap methods and array list features
    // need Collections
    private static HashMap<Integer, ArrayList<String>> mapStudentAnswers = new HashMap<Integer, ArrayList<String>>();
	
    // stores/holds student responses
    private ArrayList<String> studentAnswers = new ArrayList<String>();
	
    public Student(int studentID) {
	this.uniqueID = studentID;
    }
	
    // starts at student '1'
    public int getID() {
	return uniqueID + 1;
    }
	
    // generates a random number of students for polling (1 to 20 students)
    public static int generateNumStudents() {
	randStudents = (int)(Math.random() * (20) + 1);
	return randStudents;
    }
	
    // stores students responses in array list
    public ArrayList<String> getResponse() {
	return studentAnswers;
    }
	
    // maps student answers into hashmap
    public static HashMap<Integer, ArrayList<String>> mapAnswers() {
	return mapStudentAnswers;
    }
	
    // sends final submission - based on single or multiple choice question
    public void sendFinalSubmit(Question q) {

	// if a multiple choice question
	if(q.isMultipleChoice()) {
	    // shuffles array list of student responses and deletes random amount of indexes
	    studentAnswers = new ArrayList<String>(q.getResponse());
				
	    // displaying random answers (removing indexes)
	    // removes random indexes 
	    int listSize = studentAnswers.size();
	    int removeResponse = (int)(Math.random() * (listSize) - 1);
			
	    // randomizes answers in array list
	    Collections.shuffle(studentAnswers);
			
	    // add new generated answers
	    // if answers are not null, add them to hashmap
	    for (int j = 0; j < studentAnswers.size(); j++) {
		if (studentAnswers.get(j) != null) {
		    // gathers students answers in map
		    // uses key/value pair of hashmap class (studentID: response)
		    mapStudentAnswers.put(getID(), studentAnswers);
	        }
	        else {
		    // if answer is null, returns error statement
		    System.out.println(" ** Multiple Choice Question: Error with student submission! ** ");
	        }
	    }
							
	    // removes a random index from array list of responses (add variety for responses)
	    for (int i = 0; i < removeResponse; i++) {
	        studentAnswers.remove(i);
	    }	
	}
		
	// if a single choice question
	if (!(q.isMultipleChoice())) {
	    // shuffles the array list and deletes the first index (the 0 index)
	    studentAnswers = new ArrayList<String>(q.getResponse());
			
	    // randomizes answers in list
	    Collections.shuffle(studentAnswers);
	    // deletes first index
	    studentAnswers.remove(0);
			
	    // iterates/checks each student answer to add to hashmap
	    for (String answers : studentAnswers) {
	        if (answers != null) {
		    // key and value pairs with hashmap
		    // use hashmap method "put" to add ID and submission pair (studentID: response)
		    mapStudentAnswers.put(getID(), studentAnswers);
		}
		else {
		    System.out.println(" ** Single Choice Question: Error with student submission! ** ");
		}
	    }	
	}

	// considers duplicate submissions and prioritizes students' last response
	Collections.sort(studentAnswers);
    }
}
