package codingTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArrayEx {

	public static void main(String[] args) {
		   // 기본 타입(int) 배열 정렬
	       int[] arr = {3,1,8,4,2,5};
	       Arrays.sort(arr); // 정렬
	       System.out.println(Arrays.toString(arr));
	       
	       // 기본 타입(int) 배열을 참조 타입(Integer) 배열로 변경
	       Integer[] arr4 = Arrays.stream(arr).boxed().toArray(Integer[]::new);
	       Arrays.sort(arr4, Comparator.reverseOrder());
	       System.out.println(Arrays.toString(arr4));
	       
	       // 참조 타입(String) 배열 정렬
	       String[] arr2 = {"박길동", "남길동", "최길동", "홍길동", "김길동"};
	       Arrays.sort(arr2);
	       System.out.println(Arrays.toString(arr2));
	       Arrays.sort(arr2, Comparator.reverseOrder());
	       System.out.println(Arrays.toString(arr2));
	       
	       // 참조 타입(int[]) 배열 정렬
	       int[][] arr3 = {{3,2},{3,1},{1,2}};
	       // 배열기준을 커스터마이징
	       Arrays.sort(arr3, new Comparator<int[]>() {

	           @Override
	           public int compare(int[] o1, int[] o2) {
	        	   
	               if (o1[0] == o2[0]) {
	                   return o2[1] - o1[1];
	               }
	               
	               return o1[0] - o2[0];
	           }
	       });
	       
	       for (int[] a : arr3) {
	           System.out.println(Arrays.toString(a));
	       }

	       // List 정렬
	       List<Integer> list = new ArrayList<>();
	       list.add(3); list.add(1); list.add(5); list.add(4);
	       System.out.println(list);
	       Collections.sort(list, Comparator.reverseOrder());
	       System.out.println(list);
	       
	       List<Map<String, Object>> list2 = new ArrayList<>();
	       Map<String, Object> map = new HashMap<>();
	       map.put("name", "홍길동");
	       map.put("score", 90);
	       list2.add(map);
	       map = new HashMap<>();
	       map.put("name", "김길동");
	       map.put("score", 80);
	       list2.add(map);
	       map = new HashMap<>();
	       map.put("name", "최길동");
	       map.put("score", 85);
	       list2.add(map);
	       
	       // 점수(score) 순으로 정렬
	       Collections.sort(list2, new Comparator<Map>() {
	    	   @Override
	    	   public int compare(Map o1, Map o2) {
	    		   return (int)o1.get("score")-(int)o2.get("score");
	    	   }
	       });
	       System.out.println(list2);
	       
		}

}
