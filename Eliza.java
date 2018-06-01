///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Title:            Eliza
// Files:            Eliza.java
//					 ElizaTest.java
// Semester:         CS302 Spring 2016
//
// Author:           Aaron Tze-Rue Tan
// Email:            atan24@wisc.edu
// CS Login:         aaront
// Lecturer's Name:  Jim Williams
// Lab Section:      313
//
////////////////////PAIR PROGRAMMERS COMPLETE THIS SECTION/////////////////////
//
//                  CHECK ASSIGNMENT PAGE TO see IF PAIR-PROGRAMMING IS ALLOWED
//                  If pair programming is allowed:
//                  1. Read PAIR-PROGRAMMING policy (in cs302 policy) 
//                  2. choose a partner wisely
//                  3. REGISTER THE TEAM BEFORE YOU WORK TOGETHER 
//                     a. one partner creates the team
//                     b. the other partner must join the team
//                  4. complete this section for each program file.
//
// Pair Partner:     Eric Jun Hong Chan
// Email:            echan7@wisc.edu
// CS Login:         echan
// Lecturer's Name:  Jim Williams
// Lab Section:      314
//////////////////////////// 80 columns wide //////////////////////////////////

import java.util.Arrays;
import java.lang.*;
import java.util.Scanner;

/**
 * This is a class that contains various methods that would be called by the
 * ElizaTest.java file.
 *
 * @author Aaron Tze-Rue Tan 
 * @author Eric Chan
 */

public class Eliza {

	/**
	 * This method randomly picks one of the strings from the list. If list 
	 * is null or has 0 elements then null is returned.
	 * 
	 * @param list An array of strings to choose from.
	 * @return One of the strings from the list.
	 */		
	public static String chooseString( String [] list) {
		if (list == null || list.length == 0 ) {
			return null; 
		}
		int index = Config.RNG.nextInt(list.length);
		return list [index];
	}

	/**
	 * If the word is found in the wordList then the index of the word
	 * is returned, otherwise -1 is returned. If there are multiple matches
	 * the index of the first matching word is returned. If either word or 
	 * wordList is null then -1 is returned. (Update 2/17) A zero length
	 * string should not be treated differently then non-zero length strings.
	 * A null value within wordList should be ignored.  
	 * 
	 * @param word  A word to search for in the list.
	 * @param wordList  The list of Strings in which to search.
	 * @return The index of list where word is found, or -1 if not found.
	 */
	public static int inList( String word, String []wordList) {
		/*The method is given a word to look for and a list of words to look in. 
		Look through each word in the list starting at the beginning of the 
		list. If a word matches the word in the list then record the index in a 
		variable. Stop looking through the list since a match was found and 
		return the index of the match.*/

		int index = -1;
		if(word == null || wordList == null){
			return index;
		}
		for (int i=0;i<wordList.length;i++){
			//create a string to store and compare the respective string index
			String wordWanted = wordList [i];
			if (word.equals(wordWanted)){
				index = i;
				return index;
			}
		}
		return index;
	}

	/**
	 * Combines the Strings in list together with a space between each
	 * and returns the resulting string. If list is null then null is
	 * returned. (Update 2/17) If the list has 0 elements then return a
	 * string with length 0 (""). If any elements within the list are null
	 * or zero length strings then ignore them since we don't want more than
	 * one space in a row.
	 * 
	 * @param list An array of words to be combined.
	 * @return A string containing all the words with a space between each.
	 */
	public static String assemblePhrase(String[] list) {
		if (list == null){
			return null;
		}
		else if (list.length == 0){
			return "";
		}
		//change the array into a string, while removing the symbols, '[' , ']'
		// and ',' from the array's string
		String n = Arrays.toString(list).replace("[", "").replace("]","")
				.replace(",", "");
		return n;
	}


	/**
	 * Returns the longest sentence, based on the String length, from 
	 * the array of sentences. Removes spaces from the beginning and
	 * end of each sentence before comparing lengths. If sentences is null
	 * or has a length of 0 then null is returned. (Update 2/16) In the 
	 * case of equal length longest strings, return the string that has
	 * the lowest array index.
	 * 
	 * Note: String trim method may be useful.
	 * 
	 * @param sentences The array of sentences passed in.
	 * @return The longest sentence without spaces at the beginning or end.
	 */
	public static String findLongest( String [] sentences) {
		if (sentences == null || sentences.length == 0){
			return null;
		}
		//remove spaces at the beginning and ending of the string and store the
		//  trimmed string into an array
		String i = sentences[0].trim();
		for (int j=1; j<sentences.length;j++){
			if (i.length() < sentences[j].length()){
				i = sentences [j].trim();
			}
			else if (i.length() == sentences[j].length()){
				i = i.trim();
			}
		}
		return i;
	}

