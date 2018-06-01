///////////////////////////////////////////////////////////////////////////////
//ALL STUDENTS COMPLETE THESE SECTIONS
//Title:            Eliza
//Files:            ElizaTest.java
//					Eliza.java
//Semester:         CS302 Spring 2016
//
//Author:           Aaron Tze-Rue Tan
//Email:            atan24@wisc.edu
//CS Login:         aaront
//Lecturer's Name:  Jim Williams
//Lab Section:      313
//
////////////////////PAIR PROGRAMMERS COMPLETE THIS SECTION ////////////////////
//
//CHECK ASSIGNMENT PAGE TO see IF PAIR-PROGRAMMING IS ALLOWED
//If pair programming is allowed:
//1. Read PAIR-PROGRAMMING policy (in cs302 policy) 
//2. choose a partner wisely
//3. REGISTER THE TEAM BEFORE YOU WORK TOGETHER 
//a. one partner creates the team
//b. the other partner must join the team
//4. complete this section for each program file.
//
//Pair Partner:     Eric Jun Hong Chan
//Email:            echan7@wisc.edu
//CS Login:         echan
//Lecturer's Name:  Jim Williams
//Lab Section:      314
////////////////////////////80 columns wide //////////////////////////////////


import java.util.Arrays;

/**
 * This is a class that calls and implement various methods that would be
 * called by the Eliza.java file.
 *
 * @author Aaron Tze-Rue Tan
 * @author Eric Chan
 */

//TODO add method header comments

public class ElizaTests {

	//Check if the method chooseString is running smoothly
	public static void testChooseString() {

		String [] strList = {"The", "happy", "cat"};
		//calls the method chooseString and runs the string array strList 
		//through it
		String choice = Eliza.chooseString( strList);
		if ( choice != null && (choice.equals("The") || choice.equals("happy") 
				|| choice.equals("cat"))) {
			System.out.println("testChooseString 1 passed.");
		} else {
			System.out.println("testChooseString 1 failed.");
		}

		int countThe = 0;
		int countHappy = 0;
		int countCat = 0;
		for ( int i = 1; i <= 100; i++) {
			choice = Eliza.chooseString( strList);
			if ( choice != null) {
				if ( choice.equals("The")) {
					countThe++;
				} else if ( choice.equals("happy")) {
					countHappy++;
				} else if ( choice.equals("cat")) {
					countCat++;
				}
			}
		}
		if ( countThe >=20 && countThe <= 45 
				&& countHappy >= 20 && countHappy <= 45
				&& countCat >= 20 && countCat <= 45) {
			System.out.println("testChooseString 2 passed. " + countThe
					+ "," + countHappy + "," + countCat);
		} else {
			System.out.println("testChooseString 2 failed. " + countThe
					+ "," + countHappy + "," + countCat);
		}
	}

	//Check if the method inList is running smoothly
	public static void testInList() {
		String [] quitWords = {"bye","goodbye","quit", "bye"};	
		//calls the method inList to check if the string "bye" is contained in
		// the string array quitWords
		int index = Eliza.inList( "bye", quitWords);
		if ( index >= 0) {
			System.out.println("testInList 1 passed.");
		} else {
			System.out.println("testInList 1 failed.");
		}

		//calls the method inList to check if the second string "bye" is 
		// contained in the string array quitWords
		index = Eliza.inList( "bye", quitWords);
		if ( index == 0) {
			System.out.println("testInList 2 passed.");
		} else if(index==3) {			
			System.out.println("testInList 2 failed.");
		}

		//calls the method inList to check if the string "seeya" is contained in
		// the string array quitWords
		index = Eliza.inList( "seeya", quitWords);
		if ( index == -1) {
			System.out.println("testInList 3 passed.");
		} else {
			System.out.println("testInList 3 failed.");
		}

		//calls the method inList to check if the string "good" is contained in
		// the string array quitWords
		index = Eliza.inList( "good", quitWords);
		if ( index == -1) {
			System.out.println("testInList 4 passed.");
		} else {
			System.out.println("testInList 4 failed.");
		}
	}

