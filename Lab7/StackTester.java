
import java.io.PrintStream;
import java.util.Arrays;
import java.util.EmptyStackException;

public class StackTester {
	public static int score;
	public static PrintStream out;
	public static PrintStream err;
	public static int testNumber;
	
public static void main(String[] args)
{
	score = 0;
	out = System.out;
	err = System.out;
	testNumber = 1;
	pushTest(10);  // Depends on toString
	popTest(5);   // Depends on pushTest
	peekTest(5);  // Depends on popTest
	clearTest(5);  // Depends on pushTest
	sizeTest(5);   // Depends on popTest and clearTest
	emptyTest(3);  // Depends on popTest and clearTest
	searchTest(7); // Depends on pushTest
	
	out.println("The below score assumes correct submission and that you obtained full style points.  Your actual score may be up to 20 points fewer.");
	out.println("Completed " + (testNumber-1) + " out of " + (testNumber-1) + " Tests for a total score of: 40 (no crashes) + 20 (submission and style) + " + score + " (from tests) = " + (60+score));
	}

public static int pushTest(int pnts)
{
	String result = "[Durian, Carrot, Banana, Apple]";
	Stack<String> s = new Stack<String>();
	try {
		s.push("Apple");
		s.push("Banana");
		s.push("Carrot");
		s.push("Durian");
	}
	catch(Exception e)
	{
		err.println("-ERROR IN: pushTest-");
		e.printStackTrace();
	}
	return eval(s, result, pnts, "push");
}

public static int peekTest(int pnts)
{
	Stack<String> s = new Stack<String>();
	String comment = "";
	try {
		boolean correct = true;
		try {
			s.peek();
			comment = "Failed to throw EmptyStackException when empty";
			correct = false;
		}
		catch(EmptyStackException e) {
			
		}
		s.push("Apple");
		s.push("Banana");
		s.push("Carrot");
		s.push("Durian");
		String temp = s.peek();
		if(!("Durian".equals(temp)))
		{
			comment = "Expected \"Durian\" but got \"" + temp + "\"";
			correct = false;
		}
		s.pop();
		temp = s.peek();
		if(!("Carrot".equals(temp)))
		{
			comment = "Expected \"Carrot\" but got \"" + temp + "\"";
			correct = false;
		}
		return disp(correct, pnts, "peek", comment);
	}
	catch(Exception e)
	{
		err.println("-ERROR IN: peekTest-");
		e.printStackTrace();
	}
	return disp(false, pnts, "peek", comment);
	
}

public static int popTest(int pnts)
{
	Stack<String> s = new Stack<String>();
	String comment = "";
	String result = "[Apple]";
	try {
		boolean correct = true;
		try {
			s.pop();
			comment = "Failed to throw EmptyStackException when empty";
			correct = false;
		}
		catch(EmptyStackException e) {
			
		}
		s.push("Apple");
		s.push("Banana");
		s.push("Carrot");
		s.push("Durian");
		String temp = s.pop();
		if(!("Durian".equals(temp)))
		{
			comment = "Expected \"Durian\" but got \"" + temp + "\"";
			correct = false;
		}
		s.pop();
		temp = s.pop();
		if(!("Banana".equals(temp)))
		{
			comment = "Expected \"Banana\" but got \"" + temp + "\"";
			correct = false;
		}
		if(!correct)
			return disp(correct, pnts, "pop", comment);
		return eval(s, result, pnts, "pop");
	}
	catch(Exception e)
	{
		err.println("-ERROR IN: popTest-");
		e.printStackTrace();
	}
	return disp(false, pnts, "pop", comment);
}

public static int emptyTest(int pnts)
{
	String comment = "";
	Stack<String> s = new Stack<String>();
	try {
		boolean correct = true;
		if(!s.empty())
		{
			correct = false;
			comment = "New stack isn't empty";
		}
	s.push("Apple");
		if(s.empty())
		{
			correct = false;
			comment = "Filled stack is empty";
		}
		s.clear();
		if(!s.empty())
		{
			correct = false;
			comment = "Cleared stack isn't empty";
		}
		s.push("Banana");
		s.pop();
		if(!s.empty())
		{
			correct = false;
			comment = "Popped stack isn't empty";
		}
	return disp(correct, pnts, "empty", comment);
	}
	catch(Exception e)
	{
		err.println("-ERROR IN: emptyTest-");
		e.printStackTrace();
	}
	return disp(false, pnts, "empty", comment);
}

public static int sizeTest(int pnts)
{
	String comment = "";
	Stack<String> s = new Stack<String>();
	try {
		boolean correct = true;
	s.push("Apple");
	s.push("Banana");
	s.push("Carrot");
	s.push("Durian");
	s.pop();
	if(!(s.size() == 3))
	{
	correct = false;
	comment = "List of size 3 says it has a size of " + s.size();
	}
	s.clear();
	if(!(s.size() == 0))
	{
		correct = false;
		comment = "List of size 0 says it has a size of " + s.size() + " after clear";
	}
	return disp(correct, pnts, "size", comment);
	}
	catch(Exception e)
	{
		err.println("-ERROR IN: sizeTest-");
		e.printStackTrace();
	}
	return disp(false, pnts, "size", comment);
}

public static int clearTest(int pnts)
{
	String result = "[Carrot]";
	Stack<String> s = new Stack<String>();
	try {
	s.push("Apple");
	s.push("Banana");
	s.clear();
	s.push("Carrot");
	}
	catch(Exception e)
	{
		err.println("-ERROR IN: clearTest-");
		e.printStackTrace();
	}
	return eval(s, result, pnts, "clear");
}

public static int searchTest(int pnts) {
	String comment = "";
	Stack<String> s = new Stack<String>();
	try {
		boolean correct = true;
	s.push("Apple");
	s.push("Banana");
	s.push("Carrot");
	s.push("Durian");
	s.pop();
	int sIndex = s.search("Durian");
	if(sIndex != 1)
	{
	correct = false;
	comment = "Item at top of list (position 1) says it has position " + sIndex;
	}
	sIndex = s.search("Banana");
	if(sIndex != 3)
	{
		correct = false;
		comment = "Item at position 3 says it has position " + sIndex;
	}
	sIndex = s.search("Eggplant");
	if(sIndex != -1)
	{
		correct = false;
		comment = "Item not in list (position -1) says it has position " + sIndex;
	}
	return disp(correct, pnts, "search", comment);
	}
	catch(Exception e)
	{
		err.println("-ERROR IN: searchTest-");
		e.printStackTrace();
	}
	return disp(false, pnts, "search", comment);
}

public static int eval(Stack<String> s, String result, int pnts, String test)
{
	testNumber++;
	try {
	boolean equal = result.equals(s.toString());
	String output = "TEST " + (testNumber-1) + ") " + test + " -> ";
	if(!equal)
		output += ">>>FAILURE<<< (" + "0/" + pnts + ")";
	else
		output += "---SUCCESS--- (" + pnts + "/" + pnts + ")";
	output += " EXPECTED: \"" + result + "\" == YOURS: \"" + s + "\"  ";
	out.println(output);
	if(equal)
	{
		score += pnts;
		return pnts;
	}
	else
		return 0;
	}
	catch(Exception e) {
		out.println("TEST " + (testNumber-1) + ") " + test + " -> " + ">>>FAILURE<<< (0/" + pnts + ") Error in evaluating String");
		return 0;
	}
}

public static int disp(boolean equal, int pnts, String test, String comment) {
	String output = "TEST " + testNumber + ") " + test + " -> ";
	if(!equal)
		output += ">>>FAILURE<<< (" + "0/" + pnts + ")";
	else
		output += "---SUCCESS--- (" + pnts + "/" + pnts + ")";
	output += " " + comment;
	out.println(output);
	testNumber++;
	if(equal)
	{
		score += pnts;
		return pnts;
	}
	else
		return 0;
}

}