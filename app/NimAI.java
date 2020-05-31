package app;

import java.util.*;

public class NimAI {
	
	private int pile0, pile1, pile2, pile3;
	private String pile0Bits, pile1Bits, pile2Bits, pile3Bits;
	private int bit0, bit1, bit2;
	private List<Integer> piles;
	private int difficulity;
	

	public NimAI(int pile0, int pile1, int pile2, int pile3, int difficulity) {
		super();
		this.pile0 = pile0;
		this.pile1 = pile1;
		this.pile2 = pile2;
		this.pile3 = pile3;
		this.difficulity = difficulity;
		pile0Bits = Integer.toBinaryString(pile0);
		pile1Bits = Integer.toBinaryString(pile1);
		pile2Bits = Integer.toBinaryString(pile2);
		pile3Bits = Integer.toBinaryString(pile3);
		piles  = Arrays.asList(pile0, pile1, pile2, pile3);
	}
	
	private String randomOutput() {
//		System.out.println("Nå erre random sjø");
		double random;
		int randomNum;
		while(true){
//			System.out.println(piles);
			random = Math.random() * 4;
//			System.out.println(random);
			randomNum = (int) (random);
//			System.out.println(randomNum);
//			System.out.println(piles.get(randomNum));
			if(piles.get(randomNum) != 0) {
//				System.out.println(randomNum + "random");
				break;
			}
		}
		double random2 = Math.random()*piles.get(randomNum);
		int randomNum2 = (int) random2 + 1;
//		System.out.println(randomNum2 + "" + randomNum);
		return randomNum2 + "" + Integer.toString(randomNum);
	}
	
	private boolean returnRandom() {
		if (difficulity == 4)
			return false;
		else if (difficulity == 3)
			return Math.random() > 0.9;
		else if (difficulity == 2) 
			return Math.random() > 0.7;
		else
			return Math.random() >= 0.5;
	}




	private void bitFiller() {
		bit0 = 0;
		bit1 = 0;
		bit2 = 0;
		pile0Bits = stringLength(pile0Bits);
		pile1Bits = stringLength(pile1Bits);
		pile2Bits = stringLength(pile2Bits);
		pile3Bits = stringLength(pile3Bits);
		if(pile0Bits.substring(0,1).equals("1")) {
			bit2 += 1;
		}
		if(pile1Bits.substring(0,1).equals("1")) {
			bit2 += 1;
		}
		if(pile2Bits.substring(0,1).equals("1")) {
			bit2 += 1;
		}
		if(pile3Bits.substring(0,1).equals("1")) {
			bit2 += 1;
		}
		if(pile0Bits.substring(1,2).equals("1")) {
			bit1 += 1;
		}
		if(pile1Bits.substring(1,2).equals("1")) {
			bit1 += 1;
		}
		if(pile2Bits.substring(1,2).equals("1")) {
			bit1 += 1;
		}
		if(pile3Bits.substring(1,2).equals("1")) {
			bit1 += 1;
		}
		if(pile0Bits.substring(2,3).equals("1")) {
			bit0 += 1;
		}
		if(pile1Bits.substring(2,3).equals("1")) {
			bit0 += 1;
		}
		if(pile2Bits.substring(2,3).equals("1")) {
			bit0 += 1;
		}
		if(pile3Bits.substring(2,3).equals("1")) {
			bit0 += 1;
		}
		
	}
	
	private String stringLength(String str) {
		int length = str.length() ;
		if (length == 1) {
			str = "00" + str;
		}
		if (length == 2) {
			str = "0" + str;
		}
		return str;
	}
	
	public String removeinator() {
		if (returnRandom())
			return randomOutput();
		if (pile0 > 0) {
			for (int i = 0; i <= pile0; i++) {
				removePieces(i, 0);
				if(rightMove() && i != 0) {
//					System.out.println("fra rad 1");
					return Integer.toString(i) + "0";
				} else {
					removePieces(-i, 0);
				}
			}
		}
		if(pile1 > 0) {
			for (int i = 0; i <= pile1; i++) {
				removePieces(i, 1);
				if(rightMove()&& i != 0) {
//					System.out.println("fra rad 2");
					return Integer.toString(i) + "1";
				}
				else {
					removePieces(-i, 1);
				}
			}
		}
		int stop = pile2;
		if (pile2 > 0) {
			for (int i = 0; i <= stop; i++) {
				removePieces(i, 2);
				if(rightMove()&& i != 0) {
//					System.out.println("fra rad 3");
					return Integer.toString(i) + "2";
				}
				removePieces(-i, 2);
			}
		}
		if(pile3 > 0) {
			for (int i = 0; i <= pile3; i++) {
				removePieces(i, 3);
				if(rightMove()&& i != 0) {
//					System.out.println("fra rad 4");
					return Integer.toString(i) + "3";
				}
				else {
					removePieces(-i, 3);
				}
			}
		}
//		System.out.println("Ikke random men random læll");
		return randomOutput();
	}
	
	private void removePieces(int number, int targetPile) {
		if (true) {
			if (targetPile == 0) {
				pile0 -= number;
			}
			if (targetPile == 1) {
				pile1 -= number;
			}
			if (targetPile == 2) {
				pile2 -= number;
			}
			if (targetPile == 3) {
				pile3 -= number;
			}
		} else {
			throw new IllegalArgumentException("Invalid Move");
		}
	}
	
	private boolean rightMove() {
		pile0Bits = Integer.toBinaryString(pile0);
		pile1Bits = Integer.toBinaryString(pile1);
		pile2Bits = Integer.toBinaryString(pile2);
		pile3Bits = Integer.toBinaryString(pile3);
		bitFiller();
		
		if (bit0 % 2 == 0 && bit1 % 2 == 0 && bit2 % 2 == 0) {
			return true;
		}
		return false;
	}
	
	

}