	//Check if the method assemblePhrases is running smoothly
	public static void testAssemblePhrase() {
		String [] words = {"This", "is a", "sentence"};
		String [] words2 = {"W", "to", "the", "H", "to", "the", "O", "to", 
				"the", "R", "to", "the", "E"};
		String [] words3 = null;
		String [] words4 = {};

		//to check if array passed through the param is combined into a string
		String sentence = Eliza.assemblePhrase( words);
		String sentence2 = Eliza.assemblePhrase(words2);
		//to check if null is return if null is passed through
		String sentence3 = Eliza.assemblePhrase(words3);
		//to check if empty string is return if empty array is passed through
		String sentence4 = Eliza.assemblePhrase(words4);

		String expectedSentence = "This is a sentence";
		String expectedSentence2 = "W to the H to the O to the R to the E";
		String expectedSentence3 = null;
		String expectedSentence4 = "";

		if (sentence.equals( expectedSentence)) {
			System.out.println("testAssembleSentence 1 passed.");
		} 
		else {
			System.out.println("testAssembleSentence 1 failed '" + sentence + 
					"'");
		}

		if (sentence2.equals( expectedSentence2)) {
			System.out.println("testAssembleSentence 2 passed.");
		} 
		else {
			System.out.println("testAssembleSentence 2 failed '" + sentence2 + 
					"'");
		}

		if (sentence3 == expectedSentence3) {
			System.out.println("testAssembleSentence 3 passed.");
		} 
		else {
			System.out.println("testAssembleSentence 3 failed '" + sentence3 + 
					"'");
		}
		if (sentence4.equals(expectedSentence4)) {
			System.out.println("testAssembleSentence 4 passed.");
		} 
		else {
			System.out.println("testAssembleSentence 4 failed '" + sentence4 + 
					"'");
		}	
	}

	//Check if the method findLongest is running smoothly
	public static void testFindLongest() {
		String [] sentences = {"short", "This is longer.", 
				"This is the longest one.", "s"};
		String [] sentences2 = null;
		String [] sentences3 = {};
		String [] sentences4 = {"banana", "banana", "pomegranate", 
		"pomegranate"};
		String [] sentences5 = {"    short           ", " This is longer. ", 
				"    This is the longest one. ", "   s        "};

		//to check if longest array element is return
		String longest = Eliza.findLongest( sentences);
		//to check if null is return
		String longest2 = Eliza.findLongest(sentences2);
		//to check if null is return for an empty array
		String longest3 = Eliza.findLongest(sentences3);
		//to check if the first longest array element return
		String longest4 = Eliza.findLongest(sentences4);
		//to check if spaces are trim before returning longest sentence
		String longest5 = Eliza.findLongest(sentences5);


		if ( longest == sentences[2]) {
			System.out.println("testFindLongest 1 passed.");
		} else {
			System.out.println("testFindLongest 1 failed.");
		}
		if ( longest2 == null) {
			System.out.println("testFindLongest 2 passed.");
		} else {
			System.out.println("testFindLongest 2 failed.");
		}
		if ( longest3 == null) {
			System.out.println("testFindLongest 3 passed.");
		} else {
			System.out.println("testFindLongest 3 failed.");
		}
		if (longest4 == sentences4[2]){
			System.out.println("testFindLongest 4 passed.");
		} else {
			System.out.println("testFindLongest 4 failed.");
		}
		if (longest5.equals(sentences5[2].trim())){
			System.out.println("testFindLongest 5 passed.");
		} else {
			System.out.println("testFindLongest 5 failed.");
		}

	}

	//Check if the method howMany is running smoothly
	public static void testHowMany() {
		//to check if how many spaces count are return
		int countSpaces = Eliza.howMany( " ", " you me ");
		if ( countSpaces == 3) {
			System.out.println( "testHowMany 1 passed.");
		} else {
			System.out.println( "testHowMany 1 failed.  countSpaces == " 
					+ countSpaces);
		}

		//to check the count if other types of string passes through
		int countNum = Eliza.howMany("<2>", "What makes you think I am <2>?");
		if ( countNum == 1) {
			System.out.println( "testHowMany 2 passed.");
		} else {
			System.out.println( "testHowMany 2 failed.  countNum == " 
					+ countNum);
		}


		/*If either parameter 
		 * substring or str is null then -1 is returned.  (Update 2/17) 
		 * If the substring is the empty string ("") then return the length 
		 * of the string.*/
		int countNull = Eliza.howMany(null, " potangina bobo ");
		if ( countNull == -1) {
			System.out.println( "testHowMany 3 passed.");
		} else {
			System.out.println( "testHowMany 3 failed.  countNull == " 
					+ countNull);
		}

		int countNull2 = Eliza.howMany("cyka", null);
		if ( countNull2 == -1) {
			System.out.println( "testHowMany 4 passed.");
		} else {
			System.out.println( "testHowMany 4 failed.  countNull2 == " 
					+ countNull2);
		}

		int countEmptyString = Eliza.howMany("", " potangina bobo ");
		if ( countEmptyString == 16) {
			System.out.println( "testHowMany 5 passed.");
		} else {
			System.out.println( "testHowMany 5 failed.  countEmptyString == " 
					+ countEmptyString);
		}
	}		

