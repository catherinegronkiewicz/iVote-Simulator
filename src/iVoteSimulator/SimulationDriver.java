package iVoteSimulator;

/*
 * Catherine Gronkiewicz
 * Professor Sun
 * CS 3560, Section 01
 * 29 September 2020
 */

import java.util.ArrayList;
import java.util.Random;

public class SimulationDriver {
	
	// holds random generated number of students 
	private static int num_students = Student.generateNumStudents();
	// adds number of students to Student object
	private static Student[] students = new Student[num_students];
	
	public static void main(String[] args) {
		
		// initializes VotingService class
		VotingService Vote = new VotingService();

		// ** single choice question **
		// create SCResponseChoices object to print choices
		ResponseChoices single = new SCResponseChoices();
		String singleChoiceQuestion = single.getResponseChoices();
		ArrayList<String> singleChoiceResponse = new ArrayList<String>();
		// adding single choice responses to array list
		singleChoiceResponse.add("Right");
		singleChoiceResponse.add("Wrong");
		Question singleChoice = new SingleChoiceQuestion(singleChoiceQuestion, singleChoiceResponse);
		
		// ** multiple choice question **
		// create MCResponseChoices object to print choices
		ResponseChoices multiple = new MCResponseChoices();
		String multipleChoiceQuestion = multiple.getResponseChoices();
		ArrayList<String> multipleChoiceResponse = new ArrayList<String>();
		// adding multiple choice responses to array list
		multipleChoiceResponse.add("A");
		multipleChoiceResponse.add("B");
		multipleChoiceResponse.add("C");
		multipleChoiceResponse.add("D");
		multipleChoiceResponse.add("E");
		Question multipleChoice = new MultipleChoiceQuestion(multipleChoiceQuestion, multipleChoiceResponse);
		
		// randomly chooses 0 or 1 as the question type
		int randChoice = (int)(new Random().nextInt(2));
		
		Question[] qType = new Question[2];
		qType[0] = singleChoice; 
		qType[1] = multipleChoice;
		// question choice depends on random question type
		Question qChoice = qType[randChoice];		
		
		// iterates through each Student object
		for (int i = 0; i < num_students; i++) {
			students[i] = new Student(i);
		}
		
		// prints out question (based on single or multiple)
		String sQuestion = "**** SINGLE CHOICE QUESTION ****\n";
		String mcQuestion = "**** MULTIPLE CHOICE QUESTION ****\n";
		if (randChoice == 0)
			System.out.println(sQuestion + "\nQuestion: " + qChoice.getQuestion());
		if (randChoice == 1)
			System.out.println(mcQuestion + "\nQuestion: " + qChoice.getQuestion());
		
		// prints out total numbers of students
		System.out.println("\nTotal Number of Students: " + num_students);
		
		// prints total submissions of all students (even if more than one submission)
		System.out.println("\nOverall Submissions of Each Student: ");

		// for each student, generate a random response
		for (int i = 0; i < num_students; i++) {
			students[i].sendFinalSubmit(qChoice);
			System.out.println("StudentID" + "[#" + students[i].getID() + "]" + ": " + students[i].getResponse());
		}
		
		// randomly chooses which students submit multiple answers
		for (int i = 0; i < num_students; i++) {
			int randID = (int)(new Random().nextInt(num_students));
			students[randID].sendFinalSubmit(qChoice);
			System.out.println("StudentID" + "[#" + students[randID].getID() + "]" + ": " + students[randID].getResponse());
		}
		
		// creates new array list to store count frequencies of responses
		ArrayList<String> list = new ArrayList<String>();
		
		// iterates array list for count frequency
		for (int i = 0; i < Student.mapAnswers().size(); i++) {
			list = students[i].getResponse();
			Vote.countSCFrequencies(list);
			Vote.countMCFrequencies(list);
		}
		
		System.out.print("\nFinal Submission Results of Each Student (After Multiple Submissions): \n");
		Vote.finalResult();
		
		// based on question choice - prints final results of each question type
		if(randChoice == 0) {
			Vote.SCFinal();
		}
		else {
			Vote.MCFinal();
		}
	}
}
