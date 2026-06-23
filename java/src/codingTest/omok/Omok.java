package codingTest.omok;

import java.util.Scanner;

public class Omok {

	public static void main(String[] args) {
		Player user = new Player("사용자", "O");
		Player computer = new Player("컴퓨터", "X");
		Board board = new Board(19);
		play(board, user, computer);
	}
	
	

	private static void play(Board board, Player user, Player computer) {

		Scanner scanner = new Scanner(System.in);
	
		board.print();
		
		while(true) {
			if(board.setStone(user, scanner)) {
				System.out.println(user.name + " 승!!");
				break;
			}
					
			if(board.setStone(computer, scanner)) {
				System.out.println(computer.name + " 승!!");
				break;
			}

		}
		
		scanner.close();
		

	}

}
