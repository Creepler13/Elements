package core;

public class BooleanMap {

	public boolean[] map;

	public BooleanMap() {
		map = new boolean[500 * 500];
	}

	public boolean get(int x, int y) {
		x = x > 499 ? 499 : x < 0 ? 0 : x;
		y = y > 499 ? 499 : y < 0 ? 0 : y;
		return map[x + y * 500];
	}

	public void set(boolean id, int x, int y) {
		x = x > 499 ? 499 : x < 0 ? 0 : x;
		y = y > 499 ? 499 : y < 0 ? 0 : y;
		map[x + y * 500] = id;
	}

	public BooleanMap copy() {
		BooleanMap temp = new BooleanMap();
		temp.map = map.clone();
		return temp;
	}

}
