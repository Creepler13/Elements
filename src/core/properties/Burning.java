package core.properties;

import core.Element;
import core.Map;
import core.Registry;

public class Burning extends ElementProperty {

	@Override
	public void action(int x, int y, Map map, Registry reg) {
		int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
		for (int[] ks : dirs) {

			Element e = reg.getElement(map.get(x + ks[0], y + ks[1]));
			if (e.hasProperty("flameable")) {
				map.set(4, x + ks[0], y + ks[1]);
			}
		}

		map.set(0, x, y);

	}

	@Override
	public String getName() {
		return "burning";
	}

}
