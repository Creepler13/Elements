package core.properties;

import core.Element;
import core.Map;
import core.Registry;

public class Powder extends ElementProperty {

	int[][] dirs = { { 0, 1 }, { -1, 1 }, { 1, 1 } };

	@Override
	public void action(int x, int y, Map map, Registry reg) {
		Element me = reg.getElement(map.get(x, y));

		Element below = reg.getElement(map.get(x, y + 1));
		if (below.hasProperty("gas") || below.hasProperty("fluid")) {
			map.set(me.getID(), x, y + 1);
			map.set(below.getID(), x, y);
			return;
		}
		Element e1 = reg.getElement(map.get(x + 1, y + 1));
		Element e2 = reg.getElement(map.get(x - 1, y + 1));
		if (e1.hasProperty("gas") || e1.hasProperty("fluid")) {
			if (below.hasProperty("solid") || below.hasProperty("powder")) {
				map.set(me.getID(), x + 1, y + 1);
				map.set(e1.getID(), x, y);
				return;
			}
		}
		if (e2.hasProperty("gas") || e2.hasProperty("fluid")) {
			if (below.hasProperty("solid") || below.hasProperty("powder")) {
				map.set(me.getID(), x - 1, y + 1);
				map.set(e2.getID(), x, y);
				return;
			}
		}

	}

	@Override
	public String getName() {
		return "powder";
	}

}
