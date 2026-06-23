package codingTest;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Cal {

	public static void main(String[] args) {
//		*부동소수점 오차*
//		1. 상품가격 : 1000.10원, 수수료 : 0.20원 합계는?

		double price = 1000.10;
		double fee = 0.20;
		System.out.println(price + fee);
		
//		2. 1천만원 대출, 연이율 3.5% -> 대출 이자는?
		double loan = 10000000;
		double ratePerYear = 0.035;
		System.out.println(loan * ratePerYear);
		
		// 자바에서 제공하는 BigDecimal이 있음.
		BigDecimal a = new BigDecimal(String.valueOf(fee)); // 근데 이것도 오차가 들어간 상태로 대입되는거라 그냥 애초에 문자열로 넣어주는 게 좋음!!
		//System.out.println(a);
		BigDecimal b = new BigDecimal(String.valueOf(price));
		//System.out.println(b);
		
		BigDecimal c = b.add(a);
		System.out.println(c);
		
		System.out.println(c.setScale(0,RoundingMode.HALF_UP));
		
		BigDecimal d = new BigDecimal(String.valueOf(loan));
		BigDecimal e = new BigDecimal(String.valueOf(ratePerYear));
		BigDecimal f = e.multiply(d);
		System.out.println(f);
	}

}