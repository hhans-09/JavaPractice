package testFramework.ConfirmationMessage;


public class CountWordsInConfirmationMessage {
	

	public Object countMessageWords(String message) {
		
		// check if message length is 0, then return 0
		if(message == null || message.isEmpty() || message.trim().length() == 0) {
			return 0; // word count 0
		}
		
		// check if message contains "not" , return boolean
		if(message.trim().toLowerCase().contains("not")) {
			return true;
		}
		
		//split on space and add to array. Return array length as count
		String[] words = message.trim().split("(\\s+)");
		return words.length; 
		
	}

}
