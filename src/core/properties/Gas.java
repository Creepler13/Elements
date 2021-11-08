package core.properties;

import core.Element;
import core.Map;
import core.Registry;

public class Gas extends ElementProperty {

	private int density;

	public Gas(int density) {
		this.density = density;
	}

	int[][] dirs = { { 0, -1 }, { -1, -1 }, { 1, -1 }, { -1, 0 }, { 1, 0 } };

	@Override
	public void action(int x, int y, Map map, Registry reg) {

		for (int[] ks : dirs) {

			Element e = reg.getElement(map.get(x + ks[0], y + ks[1]));
			if (e.hasProperty("fluid")) {
				map.set(map.get(x, y), x + ks[0], y + ks[1]);
				map.set(e.getID(), x, y);
				return;
			}
			if (e.hasProperty("gas")) {
				if (density < ((Gas) e.getProperty("gas")).density) {
					map.set(map.get(x, y), x + ks[0], y + ks[1]);
					map.set(e.getID(), x, y);
					return;
				}
			}
		}

	}

	@Override
	public String getName() {
		return "gas";
	}

}
