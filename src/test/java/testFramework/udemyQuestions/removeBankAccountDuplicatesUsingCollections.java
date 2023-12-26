package testFramework.udemyQuestions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

/*
 * 
 * 
 * 
 */

public class removeBankAccountDuplicatesUsingCollections {

	List<Integer> bankAccountNum;

	List<Integer> duplicateBankAccountNum;

	Set<Integer> uniqueBackAccountNum;

	@Before
	public void setup() {

		bankAccountNum = new ArrayList<Integer>();
		duplicateBankAccountNum = new ArrayList<Integer>();
		uniqueBackAccountNum = new HashSet<Integer>();

	}

	public List<Integer> setupTestData() {

		bankAccountNum.add(1234445);
		bankAccountNum.add(1234445);
		bankAccountNum.add(445544445);
		bankAccountNum.add(400393939);
		bankAccountNum.add(433423239);
		bankAccountNum.add(433423239);
		bankAccountNum.add(893303239);

		return bankAccountNum;
	}

	public void processBankAccountDuplicates(List<Integer> bankAccountNum) {

		for (int i = 0; i < bankAccountNum.size(); i++) {
			if (!uniqueBackAccountNum.contains(bankAccountNum.get(i))) {

				uniqueBackAccountNum.add((Integer) bankAccountNum.get(i));

			} else {
				duplicateBankAccountNum.add((Integer) bankAccountNum.get(i));
			}
		}

		System.out.println("Unique Account numbers are : " + uniqueBackAccountNum);
		System.out.println("Duplicate Account numbers are : " + duplicateBankAccountNum);

	}

	@Test
	public void testDuplicateAccountNum() {

		List<Integer> bankAccountNum = setupTestData();
		processBankAccountDuplicates(bankAccountNum);

	}

}
