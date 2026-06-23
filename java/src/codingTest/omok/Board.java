package codingTest.omok;

import java.util.Scanner;

public class Board {
	int size;
	String[][] map;

	Board(int size) {
		this.size = size;
		map = new String[size][size];
		for (int row = 0; row < size; row++) {
			for (int col = 0; col < size; col++) {
				map[row][col] = ".";
			}
		}
	}
	
	
	public boolean setStone(Player p, Scanner scanner) {
		System.out.print(p.name + "> ");
		int col = (int)(scanner.next().charAt(0)) - 65;
		int row = scanner.nextInt();
		
		map[row][col] = p.stone;
		
		print();
		
		return win(row, col);
	}
	
	public boolean win(int row, int col) {
		int currentRow = row;
		int currentCol= col;
		
		 // 세로
		int cnt = 1;
		// 뒤로 가면서 검사
		currentRow= row-1;
	    while(currentRow >= 0 ) {
	        if(map[currentRow][col].equals(map[row][col])) {
	            cnt++;
	        } else break;
	        currentRow--;   
	    }
	    // 앞으로 가면서 검사
	    currentRow = row + 1;
	    while(currentRow < size) {
	        if(map[currentRow][col].equals(map[row][col])) {
	            cnt++;
	        } else break;
	        currentRow++;  
	    }
	    
	    if(cnt == 5) {
	    	return true;
	    }
	    	
	    
	    // 가로
	    cnt = 1;
	    // 위로 가면서 검사
	    currentCol = col-1;
	    while(currentCol >= 0 ) { //
	        if(map[row][currentCol].equals(map[row][col])) {
	            cnt++;
	        } else break;
	        currentCol--;
	    }
	    // 밑으로 가면서 검사
	    currentCol = col + 1;
	    while(currentRow < size) {
	        if(map[currentRow][col].equals(map[row][col])) {
	            cnt++;
	        } else break;
	        currentCol++;   
	    }
	    if(cnt == 5) {
	    	return true;
	    }
	     
	    
	    // 대각선1
	    cnt = 1;
	    // 왼쪽 위로
	    currentRow = row -1;
	    currentCol = col -1;
	    while(currentRow >= 0 && currentCol >= 0) {

	        if(map[currentRow][currentCol].equals(map[row][col])) {
	            cnt++;
	        } else break;
	        currentRow--;
	        currentCol--;
	    }
	    // 오른쪽 아래로
	    currentRow = row + 1;
	    currentCol = col + 1;
	    while(currentRow < size && currentCol < size) {
	        if(map[currentRow][currentCol].equals(map[row][col])) {
	            cnt++;
	        } else break;
	        currentRow++;
	        currentCol++;
	    }
	    if(cnt == 5) {
	    	return true;
	    }
	    
	    // 대각선2
	    cnt = 1;
	    // 왼쪽 아래로
	    currentRow = row - 1;
	    currentCol = col + 1;
	    while(currentRow >= 0 && currentCol < size) {

	        if(map[currentRow][currentCol].equals(map[row][col])) {
	            cnt++;
	        } else break;

	        currentRow--;
	        currentCol++;
	    }
	    // 오른쪽 위로
	    currentRow = row + 1;
	    currentCol = col - 1;
	    while(currentRow < size && currentCol >= 0) {
	        if(map[currentRow][currentCol].equals(map[row][col])) {
	            cnt++;
	        } else break;

	        currentRow++;
	        currentCol--;
	    }
	    if(cnt == 5) {
	    	return true;
	    }
	    
	    return false;
	}
	

	public void print() {
		for (int row = 0; row < size; row++) {
			System.out.printf("%2d", row); // 행번호 출력
		
			for (int col = 0; col < size; col++) {
				System.out.print(" " + map[row][col]);
			}
			System.out.println();
		}
		
		System.out.print("   ");
		for (int i = 0; i < size; i++) { // 알파벳 출력
			System.out.print((char)('A' + i) + " ");
		}
		System.out.println();
	}

}
