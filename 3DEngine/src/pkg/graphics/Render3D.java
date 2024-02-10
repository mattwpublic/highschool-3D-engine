package pkg.graphics;

import pkg.Game;

public class Render3D extends Render {

	public Render3D(int width, int height) {
		super(width, height);
	}
		
	public void floor(Game game) {
		
		double fov = 1;
		double floorHeight = 10 * game.controls.y;
		double ceilingHeight = 50.0;
		double forward = game.controls.z;
		double right = game.controls.x;
		double lookY = game.controls.yLook;
		double rotation = game.controls.rotation;
		double cosine = Math.cos(rotation);
		double sine = Math.sin(rotation);
		
		
		
		for(int y = 0; y < height; y++) {
			double ceiling = (y + -height / 2.0) / height + lookY;
			
			double z = floorHeight / ceiling;
			
			if(ceiling < 0) {
				z = ceilingHeight / -ceiling;
			}
			
			for(int x = 0; x < width; x++) {
				double depth = (x - width / 2.0) / height;
				depth *= z;
				double xx = (depth * cosine + z * sine) * fov;
				double yy = (z * cosine - depth * sine) * fov;
				int xPix = (int)(xx + right);
				int yPix = (int)(yy + forward);
				if(ceiling < 0) {
					pixels[x+y*width] = 0;
				}
				else
				pixels[x+y*width] = ((xPix & 15) * 16) | ((yPix & 15) * 16) << 8;
			}
		}
	}
}
