package pkg.input;

public class Controller {

	public double x, z, rotation, xa, za, rotationa, yLook;
	public double y = 1;
	
	public void tick(
		boolean forward,
		boolean back,
		boolean left,
		boolean right,
		boolean running,
		boolean turnLeft,
		boolean turnRight,
		boolean lookUp,
		boolean lookDown,
		boolean spacedown,
		boolean crouched)
	{		
		double rotationSpeed = 0.025;
		double yLookSpeed = 0.025;
		double walkSpeed = 1;
		double xMove = 0;
		double zMove = 0;
		boolean jumping = false;
		boolean falling = false;
		boolean jumpreset = true;
		
		if(forward) {
			zMove++;
		}
		
		if(back) {
			zMove--;
		}
		
		if(left) {
			xMove--;
		}
		
		if(right) {
			xMove++;
		}
		
		if(forward && running) {
			walkSpeed *= 2;
		}
		
		if(turnLeft) {
			rotationa -= rotationSpeed;
		}
		
		if(turnRight) {
			rotationa += rotationSpeed;
		}
		if(lookUp) {
			yLook -= yLookSpeed;
		}
		
		if(lookDown) {
			yLook += yLookSpeed;
		}
		if(spacedown && jumpreset && !jumping) {
			jumping = true;
		}
		if(jumping) {
			y +=.05;
			if(y>=2) {
				jumpreset = false;
				falling = true;
				jumping = false;
			}
		}
		if(!jumping && y > 1) {
			falling = true;
		}
		if(!jumpreset) {
			y-=.1;
		}
		if(falling) {
			y -= .1;
		}
		if(crouched) {
			running = false;
			walkSpeed = walkSpeed/2;
			y = .5;
		}
		if(y == 1) {
			jumpreset = true;
		}
		if(!crouched && !falling && !jumping) {
			y = 1;
		}
		
		if(y < 0) {
			y = 1;
		}
		
		xa += (xMove * Math.cos(rotation) + zMove * Math.sin(rotation)) * walkSpeed;
		za += (zMove * Math.cos(rotation) - xMove * Math.sin(rotation)) * walkSpeed;
		
		x+= xa;
		z+= za;
		xa*= 0.1;
		za*=0.1;
		rotation += rotationa;
		rotationa *= 0.5;
		
		
		
	}
}