	//Check if the method filterChars is running smoothly
	public static void testFilterChars() {
		//to check if filterchars replace all symbols except specific ones with
		//spaces
		String userInput = "w? #t   i't e   4t m-s!";
		char [] expectedChars = {'w','!',' ',' ','t',' ',' ',' ','i','\'','t',
				' ','e',' ',' ',' ','4','t',' ','m',' ','s','!'};
		char [] characters = Eliza.filterChars( userInput);
		if ( userInput.length() == characters.length) {
			System.out.println("testFilterChars 1 passed.");
		} else {
			System.out.println("testFilterChars 1 failed.");
		}
		boolean error = false;
		for ( int i = 0; i < expectedChars.length; i++) {
			if ( expectedChars[i] != characters[i]) {
				System.out.print( String.format("characters[%d] '%c' expected "
						+ "'%c'\n", i, characters[i], expectedChars[i]));
				error = true;
			}
		}
		if ( error) {
			System.out.println("testFilterChars 2 failed.");
		} else {
			System.out.println("testFilterChars 2 passed.");
		}

		//to check if null is return if null is passed through
		String userInput2 = null;
		char [] expectedChars2 = null;
		char [] characters2 = Eliza.filterChars( userInput2);
		if (characters2 == expectedChars2){
			System.out.println("testFilterChars 3 passed.");
		}
		else {
			System.out.println("testFilterChars 3 failed.");
		}

		String userInput3 = "";
		char [] characters3 = Eliza.filterChars(userInput3);
		if (characters3.length == userInput3.length()){
			System.out.println("testFilterChars 4 passed.");
		}
		else {
			System.out.println("testFilterChars 4 failed.");
		}
	}

	//Check if the method removeDuplicateSpaces is running smoothly
	public static void testRemoveDuplicateSpaces() {
		//to check if one duplicate space will be removed
		char [] chars1 = {'a', 't', ' ', '.', ' ', ' ', 'g', ' ', ' ', 'h', 
		' '};
		Eliza.removeDuplicateSpaces( chars1);
		char [] expectedResult = {'a', 't', ' ', '.', ' ', 'g', ' ', 'h', ' ',
				'\u0000', '\u0000'};

		boolean error = false;
		String errorStr = "";
		for ( int i = 0; i < expectedResult.length; i++) {
			if ( chars1[i] != expectedResult[i]) {
				errorStr += String.format("chars1[%d] '%c' expected '%c'\n", i,
						chars1[i], expectedResult[i]);
				error = true;
			}
		}
		if ( error) {
			System.out.println("testRemoveDuplicateSpaces 1 failed. " + 
					errorStr);
		} else {
			System.out.println("testRemoveDuplicateSpaces 1 passed.");
		}

		//to check if multiple duplicate spaces is returned
		char [] chars2 = {'a', 't', ' ', '.', ' ', ' ', 'g', ' ', ' ',' ',' ',
				' ', 'h', ' ',' ',' ',' '};
		Eliza.removeDuplicateSpaces( chars2);
		char [] expectedResult2 = {'a', 't', ' ', '.', ' ', 'g', ' ', 'h', ' ',
				'\u0000', '\u0000', '\u0000', '\u0000', '\u0000'};

		boolean error2 = false;
		String errorStr2 = "";
		for ( int j = 0; j < expectedResult2.length; j++) {
			if ( chars2[j] != expectedResult2[j]) {
				errorStr2 += String.format("chars2[%d] '%c' expected '%c'\n", 
						j, chars2[j], expectedResult2[j]);
				error2 = true;
			}
		}
		if ( error2) {
			System.out.println("testRemoveDuplicateSpaces 2 failed. " + 
					errorStr2);
		} else {
			System.out.println("testRemoveDuplicateSpaces 2 passed.");
		}
	}

