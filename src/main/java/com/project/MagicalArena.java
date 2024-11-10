package com.project;

public class MagicalArena {
	private Player player1;
	private Player player2;

	public MagicalArena(Player player1, Player player2) {
		this.player1 = player1;
		this.player2 = player2;
	}

	public void startBattle() {

		final String GREEN = "\u001B[32m";

		Player currentAttacker = player1.getHealth() < player2.getHealth() ? player1 : player2;
		Player currentDefender = currentAttacker == player1 ? player2 : player1;

		while (player1.isAlive() && player2.isAlive()) {
			currentAttacker.attack(currentDefender);

			Player temp = currentAttacker;
			currentAttacker = currentDefender;
			currentDefender = temp;

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		if (!player1.isAlive()) {
			System.out.println(GREEN + "Player 1 has been defeated. Player 2 wins!");
		} else {
			System.out.println(GREEN + "Player 2 has been defeated. Player 1 wins!");
		}
	}

	public static void main(String[] args) {
		Player player1 = new Player(50, 5, 10);
		Player player2 = new Player(100, 10, 5);

		MagicalArena arena = new MagicalArena(player1, player2);
		arena.startBattle();
	}
}
