package codingTest.auction;

import java.util.Arrays;
import java.util.Comparator;

public class Auction {

	public static void main(String[] args) {

		int n = 4;
		int[] amounts = {1000000, 490000, 700000, 290000};
		
		int[] result = solution(n, amounts);
		System.out.println(Arrays.toString(result));
		
	}
	
	
	
	
	public static int[] solution(int n, int[] amounts) {
		int[] answer = {0};
		
	       // 기본 타입(int) 배열을 참조 타입(Integer) 배열로 변경
	       Integer[] arr = Arrays.stream(amounts).boxed().toArray(Integer[]::new);
	       Arrays.sort(arr, Comparator.reverseOrder());
	       System.out.println(Arrays.toString(arr));
		
//		Integer[]new
		
//		Arrays.sort(amounts, Comparator.reverseOrder());
		
		return answer;
	}
	

}
