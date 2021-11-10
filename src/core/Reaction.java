package core;

import java.util.Random;

import core.interfaces.IElement;

public class Reaction {

	public Reaction(IElement e1, IElement e2, Element e1out, Element e2out, double probability) {
		this.e1 = e1;
		this.e2 = e2;
		this.e1out = e1out;
		this.e2out = e2out;
		this.probability = probability;
	}

	public Reaction(IElement e1, IElement e2, CustomReaction customReaction, double probability) {
		this.e1 = e1;
		this.e2 = e2;
		this.react = customReaction;
		this.probability = probability;
	}

	double probability;
	IElement e1;
	IElement e2;
	Element e1out;
	Element e2out;
	CustomReaction react;

	int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

	Random rand = new Random();

	public void action(int x, int y, Map map, Registry reg) {

		for (int[] ks : dirs) {

			int newX = x + ks[0];
			int newY = y + ks[1];

			Element elem = reg.getElement(map.get(x, y));
			Element elem2 = reg.getElement(map.get(newX, newY));

			if (elem.equals(e1) && elem2.equals(e2)) {
				if (rand.nextDouble() >= probability)
					return;
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
