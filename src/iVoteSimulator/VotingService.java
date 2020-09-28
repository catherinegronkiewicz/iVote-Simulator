package iVoteSimulator;

/*
 * Catherine Gronkiewicz
 * Professor Sun
 * CS 3560, Section 01
 * 29 September 2020
 */

import java.util.ArrayList;
import java.util.Arrays;

public class VotingService {
	
	// response/variable incrementor for single choice (right or wrong)
	private int right = 0, wrong = 0;
	
	// response/variable incrementor for multiple choices (A, B, C, D, E)
	private int a = 0, b = 0, c = 0, d = 0, e = 0;

	// prints out final result of resubmissions (considers duplicates)
	public void finalResult() {
		System.out.println(Arrays.asList(Student.mapAnswers()));
	}
	
	// get count frequency of single choice responses
	public void countSCFrequencies(ArrayList<String> mapAnswers) { 
		for (int i = 0; i < mapAnswers.size(); i++) {
				if(mapAnswers.get(0).equals("Right")) {
					right++;
				}
				
				if(mapAnswers.get(0).equals("Wrong")) {
					wrong++;
				}
		}
	}
	
	// get count frequency of multiple choice responses
	public void countMCFrequencies(ArrayList<String> mapAnswers) {
		for (int i = 0; i < mapAnswers.size(); i++) {
			for (int j = 0; j < mapAnswers.get(0).length(); j++) {	
				if (mapAnswers.get(i).equals("A")) {
					a++;
				}
				if (mapAnswers.get(i).equals("B")) {
					b++;
				}
				if (mapAnswers.get(i).equals("C")) {
					c++;
				}
				if (mapAnswers.get(i).equals("D")) {
					d++;
				}
				if (mapAnswers.get(i).equals("E")) {
					e++;
				}
			}
		}
	}
	
	// prints out final results of single choice question
	// also prints total number of right and wrong student responses
	public void SCFinal() {
		System.out.println("\nTotal Results for Each Choice:");
		System.out.println("Right:" + right);
		System.out.println("Wrong:" + wrong);
	}
	
	// prints out final results of multiple choice question
	// also prints total number of A, B, C, D, E student responses
	public void MCFinal() {
		System.out.println("\nTotal Results for Each Choice:");
		System.out.println("A: " + a);
		System.out.println("B: " + b);
		System.out.println("C: " + c);
		System.out.println("D: " + d);
		System.out.println("E: " + e);
	}
}
