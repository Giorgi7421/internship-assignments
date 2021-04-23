import junit.framework.TestCase;

public class TestClass extends TestCase{
	
	public void testIsPalindrome() {
		assertEquals(true , Main.isPalindrome("a"));
		assertEquals(true , Main.isPalindrome("bb"));
		assertEquals(false , Main.isPalindrome("ab"));
		assertEquals(true , Main.isPalindrome("abba"));
		assertEquals(false , Main.isPalindrome("qwerty"));
		assertEquals(true , Main.isPalindrome("racecar"));
		assertEquals(true , Main.isPalindrome("qwertytrewq"));
		assertEquals(false , Main.isPalindrome("1qazzan1"));
		assertEquals(true , Main.isPalindrome("ablewasIereIsawelba"));
		assertEquals(true , Main.isPalindrome(""));
	}
	
	public void testMinSplit() {
		assertEquals(1 , Main.minSplit(1));
		assertEquals(2 , Main.minSplit(2));
		assertEquals(3 , Main.minSplit(7));
		assertEquals(4 , Main.minSplit(27));
		assertEquals(7 , Main.minSplit(88));
		assertEquals(9 , Main.minSplit(149));
		assertEquals(11 , Main.minSplit(367));
	}
	
	public void testNotContains() {
		int[] arr1 = {1,2,3,4,5};
		assertEquals(6 , Main.notContains(arr1));
		
		int[] arr2 = {1,0,-5,99,12,-7};
		assertEquals(2 , Main.notContains(arr2));
		
		int[] arr3 = {44,-45,-9,7,3,1,2};
		assertEquals(4 , Main.notContains(arr3));
		
		int[] arr4 = {-78,-11,55,5,21,2};
		assertEquals(1 , Main.notContains(arr4));
		
		int[] arr5 = {34,70,-43,11,-2,4,6,2,1};
		assertEquals(3 , Main.notContains(arr5));
		
		int[] arr6 = {2};
		assertEquals(1 , Main.notContains(arr6));
		
		int[] arr7 = {};
		assertEquals(1 , Main.notContains(arr7));
	}
	
	public void testIsProperly() {
		assertEquals(true , Main.isProperly("()"));
		assertEquals(true , Main.isProperly("(())"));
		assertEquals(false , Main.isProperly("("));
		assertEquals(false , Main.isProperly("())"));
		assertEquals(true , Main.isProperly("()()"));
		assertEquals(false , Main.isProperly("(()))"));
		assertEquals(true , Main.isProperly("(()(()))"));
		assertEquals(true , Main.isProperly("(((()))()(()))"));
	}
	
	public void testCountVariants() {
		assertEquals(3 , Main.countVariants(3));
		assertEquals(5 , Main.countVariants(4));
		assertEquals(8 , Main.countVariants(5));
		assertEquals(13 , Main.countVariants(6));
		assertEquals(21 , Main.countVariants(7));
		assertEquals(34 , Main.countVariants(8));
		assertEquals(1 , Main.countVariants(1));
		assertEquals(2 , Main.countVariants(2));
		assertEquals(89 , Main.countVariants(10));
		assertEquals(1346269 , Main.countVariants(30));
	}
}
