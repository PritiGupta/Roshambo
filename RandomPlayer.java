package com;

import java.util.Random;

public class RandomPlayer extends Player {

	/*
	 * (non-Javadoc)
	 * @see com.GC.Lab12.Player#generateRoshambo()
	 * Generates a random play
	 */
	@Override
	public Roshambo generateRoshambo() {
		Random r = new Random();
		int choice = r.nextInt(3);			
		return Roshambo.values()[choice];
	}

}
