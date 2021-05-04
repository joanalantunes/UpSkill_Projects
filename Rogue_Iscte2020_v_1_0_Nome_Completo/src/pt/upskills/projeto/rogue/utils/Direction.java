package pt.upskills.projeto.rogue.utils;

/**
 * @author POO2016
 * 
 * Cardinal directions
 *
 */
public enum Direction {
	LEFT, UP, RIGHT, DOWN, RIGHT_UP, RIGHT_DOWN, LEFT_DOWN, LEFT_UP;

	public Vector2D asVector() {
		if (this == Direction.UP) {
			return new Vector2D(0, -1);
		}
		if (this == Direction.DOWN) {
			return new Vector2D(0, 1);
		}
		if (this == Direction.LEFT) {
			return new Vector2D(-1, 0);
		}
		if (this == Direction.RIGHT) {
			return new Vector2D(1, 0);
		}
		if(this == Direction.RIGHT_UP) {
			return new Vector2D(1,-1);
		}
		if(this == Direction.RIGHT_DOWN) {
			return new Vector2D(1,1);
		}
		if(this == Direction.LEFT_DOWN) {
			return new Vector2D(-1,1);
		}
		if(this == Direction.LEFT_UP) {
			return new Vector2D(-1,-1);
		}
		return null;
	}

}


