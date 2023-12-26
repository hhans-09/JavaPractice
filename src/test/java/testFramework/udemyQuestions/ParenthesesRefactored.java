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

public class ParenthesesRefactored {

	String actualText;

	int countLeftPare = 0;
	int countRightPare = 0;

	String LeftPareEx = "(\\()";
	String RightPareEx = "(\\))";

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

	@Test
	public void testParenthesesValidInput() {

		actualText = "Sometimes ((I (am) too much (confused (when))) there are multiple parentheses in a sentence)";

		try {
			// Left Pare
			countLeftPare = getPatternMatch(actualText, LeftPareEx); 

			// Right Pare
			countRightPare = getPatternMatch(actualText, RightPareEx); 

			Assert.assertEquals(countLeftPare, countRightPare);
			System.out.println("Test Case Passed");

		} catch (AssertionError e) {
			System.out.println("Test case Failed");
			Assert.fail();
		}

	}
	
	@Test
	public void testParenthesesInvalidInput() {

		actualText = "Sometimes ((I (am) too much (confused (when))) there are multiple parentheses in a sentence))";

		try {
			// Left Pare
			countLeftPare = getPatternMatch(actualText, LeftPareEx); 

			// Right Pare
			countRightPare = getPatternMatch(actualText, RightPareEx); 

			Assert.assertEquals(countLeftPare, countRightPare);
			System.out.println("Test Case Passed");

		} catch (AssertionError e) {
			System.out.println("Test case Failed");
			Assert.fail();
		}

	}

}
