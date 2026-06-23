package codingTest;

import java.util.Arrays;

public class MembershipVip {

	public static void main(String[] args) {

//		int[] periods = {8, 23, 24};
//		int[][] payments = {
//		    {100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000},
//		    {100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000},
//		    {350000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000}
//		};
//		int[] estimates = {100000, 100000, 100000};

		int[] periods = {24, 59, 59, 60};
		int[][] payments = {
				{50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000},
				{50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000}, 
				{350000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000},
				{50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000}};
		int[] estimates = {350000, 50000, 40000, 50000};
		

		int[] answer = solution(periods, payments, estimates);		
		System.out.println("정답 출력: " + Arrays.toString(answer));
	}
	
	
	
	
	
	public static int[] solution(int[] periods, int[][] payments, int[] estimates) {
		int[] answer = { 0, 0 };
		// period길이: 고객 수, 내용: 멤버쉽 가입기간
		// payment 행: 고객 수, 열: 최근 12개월, 내용: 납부금애
		// estimate길이: 고객 수, 내용: 다음달 납부 예정 금액
		
		// 멤버쉽 가입 기간 확인
		// 1. 23개월 미만 -> 다음 고객으로 넘어감 
		
		// 2. 23개월 이상 60개월 미만
		// 현재 vip 인지 확인, 다음달도 확인. 기준: 90만원 이상
		
		// 3. 60개월 이상
		// 현재 vip 인지 확인, 다음달도 확인. 기준: 60만원 이상
		
		// 멤버쉽 가입 기간 확인
		for (int i = 0; i < periods.length; i++) {
			// 1. 23개월 미만 -> 다음 고객으로 넘어감 ----------------
			if (periods[i] < 23) continue; 
			
			// 2. 23개월 이상 59개월 미만 -------------------------
			else if (23 <= periods[i] && periods[i] < 59) {
				int sum = 0;
				for (int j = 0; j < 12; j++) {
					sum += payments[i][j];
				}
				int nextSum = sum - payments[i][0] + estimates[i]; // 다음달
//				System.out.println(i);
//				System.out.println(periods[i]);
//				System.out.println(sum);
//				System.out.println(nextSum);
				
				// 현재 vip 아님, 다음달 vip
				if ((periods[i] == 23 || sum < 900000) && nextSum >= 900000) {
					answer[0]++;
				}
				// 현재 vip 중 다음달 vip 아니게 되는 사람
				else if (sum >= 900000 && nextSum < 900000) {
					answer[1]++;
				}
			}
			
			// 3. 59개월 이상 ---------------------------------------
			else {
				int sum = 0;
				for (int j = 0; j < 12; j++) {
					sum += payments[i][j];
				}
				
				int nextSum = sum - payments[i][0] + estimates[i]; // 다음달
			
//				System.out.println(i);
//				System.out.println(periods[i]);
//				System.out.println(sum);
//				System.out.println(nextSum);
				
				if ((periods[i] == 59 || sum < 600000) && nextSum >= 600000) { // 현재 vip 아님, 다음달 vip
					answer[0]++;
				}
				else if (sum >= 600000 && nextSum < 600000) { // 현재 vip 중 다음달 vip 아니게 되는 사람
					answer[1]++;
				}
			}
		}
		
		return answer;
	}
	

}
