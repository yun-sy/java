package codingTest.amusementPark;

import java.util.Arrays;
import java.util.Comparator;


public class AmusementPark {

	public static void main(String[] args) {
		
		Solution s = new Solution();
		
		int tikets = 20000;
		int[][] requests = {{3,1}, {2,5}, {2,10}, {3,8}, {1,2}};
		
		int result = s.solution(tikets, requests);
		System.out.println(result);

	}

}


class Solution {
	public int solution (int tickets, int[][] requests) {
		int soldTickets = 0;

	       Arrays.sort(requests, new Comparator<int[]>() {

	           @Override
	           public int compare(int[] o1, int[] o2) {
	        	   
	               if (o1[0] == o2[0]) {
	                   return o2[1] - o1[1];
	               }
	               
	               return o1[0] - o2[0];
	           }
	       });
	       
	       for(int i = 0; i < requests.length; i++) {
	    	   if(tickets < requests[i][1]) continue; // 남은 티켓보다 많이 구매하려는 경우 판매 X
	    	   else {
	    		   tickets -= requests[i][1];
	    		   soldTickets += requests[i][1];
	    	   }
	       }
		return soldTickets;
	}
}

