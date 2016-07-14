package triangleAssignment;

import java.util.regex.Pattern;

/**
 * <p>{@code IntegerChecking} class contains several useful methods that
 * checks if a string is an integer. It can be instanciated.</p>
 * @author Yonglin Wang
 * @version 1.0
 * @see java.util.regex.Pattern
 * @see java.lang.Integer
 * @see java.lang.NumberFormatException
 * @see java.lang.String
 */
public class IntegerChecking {
	
	private final Pattern pattern = Pattern.compile("^-?\\d+$");
	
	/**
	 * <p>Checks if a string input is a integer without parsing it. 
	 * This method is the more efficent method (between 20-30 times), 
	 * however it may lead to buffer overflow.</p>
	 * <p>This method checks a string by going through teh following process:</p>
	 * <ol>
	 * 	<li>Check If the string has a value of null, if true return false</li>
	 * 	<li>Check If the string has no characters, if true return false</li>
	 * 	<li>Check If the string starts with a '-'-
	 * 		<ul><li>If yes, check if the string only has this one character, if true return false</li>
	 * 			<li>If no, move on</li>
	 * 		</ul>
	 * <li>Finally check if the string contains any characters that are greater</li>
	 * </ol>
	 * @param str The String to be checked
	 * @return True or false depending on the input value
	 */
	
	public boolean isIntergerFast(String str) {
		if (str == null) {
			return false;
		}
		int length = str.length();
		if (length == 0) {
			return false;
		}
		int i = 0;
		if (str.charAt(0) == '-') {
			if (length == 1) {
				return false;
			}
			i = 1;
		}
		for (; i < length; i++) {
			char c = str.charAt(i);
			if (c < '0' || c > '9') {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * @param str The String to be checked
	 * @return True or false depending on user input
	 * @see java.lang.NumberFormatException
	 * @see java.lang.Integer
	 */
	public boolean isIntegerSafe(String str){
		try{
			Integer.parseInt(str);
			return true;
		}catch(NumberFormatException e){
			return false;
		}
	}
	
	/**
	 * @param str The String to be checked
	 * @return
	 */
	public boolean isIntegerRegex(String str){

		return pattern.matcher(str).find();
		
	}
}