	//Check if the method findAnyWords is running smoothly
	public static void testFindAnyWords() {
		//to check if words exactly the same as Config.QUIT_WORDS return true
		String[] someWords = {"Going", "now", "goodbye"};
		boolean found = Eliza.findAnyWords( someWords, Config.QUIT_WORDS);
		if ( found) {
			System.out.println("testFindAnyWords 1 passed.");
		} else {
			System.out.println("testFindAnyWords 1 failed.");
		}

		String[] someMoreWords = {"Hello", "how", "are", "you"};
		found = Eliza.findAnyWords( someMoreWords, Config.QUIT_WORDS);
		if ( !found) {
			System.out.println("testFindAnyWords 2 passed.");
		} else {
			System.out.println("testFindAnyWords 2 failed.");
		}

		//to check if words are the same as preprocessbefore return true
		String[] moreMoreWords = {"Cyka", "Sandy", "bashful", "sorry", "Jeremy"
				, "Mangosteen"};
		found = Eliza.findAnyWords( moreMoreWords, Config.PRE_PROCESS_BEFORE);
		if ( found) {
			System.out.println("testFindAnyWords 3 passed.");
		} else {
			System.out.println("testFindAnyWords 3 failed.");
		}
	}

	//Check if the method initialProcessing is running smoothly
	public static void testInitialProcessing() {
		//to check if String toLowerCase, trim, split and String constructor 
		//methods. This method also calls the filterChars, removeDuplicateSpaces 
		//and findLongest and check if function correctly
		String sentence = Eliza.initialProcessing("What? This isn't the "
				+ "    4th messy-sentence!");
		if ( sentence != null 
				&& sentence.equals( "this isn't the 4th messy sentence")){
			System.out.println("testInitialProcessing 1 passed.");
		} else {
			System.out.println("testInitialProcessing 1 failed:" + sentence);
		}

		String sentence2 = Eliza.initialProcessing(" (@_@) Hello, I am Ellie"
				+ "   " + "   TeAch me TO cOunt! Then ASK Your Family To Visit"
				+ " you   ");
		if ( sentence2 != null 
				&& sentence2.equals( "then ask your family to visit you")){
			System.out.println("testInitialProcessing 2 passed.");
		} else {
			System.out.println("testInitialProcessing 2 failed:" + sentence2);
		}
	}

	//Check if the method replacePairs is running smoothly
	public static void testReplacePairs() {
		//to check if somewords that exist in before list replaced with 
		//corresponding words in after list
		//if words in after list contain spaces, return two array element
		String [] someWords = {"i'm", "cant", "recollect"};
		String [] beforeList = {"dont", "cant", "wont", "recollect", "i'm"};
		String [] afterList = {"don't", "can't", "won't", "remember", "i am"};
		String [] result = Eliza.replacePairs( someWords, beforeList, 
				afterList);
		if ( result != null && result[0].equals("i") && result[1].equals("am") 
				&& result[2].equals("can't") && result[3].equals("remember")) {
			System.out.println("testReplacePairs 1 passed.");
		} else {
			System.out.println("testReplacePairs 1 failed." + 
					Arrays.toString(someWords));
		}

		String [] someWords2 = {"he's", "douches", "ain't"};
		String [] beforeList2 = {"he's", "cant", "douches","ain't"};
		String [] afterList2 = {"he is", "can't", "doucherys","are not"};
		String [] result2 = Eliza.replacePairs(someWords2, 
				beforeList2, afterList2);
		if ( result2 != null && result2[0].equals("he") && 
				result2[1].equals("is") 
				&& result2[2].equals("doucherys") && result2[3].equals("are")) {
			System.out.println("testReplacePairs 2 passed.");
		} else {
			System.out.println("testReplacePairs 2 failed." 
					+Arrays.toString(result2));
		}
	}

