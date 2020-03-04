package com.chap01.Q1_04_Palindrome_Permutation;

/*
 * Given a string check if it's a permutation of palindrom. A palindrom is a string which is same from forwards and backwords.
 * A permutation is rearrangement of letters. A plindrom does not be restrictod to dictionary word.
 */

public class QuestionA {	
	public static boolean checkMaxOneOdd(int[] table) {
		boolean foundOdd = false;
		for (int count : table) {
			if (count % 2 == 1) {
				if (foundOdd) {
					return false;
				}
				foundOdd = true;
			}
		}
		return true;
	}
	
	public static boolean isPermutationOfPalindrome(String phrase) {
		int[] table = Common.buildCharFrequencyTable(phrase);
		return checkMaxOneOdd(table);
	}
	
	public static void main(String[] args) {
		String pali = "Rats live on no evil star";
		System.out.println(isPermutationOfPalindrome(pali));
	}


}