	/**
	 * Counts the number of times the substring is in the str. Does not 
	 * count overlapping substrings separately. If either parameter 
	 * substring or str is null then -1 is returned.  (Update 2/17) 
	 * If the substring is the empty string ("") then return the length 
	 * of the string.
	 * 
	 * Note: String methods indexOf may be useful for finding whether
	 *       substring occurs within str. One of the indexOf methods
	 *       has a parameter that says where to start looking in the str.
	 *       This might be useful to find the substring again in str, 
	 *       once you have found a substring once.
	 * 
	 * @param str The string to be searched.
	 * @param substring The string to be searched for within str.
	 * @return The number of times substring is found within str or -1 if
	 *         either parameter is null parameter.
	 */
	public static int howMany( String substring, String str) {
		int lastIndex = 0;
		int count = 0;
		do{
			if (str == null||substring == null){
				return -1;
			}
			if (substring.length() == 0){
				return str.length();
			}
			//finds the respective index of a specific string in the declared 
			// string
			lastIndex = str.indexOf(substring, lastIndex);
			if (lastIndex == -1){
				return count;
			}
			lastIndex += substring.length();
			count++;
		}while (true); 
	}

	/**
	 * This method performs the following processing to the userInput.
	 * - substitute spaces for all characters but (alphabetic characters, 
	 *   numbers, and ' , ! ? .).
	 * - Change (,!?.) to (!). Parenthesis not included.
	 * (Update 2/17) If the userInput is null then return null otherwise 
	 * the array returned should be the same length as the userInput.
	 * 
	 * @param userInput The characters that the user typed in.
	 * @return The character array containing the valid characters.
	 */
	public static char [] filterChars( String userInput) {
		//create an array of char
		//put userInput into the array of chars
		//iterate through the array and check
		//if isdigit or isnumber or is (',!?. change to !) ignore else change
		//to spaces in char
		//return the char[]
		if (userInput == null){
			return null;
		}
		char[] arraytoChar = userInput.toCharArray();
		for (int i=0; i<arraytoChar.length;i++){
			if (!(Character.isDigit(arraytoChar[i])||Character
					.isAlphabetic(arraytoChar[i])|| arraytoChar[i] == ','||
					arraytoChar[i] == '!'||arraytoChar[i] == '?'||arraytoChar[i] 
							== '.'||arraytoChar[i] == '\'')){
				arraytoChar[i] = ' ';
			}
			if (arraytoChar[i] == ','|| arraytoChar[i] == '!'||arraytoChar[i]
					== '?'||arraytoChar[i] == '.'){
				arraytoChar[i] = '!';
			}
		}

		return arraytoChar;
	}

	/**
	 * Reduces all sequences of 2 or more spaces to 1 space within the 
	 * characters array. If any spaces are removed then the same number
	 * of Null character '\u0000' will fill the elements at the end of the
	 * array.
	 * 
	 * @param characters The series of characters that may have more than one
	 *     space in a row when calling. On return the array of characters will
	 *     not have more than one space in a row and there may be '\u0000'
	 *     characters at the end of the array.
	 */

	public static void removeDuplicateSpaces( char [] characters) {
		int i = 0;
		//to reiterate through from starting of the array to the ending,
		//if extra spaces were found, the extra spaces will be replace by 
		//the next array element except the last element remain the same
		for (int j = 1; j< characters.length; j++){
			if (characters[i]==characters[j] && characters[i] == ' ' ){
				characters[i] = characters [j];
				for (int k=j;k<characters.length-1;k++){
					characters [k]= characters[k+1]; 
				}
				//change the last element to null for each time extra spaces 
				//found and moved array elements to the left
				characters[characters.length-1] = '\u0000';
			//if there are no more extra spaces, increase the indexes to the 
				//next array element to compare the next two element, otherwise
				//ensure the index remain the same for the method to 
				//run through again
				if (!(characters[i]==characters[j] && characters[i] 
						== ' ')){
					i++;
				}
				else if (characters[i]==characters[j] && characters[i] 
						== ' ' ){
					j--;
				}
			}
			else{
				i++;
			}
		}
	}