	//Check if the method findPatternInSentence is running smoothly
	public static void testFindPatternInSentence() {
		//to check if pattern is identified and return the array with identified
		//pattern changed to arrays elements before, in between or after
		String [] pattern1 = { "computer"};
		String [] sentence1 = {"are", "you", "a", "computer"};

		String [] matches = Eliza.findPatternInSentence( pattern1, sentence1);
		if ( matches != null && matches.length == 2 
				&& matches[0].equals( "are you a") && matches[1].equals("")) {
			System.out.println("testFindPatternInSentence 1 passed.");
		} else {
			System.out.println("testFindPatternInSentence 1 failed.");
			System.out.println( Arrays.toString(matches));
		}

		String [] pattern2 = { "computer"};
		String [] sentence2 = {"computer", "are", "you"};

		matches = Eliza.findPatternInSentence( pattern2, sentence2);
		if ( matches != null && matches.length == 2 && matches[0].equals("") 
				&& matches[1].equals( "are you")) {
			System.out.println("testFindPatternInSentence 2 passed.");
		} else {
			System.out.println("testFindPatternInSentence 2 failed.");
			System.out.println( Arrays.toString(matches));
		}

		String [] pattern5 = { "computer"};
		String [] sentence5 = {"does", "that", "computer", "on", "your", 
				"desk", "work"};
		matches = Eliza.findPatternInSentence( pattern5, sentence5);
		if ( matches != null && matches.length == 2 
				&& matches[0].equals( "does that") 
				&& matches[1].equals( "on your desk work")) {
			System.out.println("testFindPatternInSentence 3 passed.");
		} else {
			System.out.println("testFindPatternInSentence 3 failed.");
			System.out.println( Arrays.toString(matches));
		}

		String [] pattern6 = {"you", "me"};
		String [] sentence6 = {"why", "don't", "you", "like",  "me"};
		matches = Eliza.findPatternInSentence( pattern6, sentence6);
		if ( matches != null && matches.length == 3 
				&& matches[0].equals( "why don't") 
				&& matches[1].equals( "like") && matches[2].equals("")) {
			System.out.println("testFindPatternInSentence 4 passed.");
		} else {
			System.out.println("testFindPatternInSentence 4 failed.");
			System.out.println( Arrays.toString(matches));
		}

		//to check if pattern sentence passed isn't in order return null
		String [] pattern7 = {"you", "me"};
		String [] sentence7 = {"me", "don't", "like", "you"};
		matches = Eliza.findPatternInSentence( pattern7, sentence7);
		if ( matches == null) {
			System.out.println("testFindPatternInSentence 5 passed.");
		} else {
			System.out.println("testFindPatternInSentence 5 failed.");
			System.out.println( Arrays.toString(matches));
		}

		//to check if pattern doesnt exist return null
		String [] pattern8 = {"awful", "you"};
		String [] sentence8 = {"me", "don't", "like", "you"};
		matches = Eliza.findPatternInSentence( pattern8, sentence8);
		if ( matches == null) {
			System.out.println("testFindPatternInSentence 6 passed.");
		} else {
			System.out.println("testFindPatternInSentence 6 failed.");
			System.out.println( Arrays.toString(matches));
		}

		//to check if null is return if null is passed through
		String [] pattern9 = {null};
		String [] sentence9 = {"you", "don't", "seem", "to", "say", "much"};
		matches = Eliza.findPatternInSentence( pattern9, sentence9);
		if ( matches == null) {
			System.out.println("testFindPatternInSentence 7 passed.");
		} else {
			System.out.println("testFindPatternInSentence 7 failed.");
			System.out.println( Arrays.toString(matches));
		}
	}

	//Check if the method prepareUserPhrase is running smoothly
	public static void testPrepareUserPhrase()  {
		//to check if words are replaced with words in corresponding words in 
		//table of the Config file
		String someWords = "i'm happy";
		String result = Eliza.prepareUserPhrase( someWords);
		if ( result != null && result.equals("you are happy")) {
			System.out.println("testPrepareUserPhrase 1 passed.");
		} else {
			System.out.println("testPrepareUserPhrase 1 failed. '" + result 
					+ "'");
		}

		String someWords2 = "am i annoying";
		String result2 = Eliza.prepareUserPhrase( someWords2);
		if ( result2 != null && result2.equals("are you annoying")) {
			System.out.println("testPrepareUserPhrase 2 passed.");
		} else {
			System.out.println("testPrepareUserPhrase 2 failed. '" + result2 
					+ "'");
		}

		String someWords3 = "me myself and i";
		String result3 = Eliza.prepareUserPhrase( someWords3);
		if ( result3 != null && result3.equals("you yourself and you")) {
			System.out.println("testPrepareUserPhrase 3 passed.");
		} else {
			System.out.println("testPrepareUserPhrase 3 failed. '" + result3 
					+ "'");
		}
	}

