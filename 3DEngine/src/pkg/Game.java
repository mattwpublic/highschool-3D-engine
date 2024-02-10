package pkg;

import java.awt.event.KeyEvent;

import pkg.input.Controller;

public class Game {
	public int time;
	public Controller controls;
	
	public Game() {
		controls = new Controller();
	}
	
	public void tick(boolean[] key) {
		time++;
		boolean forward = key[KeyEvent.VK_W];
		boolean back = key[KeyEvent.VK_S];
		boolean left = key[KeyEvent.VK_A];
		boolean right = key[KeyEvent.VK_D];
		boolean running = key[KeyEvent.VK_SHIFT];
		boolean turnLeft = key[KeyEvent.VK_LEFT];
		boolean turnRight = key[KeyEvent.VK_RIGHT];
		boolean lookUp = key[KeyEvent.VK_UP];
		boolean lookDown = key[KeyEvent.VK_DOWN];
		boolean spacedown = key[KeyEvent.VK_SPACE];
		boolean crouched = key[KeyEvent.VK_CONTROL];
		
		controls.tick(forward, back, left, right, running, turnLeft, turnRight, lookUp, lookDown, spacedown, crouched);
	}
}