	/**
	 * Looks for each word in words within the wordList. 
	 * If any of the words are found then true is returned, otherwise false.
	 * 
	 * @param words List of words to look for.
	 * @param wordList List of words to look through.
	 * @return Whether one of the words was found in wordList.
	 */
	public static boolean findAnyWords(String[] words, String []wordList ) {
		boolean found = true;
		for (int i=0; i<words.length;i++){
			//checks if a string is located in the specified string, and returns 
			// the value of the index into the integer
			int index = inList(words[i], wordList);
			if (index >=0){
				return found;
			}
		}
		return false;
	}

	/**
	 * This method performs the following processing to the userInput and 
	 * returns the longest resulting sentence.
	 * 1) Converts all characters to lower case  
	 * 		See String toLowerCase() method.
	 * 2) Removes any extra spaces at the beginning or end of the input
	 * 		See String trim() method.
	 * 3) Substitute spaces for all characters but alphabetic characters, 
	 *    numbers, and ',.!? and then substitute ! for ,.?
	 *      See filterChars method.
	 * 4) Reduce all sequences of 2 or more spaces to be one space.
	 *      See removeDuplicateSpaces method.
	 * 5) Divide input into separate sentences based on !
	 *      Construct a String from a character array with 
	 *      	String str = new String( arrayName);
	 *      See String split method.
	 *      Example: String[] sentences = str.split("!");
	 * 6) Determine which sentence is longest in terms of characters and
	 *    return it. 
	 *      See findLongest method.
	 *     
	 * (Update 2/17) If the userInput is null then null should be returned.
	 * 
	 * @param userInput The characters that the user typed in.
	 * @return The longest sentence from the input.
	 */
	public static String initialProcessing( String userInput) {
		//changes each character of the string into lower case characters
		String convertLowerCase = userInput.toLowerCase();
		//remove spaces at the beginning and ending of the string
		String trimmedInput = convertLowerCase.trim();
		//change specific symbols into an '!'
		char [] filteredChar = filterChars(trimmedInput);
		//switch consecutive spaces with a single space
		removeDuplicateSpaces(filteredChar);
		String str = new String (filteredChar);
		// separate the strings that contains a '!' between them into various 
		//strings
		String [] splitSenteces = str.split("!");
		//compare both strings, and find the longer string and assign it to a
		// string
		String longest = findLongest(splitSenteces);
		return longest;
	}

	/**
	 * This method creates a new words list replacing any words it finds in
	 * the beforeList with words in the afterList. An array of the resulting
	 * words is returned.  
	 * 
	 * (Update 2/17) If any parameter is null, return null.
	 * 
	 * @param words List of words to look through.
	 * @param beforeList List of words to look for.
	 * @param afterList List of words to replace, if the corresponding word  
	 * 				in the before list is found in the words array.
	 * @return The new list of words with replacements.
	 */

	public static String[] replacePairs(String []words, String [] beforeList, 
			String [] afterList) {
		if (words ==null || beforeList == null|| afterList ==null){
			return null;
		}
		
		for (int i = 0; i<words.length;i++){
			int index = inList(words[i], beforeList);
			if (index >= 0){
				words[i] = afterList [index];
			}
		}
		//combines the array into a string, with a ' ' separating each array's
		// indexed string
		String combinedWords = assemblePhrase(words);
		// separate the strings that contains a ' ' between them into various 
		//strings
		String [] newWords = combinedWords.split(" ");
		return newWords; 
	}

	/**
	 * Checks to see if the pattern matches the sentence. In other words, 
	 * checks to see that all the words in the pattern are in the sentence 
	 * in the same order as the pattern. If the pattern matches then this
	 * method returns the phrases before, between and after the 
	 * pattern words. If the pattern does not match then null is returned.
	 * (Update 2/17) If any parameter is null, return null.
	 * 
	 * @param pattern The words to match, in order, in the sentence.
	 * @param sentence Each word in the sentence.
	 * @return The phrases before, between and after the pattern words
	 * 		or null if the pattern does not match the sentence.
	 */

