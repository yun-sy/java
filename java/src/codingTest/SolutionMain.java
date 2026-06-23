package codingTest;

public class SolutionMain {

	public static void main(String[] args) {
		Solution s = new Solution();
		int result1 = s.solution(5000, new int[] {10000, -13000, -4000, -2000, 6500, -20000});
		int result2 = s.solution(34151, new int[] {-34152, -40000, -50000});
		System.out.println(result1);
		System.out.println(result2);
		
		

	}

}

class Solution {
	public int solution (int m, int[] ledger) {
		int account = 0;

		for (int i = 0; i < ledger.length; i++) {
			if ((account + ledger[i]) >= -m) {
				account += ledger[i];
				
			} else {
				continue;
				
			}
		}

		return account;
	}
}