package testFramework.udemyQuestions;

import org.junit.Test;

import org.junit.Assert;
import org.junit.Before;

/*
 * Test Approach 
 * Input - text with ()
 * Output - count for ( and )
 * Expected Out - If count matches, test passes . If count does not match, test case fails. 
 * 
 * 
 */

public class ParenthesesTest {

	String actualText;

	int countLeftPare = 0;
	int countRightPare = 0;

	String LeftPareEx = "(\\()";
	String RightPareEx = "(\\))";

	ParenthesesValidation param;
	
	@Before
	public void beforeTest() {
		param = new ParenthesesValidation();
	}
	

	@Test
	public void testParenthesesValidInput() {

		actualText = "Sometimes ((I (am) too much (confused (when))) there are multiple parentheses in a sentence)";

		try {
			// Left Pare
			countLeftPare = param.getPatternMatch(actualText, LeftPareEx); 
			System.out.println("countLeftPare: "+ countLeftPare);

			// Right Pare
			countRightPare = param.getPatternMatch(actualText, RightPareEx); 
			System.out.println("countRightPare: "+ countRightPare);

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
			countLeftPare = param.getPatternMatch(actualText, LeftPareEx); 
			System.out.println("countLeftPare: "+ countLeftPare);
			// Right Pare
			countRightPare = param.getPatternMatch(actualText, RightPareEx); 
			System.out.println("countRightPare: "+ countRightPare);

			Assert.assertEquals(countLeftPare, countRightPare);
			System.out.println("Test Case Passed");

		} catch (AssertionError e) {
			System.out.println("Test case Failed");
			Assert.fail();
		}

	}

}