	/*Create an array of user phrases that is one longer than the
	number of pattern words. Initialize each user phrase to "".
	Set a pattern index to the first pattern word.
	Set a phrase index to the first user phrase.
	For each word in the sentence
	If the sentence word is the same as the current pattern word
	then increment pattern index to the next pattern word
	and the phrase index to the next user phrase.
	Otherwise append the sentence word to the current user phrase.*/
	public static String [] findPatternInSentence( String [] pattern, 
			String [] sentence) {
		if (pattern == null || sentence == null){
			return null;
		}

		//checks if the indexed string is located in the specified string, and 
		// returns the value of the index into the integer
		int patternA = inList(pattern[0], sentence);
		if (patternA == -1){
			return null;
		}
		for (int j =1; j < pattern.length; j++){
			int patternB = inList(pattern[j], sentence);
			if (patternB == -1){
				return null;
			}
			if (patternB<patternA){
				return null;
			}
		}


		int phraseIndex = 0;
		int patternIndex = 0;
		String userPhrases[] = new String [pattern.length+1];
		for (int i = 0; i<pattern.length+1; i++){
			userPhrases[i] = "";
		}
		for(int index = 0 ; index < sentence.length; index ++ ) {
			//compares the content of the specified indexed string (sentence) 
			// with the other indexed string (pattern) 
			if (sentence[index].equals(pattern[patternIndex])){
				if (patternIndex<pattern.length-1){
					patternIndex++;
				}
				if (phraseIndex<pattern.length){
					phraseIndex++;
				}
			}
			else{
				if (userPhrases[phraseIndex]==""){
					userPhrases[phraseIndex]+=sentence[index];
				}
				else if (userPhrases[phraseIndex]!=""){
					userPhrases[phraseIndex]+=" "+sentence[index];
				}
			}	
		}
		return userPhrases;
	}

	/**
	 * Replaces words in the phrase if they are in the 
	 * Config.POST_PROCESS_BEFORE with the corresponding words from 
	 * Config.POST_PROCESS_AFTER.(Update 2/17) If the parameter is null then 
	 * return null.
	 * 
	 * @param phrase One or more words separated by spaces.
	 * @return A string composed of the words from phrase with replacements.
	 */
	public static String prepareUserPhrase( String phrase) {
		if (phrase ==null){
			return null;
		}
		
		String [] phraseToArray = phrase.split(" ");
		String [] inputPhrase = Config.POST_PROCESS_BEFORE;
		String [] outputPhrase = Config.POST_PROCESS_AFTER;
		//creates an array of string with the strings that has been passed
		//through the method replacePairs
		String [] finalPhrase = replacePairs(phraseToArray, inputPhrase, 
				outputPhrase);

		//create a loop to store all the index of the string array into a
		// string
		String finalPhraseString = finalPhrase[0];
		for (int i = 1; i < finalPhrase.length; i++){
			finalPhraseString = finalPhraseString + " " + finalPhrase[i];
		}
		return finalPhraseString;
	}

	/**
	 * Prepares a response based on the draftResponse. If draftResponse
	 * contains <1>, <2>, <3> or <4> then the corresponding userPhrase
	 * is substituted for the <1>, <2>, etc.  The userPhrase however must
	 * be prepared by exchanging words that are in Config.POST_PROCESS_BEFORE
	 * with the corresponding words from Config.POST_PROCESS_AFTER.
	 * (Update 2/17) If draftResponse is null, then return null. If 
	 * userPhrases is null then return draftResponse.
	 * 
	 * @param draftResponse A response sentence potentially containing <1>, 
	 *             <2> etc.
	 * @param userPhrases An array of phrases from the user input.
	 * @return A string composed of the words from sentence with replacements.
	 */
	public static String prepareResponse( String draftResponse, 
			String []userPhrases) {
		String userInputConverted = null;
		if (draftResponse == null){
			return null;
		}
		if (userPhrases == null){
			return draftResponse;
		}
		for (int i = 0; i <userPhrases.length ; i++){
			//calls the method prepareUserPhrase to change the userPhrases into
			//the respective phrases in the Config.POST_PROCESS_AFTER if part
			// of the string contains phrases in the Config.POST_PROCESS_BEFORE 
			userInputConverted = Eliza.prepareUserPhrase(userPhrases[i]);
			CharSequence phrase1 = "<"+(i+1)+">";
			if (draftResponse.contains(phrase1)){
				draftResponse = draftResponse.replaceFirst("<"+(i+1)+">", 
						userInputConverted);
			}
		}

		return draftResponse; 
	}

	/**
	 * Looks through Config.RESPONSE_TABLE to find the first pattern 
	 * that matches the words. When a pattern is matched then a response 
	 * is randomly chosen from the corresponding list of responses.
	 * If the response has a parameter denoted with <1>, <2> 
	 * etc. the parameter is replaced with the 0th, 1st, etc String
	 * from the user phrases returned by the findPatternInSentence method.
	 * (Update 2/17) If words parameter is null then choose a response 
	 * from NO_MATCH_RESPONSES and return.
	 * 
	 * @param words The words of a sentence.
	 * @return The completed response ready to be shown to the user.
	 */

