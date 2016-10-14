package is.ru.stringcalculator;

import java.util.LinkedList;
import java.util.List;

public class Calculator {

	public static int add(String text){
		if(text.equals("")){
			return 0;
		}
		else if(text.contains(",") || text.contains("\n"))
		{
			checkNegatives(splitNumbers(text));
			return sum(splitNumbers(text));
		}
		else
			return 1;
	}

	private static int toInt(String number){
		Integer num = Integer.parseInt(number);
		
		return num;
	}

	private static String[] splitNumbers(String numbers){
	    
		return numbers.split(",|\n");
	}
      
    private static int sum(String[] numbers){
 	    int total = 0;
        for(String number : numbers){
		    total += toInt(number);
		}
		return total;
    }
	
	private static void checkNegatives(String[] numbers)
	{
		String negatives = "";
        for(String number : numbers){
			if(toInt(number) < 0)
			{
				negatives += "," + number;
			}
		}
		
		if(negatives.length() > 0)
		{
			throw new RuntimeException("Negatives not allowed: " + negatives.substring(1));
		}
	}
}