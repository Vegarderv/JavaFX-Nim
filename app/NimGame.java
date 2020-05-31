package app;

public class NimGame {
private int pile0, pile1, pile2, pile3, difficulity;
	
	
	public NimGame(int pile0, int pile1, int pile2, int pile3, int difficulity) {
	super();
	this.pile0 = pile0;
	this.pile1 = pile1;
	this.pile2 = pile2;
	this.pile3 = pile3;
	this.difficulity = difficulity;
}

	public boolean isValidMove(int number, int targetPile) {
		if (targetPile == 0 & !isGameOver()) {
			if (number <= pile0 & number >= 1) {
				return true;
			}
		}
		if (targetPile == 1 & !isGameOver()) {
			if (number <= pile1 & number >= 1) {
				return true;
			}
		}
		if (targetPile == 2 & !isGameOver()) {
			if (number <= pile2 & number >= 1) {
				return true;
			}
		}
		if (targetPile == 3 & !isGameOver()) {
			if (number <= pile3 & number >= 1) {
				return true;
			}
		}
		return false;
	}
		
	public void removePieces(int number, int targetPile) {
		if (isGameOver()) {
			throw new IllegalStateException("Game is over buddy");
		}
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

	public boolean isGameOver(){
		if(pile0 == 0 & pile1 == 0 & pile2 == 0 & pile3 == 0) {
			return true;
		}
		return false;
	}

	public int getPile(int targetPile) {
		if (targetPile == 0) {
			return pile0;
		}
		if (targetPile == 1) {
			return pile1;
		}
		if (targetPile == 2) {
			return pile2;
		}
		if (targetPile == 3) {
			return pile3;
		} else {
			throw new IllegalArgumentException("Not a target pile");
		}
	}
	
	public String toString() {
		return "pile0: " + pile0 + "pile1: " + pile1 + "pile2: " + pile2 + "pile3: " + pile3;
	}
	

	public String makeMove() {
		NimAI AI = new NimAI(pile0, pile1, pile2, pile3, difficulity);
		String str = AI.removeinator();
		int rowNum = Integer.parseInt(str.substring(1,2));
		int num = Integer.parseInt(str.substring(0,1));
		removePieces(num, rowNum);
//		System.out.println(pile0 + "|" + pile1 + "|" + pile2 + "|" + pile3);
		return str;
		
	}
	

}
