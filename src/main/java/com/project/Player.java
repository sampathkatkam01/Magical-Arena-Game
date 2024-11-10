package com.project;

public class Player {
	private int health;
	private int strength;
	private int attack;

	public Player(int health, int strength, int attack) {
		this.health = health;
		this.strength = strength;
		this.attack = attack;
	}

	public int getHealth() {
		return health;
	}

	public boolean isAlive() {
		return health > 0;
	}

	public void attack(Player defender) {
		int attackRoll = rollDice();
		int defendRoll = rollDice();

		int attackDamage = attack * attackRoll;
		int defendDamage = defender.strength * defendRoll;

		int netDamage = attackDamage - defendDamage;

		if (netDamage > 0) {
			defender.health -= netDamage;
			System.out.println("Player attacks with roll " + attackRoll + " and damage " + attackDamage);
			System.out.println("Defender defends with roll " + defendRoll + " and mitigates " + defendDamage);
			System.out.println("Defender takes " + netDamage + " damage and is now at " + defender.health + " health.");
		} else {
			System.out.println("Defender completely defends the attack.");
		}
	}

	private int rollDice() {
		return (int) (Math.random() * 6) + 1;
	}
}
