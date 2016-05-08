package gameplay;

public abstract class TickController {
	public static void tick() {
		for (Sprite s : GameController.currentLevel.sprites) {
			boolean intersects = false;
			if (s.vx != 0) {
				s.rect.x += s.vx;
				intersects = protectX(s, s.vx < 0);
			}
			if (s.vy != 0) {
				s.rect.y += s.vy;
				if (protectY(s, s.vy < 0)) intersects = true;
			}
			if (intersects) {
				s.intersected(s);
			}
			s.tick();
		}
	}
	
	public static boolean protectX (Sprite pro, boolean left) {
		for (Sprite s : GameController.currentLevel.sprites) {
            if (s != pro) {
        		if (!s.passable) {
	            	if (s.intersects(pro)) {
		            	if (left) {
		            		pro.rect.x = s.rect.x+s.rect.width;
		            	}
		            	if (!left) {
		            		pro.rect.x = s.rect.x-s.rect.width;
		            	}
		            	return true;
	            	}
        		}
            }
        }
		return false;
	}
	
	public static boolean protectY(Sprite pro, boolean up) {
		for (Sprite s : GameController.currentLevel.sprites) {
            if (s != pro) {
        		if (!s.passable) {
	            	if (s.intersects(pro)) {
	                	if (up) {
	                		pro.rect.y = s.rect.y+s.rect.height;
	                	}
	                	if (!up) {
	                		pro.rect.y = s.rect.y-s.rect.height;
	                	}
	                	return true;
	            	}
        		}
            }
        }
		return false;
	}
}
