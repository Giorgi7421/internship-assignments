import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Main {
	
	public static boolean isPalindrome(String text) {
		String Reverse = "";
		for(int i = text.length() - 1 ; i >= 0 ; i--) {
			Reverse += text.charAt(i);
		}
		return text.equals(Reverse);
	}
	
	public static int minSplit(int amount) {
		if(amount <= 0) {
			return 0;
		}
		
		int counter = 0;
		int[] coins = {50 , 20 , 10 , 5 , 1};
		
		for(int i = 0 ; i < coins.length ; i++) {
			counter += amount / coins[i];
			amount = amount % coins[i];
		}
		return counter;
	}
	
	public static int notContains(int[] array) {
		if(array.length == 0) {
			return 1;
		}
		
		Arrays.sort(array);
		
		if(array[array.length - 1] <= 0) {
			return 1;
		}
		
		int firstPositiveIndex = -1;
		
		for(int i = 0 ; i < array.length ; i++) {
			if(array[i] > 0) {
				firstPositiveIndex = i;
				break;
			}
		}
		if(array[firstPositiveIndex] != 1) {
			return 1;
		}else if(firstPositiveIndex != array.length - 1){
			for(int i = firstPositiveIndex + 1 ; i < array.length ; i++) {
				if(array[i] - array[i - 1] >= 2) {
					return array[i - 1] + 1;
				}
			}
		}else {
			return 2;
		}
		return array[array.length - 1] + 1;
	}
	
	public static boolean isProperly(String sequence) {
		Stack<Character> st = new Stack<Character>();
		for(int i = 0 ; i < sequence.length() ; i++) {
			if(st.isEmpty()) {
				st.add(sequence.charAt(i));
			}else {
				if(st.peek().equals('(') && sequence.charAt(i) == ')') {
					st.pop();
				}else {
					st.add(sequence.charAt(i));
				}
			}
		}
		return st.isEmpty();
	}
	
	public static int countVariants(int stearsCount) {
		if(stearsCount <= 0) {
			return 0;
		}
		
		if(stearsCount == 1) {
			return 1;
		}else if(stearsCount == 2) {
			return 2;
		}else {
			return countVariants(stearsCount - 1) + countVariants(stearsCount - 2);
		}
	}
	
	private static String getQuantityOrRateString(String token , boolean quantityFlag) {
		char symbol;
		
		if(quantityFlag) {
			symbol = ' ';
		}else {
			symbol = '<';
		}
		
		String result = "";
		
		int MeaningfulInfoStartingPoint = 7;
		
		for(int i = MeaningfulInfoStartingPoint ; i < token.length() ; i++) {
			if(token.charAt(i) == symbol) {
				break;
			}else {
				result += token.charAt(i);
			}
		}
		return result;
	}
	
	public static Double exchangeRate(String from, String to) throws MalformedURLException, SAXException, IOException, ParserConfigurationException {
		
		//parses xml in given url
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        Document doc = factory.newDocumentBuilder().parse(new URL("http://www.nbg.ge/rss.php").openStream());
        
        //loads entire html from description tag into string txt
        NodeList lst = doc.getElementsByTagName("description");
        Node n = lst.item(1);
        Element e = (Element) n;
        String txt = e.getTextContent();
        
        // tokenize html string
        StringTokenizer st = new StringTokenizer(txt , "\n");
        
        // exchange rate and quantity values of inputed currencies as strings
        String fromQuantity = "";
        String fromRate = "";
        String toQuantity = "";
        String toRate = "";
        
        // populating above strings
        while(st.hasMoreTokens()) {
        	String tmp = st.nextToken();
        	if(tmp.contains(from)) {
        		String tmp2 = st.nextToken();
        		fromQuantity = getQuantityOrRateString(tmp2 , true);
        		String tmp3 = st.nextToken();
        		fromRate = getQuantityOrRateString(tmp3 , false);
        	}
        	if(tmp.contains(to)) {
        		String tmp2 = st.nextToken();
        		toQuantity = getQuantityOrRateString(tmp2 , true);
        		String tmp3 = st.nextToken();
        		toRate = getQuantityOrRateString(tmp3 , false);
        	}
        }
        
        double fromQauntityValue = 1;
        double fromRateValue = 1;
        double toQauntityValue = 1;
        double toRateValue = 1;
        
        if(!from.equals("GEO")) {
        	fromQauntityValue = Double.parseDouble(fromQuantity);
            fromRateValue = Double.parseDouble(fromRate);
        }
        
        if(!to.equals("GEO")) {
        	toQauntityValue = Double.parseDouble(toQuantity);
            toRateValue = Double.parseDouble(toRate);
        }
        
        double fromOneRate = fromRateValue / fromQauntityValue;
        double toOneRate = toRateValue / toQauntityValue;
        
        double result = fromOneRate / toOneRate;
        return result;
	}
	
	

}