	/*For each response set in the RESPONSE_TABLE
	If the pattern matches the words (findPatternInSentence)
	Choose a draft response from the response set. (chooseString)
	Prepare the response (prepareResponse) by replacing <1>, <2>, etc. 
	with user phrases found by matching the input to the pattern 
	returned from findPatternInSentence).
	Return the response*/

	public static String matchResponse( String [] words) {
		String newResponse = "";
		String [] newPatternInSentence = null;
		String [] savedNewPattern = null;
		String draftResponse = "";
		int rowIndex =0;
		int colIndex =0;
		if (words == null){
			// randomly assigns a string from the Config.NO_MATCH_RESPONSES
			// into the string (newResponse)
			newResponse = chooseString(Config.NO_MATCH_RESPONSES);
			return newResponse;
		}
		for (int i = 0; i<Config.RESPONSE_TABLE.length;i++){
			for (int j = 0; j<Config.RESPONSE_TABLE[i].length;j++){
				newPatternInSentence = 
						findPatternInSentence(Config.RESPONSE_TABLE
						[i][j],words);
				if (newPatternInSentence != null){
					savedNewPattern = newPatternInSentence;
					rowIndex =i;
					colIndex =j+1;
					break;
				}
			}
			if (newPatternInSentence != null){
				break;
			}
		}
		if (newPatternInSentence != null){
			// randomly assigns an indexed string from the 2 dimensional Array
			// Config.RESPONSE_TABLE into the string (draftResponse)
			draftResponse = chooseString(Config.RESPONSE_TABLE[rowIndex]
					[colIndex]);
		}
		//call the method prepareResponse and assign the returned string into
		// the string (newResponse)
		newResponse = prepareResponse(draftResponse, savedNewPattern);
		return newResponse; 
	}

	/**
	 * Takes the input as a parameter and returns a response. If any of the
	 * QUIT_WORDS are found then null is returned. 
	 * (Update 2/17) If userInput is null then return null;
	 * 
	 * @param userInput The problem sentence(s) the user types in.
	 * @return A response string to be shown to the user or null if a QUIT_WORD
	 *         is found.
	 */
	/*Do initial processing including removing punctuation and selecting the 
	longest sentence.
	Split the sentence into a list of words.
	If any of the Config.QUIT_WORDS are found then return null.
	Replace any words in Config.PRE_PROCESS_BEFORE with corresponding words in 
	Config.PRE_PROCESS_AFTER
	Call matchResponse to obtain a response. 
	Use initialProcessing, findAnyWords, replacePairs, 
	and matchResponse methods written earlier and also, the String split 
	method.*/

	public static String processInput(String userInput) {
		if(userInput == null){
			return null;
		}
		String [] initialProcess = null;
		String [] anyReplaceWords = null;
		String response = "";
		//calls the method initialProcessing, and split the returned words in
		// the string with a space
		initialProcess = initialProcessing(userInput).split(" ");
		boolean quitWordsFound = true;
		quitWordsFound = findAnyWords(initialProcess, Config.QUIT_WORDS);
		if (quitWordsFound){
			return null;
		}
		//calls the method replacePairs and assigns the returned string into
		// the string anyReplaceWords
		anyReplaceWords = replacePairs(initialProcess, 
				Config.PRE_PROCESS_BEFORE, Config.PRE_PROCESS_AFTER);
		response = matchResponse(anyReplaceWords);
		return response; 
	}

	/**
	 * This method displays an INITIAL_MESSAGE, accepts typed input, calls 
	 * the processInput method, and prints out the response (of processInput)
	 * until the response is null at which point the FINAL_MESSAGE is shown
	 * and the program terminates.
	 */

	public static void interactive() {
		String userInput;
		String elizaOutput = "";
		//create a scanner for the user's input
		Scanner inputScanner = new Scanner(System.in);
		System.out.println(Config.PROGRAM_NAME + Config.INITIAL_MESSAGE);
		System.out.print(Config.USER_NAME);
		userInput = inputScanner.nextLine();

		while (elizaOutput!=null){
			//runs the user's input through the method processInput and assign
			// the returned string into Eliza's output
			elizaOutput = processInput(userInput);
			if(elizaOutput !=null){
				System.out.println(Config.PROGRAM_NAME + elizaOutput);
				System.out.print(Config.USER_NAME);
				userInput = inputScanner.nextLine();
			}	
		};
		if (elizaOutput == null){
			System.out.println(Config.PROGRAM_NAME + Config.FINAL_MESSAGE);
		}
		inputScanner.close(); 
	}

	/**
	 * Program execution starts here.
	 * @param args unused
	 */  	
	public static void main(String[] args) {

		interactive();

	}
}