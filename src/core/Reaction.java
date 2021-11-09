package core;

import core.interfaces.IElement;

public class Reaction {

	public Reaction(IElement e1, IElement e2, Element e1out, Element e2out) {
		this.e1 = e1;
		this.e2 = e2;
		this.e1out = e1out;
		this.e2out = e2out;
	}

	public Reaction(IElement e1, IElement e2, CustomReaction customReaction) {
		this.e1 = e1;
		this.e2 = e2;
		this.react = customReaction;
	}

	IElement e1;
	IElement e2;
	Element e1out;
	Element e2out;
	CustomReaction react;

	int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

	public void action(int x, int y, Map map, Registry reg) {

		for (int[] ks : dirs) {

			int newX = x + ks[0];
			int newY = y + ks[1];

			Element elem = reg.getElement(map.get(x, y));
			Element elem2 = reg.getElement(map.get(newX, newY));

			if (elem.equals(e1) && elem2.equals(e2)) {
				if (react != null)
					react.action(x, y, newX, newY, map, reg);
				else {
					map.set(e1out.getID(), x, y);
					map.set(e2out.getID(), newX, newY);
				}
			}

		}

	}

}
