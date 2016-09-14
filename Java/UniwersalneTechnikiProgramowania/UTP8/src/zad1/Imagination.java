package zad1;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

public class Imagination {
	
//	protected static BigDecimal A;
//	protected static BigDecimal B;
	private static Map<String, String> mapqa = new HashMap<>();
//	protected static String imaginaryMessage;
	
	public static void setImaginaryFriendz(BigDecimal a, BigDecimal b){
//		A = a;
//		B = b;
		mapqa.put("+", getAddition(a, b));
		mapqa.put("-", getSubstraction(a, b));
		mapqa.put("*", getMultiplication(a, b));
		mapqa.put("/", getDivision(a, b));
//		imaginaryMessage = "Invalid command to calc";

	}

	
	public static String getResult(String option) throws Exception{
		
		
		String sth = mapqa.get(option);
		@SuppressWarnings("unused")
		String fake = sth.intern();
		
		return mapqa.get(option);
	}
	
	public static String getAddition(BigDecimal a, BigDecimal b) {
		return a.add(b).setScale(7, RoundingMode.HALF_UP).stripTrailingZeros().toString();
	}
	
	public static String getSubstraction(BigDecimal a, BigDecimal b) {
		return a.subtract(b).setScale(7, RoundingMode.HALF_UP).stripTrailingZeros().toString();
	}
	
	public static String getMultiplication(BigDecimal a, BigDecimal b) {
		return a.multiply(b).setScale(7, RoundingMode.HALF_UP).stripTrailingZeros().toString();
	}
	
	public static String getDivision(BigDecimal a, BigDecimal b) {
		return a.divide(b, 7, RoundingMode.HALF_UP).stripTrailingZeros().toString();
	}
}
