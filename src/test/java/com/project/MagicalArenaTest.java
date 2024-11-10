package com.project;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MagicalArenaTest {

	@Test
	void testStartBattle() {
		Player player1 = new Player(50, 5, 10);
		Player player2 = new Player(100, 10, 5);

		MagicalArena arena = new MagicalArena(player1, player2);

		arena.startBattle();

		assertTrue(!player1.isAlive() || !player2.isAlive());
	}
}
