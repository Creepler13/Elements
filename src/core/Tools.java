package core;

public class Tools {

	public static void fillRect(Map map, Element e, int x, int y, int width, int height) {
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				map.set(e.getID(), x + i, y + j);
			}
		}
	}

}
