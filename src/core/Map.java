package core;

public class Map {

	public int[] map;

	public Map(int width, int height) {
		this.width = width;
		this.height = height;
		map = new int[500 * 500];
	}

	public int width, height;

	public int get(int x, int y) {
		int tempX = x > width - 1 ? width - 1 : x < 0 ? 0 : x;
		int tempY = y > height - 1 ? height - 1 : y < 0 ? 0 : y;
		return map[tempX + tempY * width];
	}

	public void set(int id, int x, int y) {
		int tempX = x > width - 1 ? width - 1 : x < 0 ? 0 : x;
		int tempY = y > (height - 1) ? (height - 1) : ((y < 0) ? 0 : y);
		System.out.println(tempX+" "+tempY);
		map[tempX + tempY * width] = id;
	}

	public Map copy() {
		Map temp = new Map(width, height);
		temp.map = map.clone();
		return temp;
	}

}
