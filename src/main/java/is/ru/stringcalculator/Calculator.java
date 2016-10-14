package is.ru.stringcalculator;

public class Calculator {

	public static int add(String text){
		String del = ",|\n";
		String numWithoutDel = text;
		if(text.equals("")){
			return 0;
		}
		if(text.startsWith("//"))
		{
			int delIndex = text.indexOf("//") + 2;
			del = text.substring(delIndex, delIndex + 1);
			numWithoutDel = text.substring(text.lastIndexOf("\n") + 1);
			checkNegatives(splitNumbers(numWithoutDel, del));
			return sum(splitNumbers(numWithoutDel, del));
		}
		else if(text.contains(",") || text.contains("\n"))
		{
			checkNegatives(splitNumbers(numWithoutDel, del));
			return sum(splitNumbers(numWithoutDel, del));
		}
		else
			return 1;
	}

	private static int toInt(String number){
		Integer num = Integer.parseInt(number);
		
		return num;
	}

	private static String[] splitNumbers(String numbers, String delimiter){
	    
		return numbers.split(delimiter);
	}
      
    private static int sum(String[] numbers){
 	    int total = 0;
        for(String number : numbers){
			if(toInt(number) < 1000)
			{
				total += toInt(number);
			}
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