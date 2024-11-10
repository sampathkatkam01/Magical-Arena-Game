package com.project;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

	@Test
	void testPlayerInitialization() {
		Player player = new Player(100, 10, 5);
		assertEquals(100, player.getHealth());
		assertTrue(player.isAlive());
	}

	@Test
	void testPlayerAttack() {
		Player attacker = new Player(100, 10, 5);
		Player defender = new Player(100, 5, 5);

		attacker.attack(defender);

		assertFalse(defender.getHealth() < 100);
	}

	@Test
	void testPlayerDeath() {
		Player player = new Player(0, 10, 5);
		assertFalse(player.isAlive());
	}

	@Test
	void testPlayerSurvival() {
		Player player = new Player(50, 10, 5);
		assertTrue(player.isAlive());
	}
}
