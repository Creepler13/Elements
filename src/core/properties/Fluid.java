package core.properties;

import core.Element;
import core.Map;
import core.Registry;

public class Fluid extends ElementProperty {

	private int density;

	public Fluid(int density) {
		this.density = density;
	}

	int[][] dirs = { { 0, 1 }, { -1, 1 }, { 1, 1 }, { -1, 0 }, { 1, 0 } };

	@Override
	public void action(int x, int y, Map map, Registry reg) {
		Element me = reg.getElement(map.get(x, y));
		for (int[] ks : dirs) {

			int newX = x + ks[0];
			int newY = y + ks[1];
			Element e = reg.getElement(map.get(newX, newY));
			if (e.hasProperty("gas")) {
				if (ks == dirs[0])
					System.out.println("Fluid"+newX + " " + newY);
				map.set(me.getID(), newX, newY);
				map.set(e.getID(), x, y);
				return;
			}
			if (e.hasProperty("fluid")) {
				if (density < ((Fluid) e.getProperty("fluid")).density) {
					map.set(me.getID(), newX, newY);
					map.set(e.getID(), x, y);
					return;
				}
			}
		}

	}

	@Override
	public String getName() {
		return "fluid";
	}

}