	//Check if the method prepareResponse is running smoothly
	public static void testPrepareResponse() {
		//to check if <number> is return with the index = number element of the
		//second array
		String draftResponse = "Really, <3>?";
		String []userPhrases = {"", "", "about my dog"};
		String response = Eliza.prepareResponse( draftResponse, userPhrases);

		String expectedResponse = "Really, about your dog?";

		if ( response.equals( expectedResponse)) {
			System.out.println("testPrepareResponse 1 passed.");
		} else {
			System.out.println("testPrepareResponse 1 failed. '" + response 
					+ "'");
		}


		String draftResponse2 = "It's <2>!";
		String []userPhrases2 = {"you and me", "me myself and i", "their fault"
				, "not my fault", "our fault"};
		String response2 = Eliza.prepareResponse( draftResponse2, userPhrases2);


		String expectedResponse2 = "It's you yourself and you!";
		if ( response2.equals( expectedResponse2)) {
			System.out.println("testPrepareResponse 2 passed.");
		} else {
			System.out.println("testPrepareResponse 2 failed. '" + response2 
					+ "'");
		}
	}

	//Check if the method matchResponse is running smoothly
	public static void testMatchResponse() {
		//to check if pattern is run through inital process, and replace with
		//corresponding words in table in Config file when first pattern is 
		//found in table
		String []words1 = {"are", "you", "a", "computer"};
		String response1 = Eliza.matchResponse( words1);
		if ( Eliza.inList( response1, Config.RESPONSE_TABLE[0][1]) >= 0) {
			System.out.println("testMatchResponse 1 passed.");
		} else {
			System.out.println("testMatchResponse 1 failed."+response1);
		}

		String []words2 = {"you", "are", "like", "my", "father"};
		String response2 = Eliza.matchResponse( words2);
		if ( response2 != null && response2.contains( "like your father")) {
			System.out.println("testMatchResponse 2 passed.");
		} else {
			System.out.println("testMatchResponse 2 failed."+response2);
		}

		String []words3 = {"I", "fell", "in", "love", "with", "you"};
		String response3 = Eliza.matchResponse( words3);
		if ( response3 != null && response3.contains( "your feelings")) {
			System.out.println("testMatchResponse 3 passed.");
		} else {
			System.out.println("testMatchResponse 3 failed."+response3);
		}

		//to check if null is return when passed through and return elements
		//from no response table
		String []words4 = null;
		String response4 = Eliza.matchResponse( words4);
		if ( response4 != null && response4.contains(
				Config.NO_MATCH_RESPONSES[1])) {
			System.out.println("testMatchResponse 4 passed.");
		} else {
			System.out.println("testMatchResponse 4 failed." +response4);
		}
	}

	//Check if the method problem is running smoothly
	private static void testProblem(String problem) {
		//supporting method for testProcessInput
		System.out.println("Patient:  " + problem);
		System.out.println("Eliza: " + Eliza.processInput( problem));
	}

	//Check if the method processInput is running smoothly
	public static void testProcessInput() {
		//note: the responses may vary as they are randomly selected and the 
		//random generator results will vary based on the previous times it 
		//has been called. Therefore, see if each response is appropriate.

		//updated 2/17
		testProblem("I like computers.");
		testProblem("What is your name?");
		testProblem("You remind me of a grumpy uncle.");
		testProblem("You don't seem to say much.");
		testProblem("You reflect me.");
		testProblem("Are you satisfied with your current living situation now?"
				+ "");
		testProblem("I wish to believe you.");
		testProblem("I dreamed of going into space.");
		testProblem("I apologize for boring you.");
		testProblem("Because it seems the polite thing to do.");
		testProblem("Yes.");
		testProblem("I remember being in 1st grade.");
		testProblem("No, not often. Sometimes I remember being on a boat.");
		testProblem("My family liked to play cards.");
		testProblem("Do you remember growing up?");
		testProblem("Are you a Packers fan?");
		testProblem("I am sad to hear that.");
		testProblem("I cannot explain this.");
		testProblem("You seem to have a different perspective than many.");
		testProblem("I'm talking to my dog.");
		testProblem("goodbye");
	}

	//list of tests to be run when testing the respective tests, and it is to 
	//be commented out if its not being tested
	public static void main(String[] args) {

		//		testChooseString();

		//		testInList();
		//		testAssemblePhrase();
		//		testFindLongest();
		//		testHowMany();
		//
		//		testFilterChars();
		//		testRemoveDuplicateSpaces();
		testFindAnyWords();
		//		testInitialProcessing();
		//
		//		testReplacePairs();
		//		testFindPatternInSentence();
		//		testPrepareUserPhrase();
		//		testPrepareResponse();
		//
		//		testMatchResponse();
		//		testProcessInput();

	}
}
