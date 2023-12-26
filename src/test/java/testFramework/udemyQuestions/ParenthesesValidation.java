package testFramework.udemyQuestions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

import org.junit.Assert;

/*
 * Test Approach 
 * Input - text with ()
 * Output - count for ( and )
 * Expected Out - If count matches, test passes . If count does not match, test case fails. 
 * 
 * 
 */

public class ParenthesesValidation {

	

	Pattern pattern;
	Matcher matcher;
	


	public int getPatternMatch(String actualText, String regEx) {
		
		int para = 0;
		
		pattern = Pattern.compile(regEx);
		matcher = pattern.matcher(actualText);

		while (matcher.find()) {

			System.out.println("Matched Group : " + matcher.group());

			para++;

		}
		
		return para;
	}

	
}
