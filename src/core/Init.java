package core;

import java.awt.Color;

import core.properties.Burning;
import core.properties.ElementPropertyList;
import core.properties.Flameable;
import core.properties.Fluid;
import core.properties.Gas;

public class Init {

	public static void elementInit(Registry reg) {
		reg.registerElement(0, "air", Color.WHITE, new ElementPropertyList(new Gas(5)));
		reg.registerElement(1, "helium", Color.YELLOW, new ElementPropertyList(new Gas(2)));
		reg.registerElement(2, "water", Color.BLUE, new ElementPropertyList(new Fluid(5)));
		reg.registerElement(3, "wood", Color.GRAY, new ElementPropertyList(new Flameable()));
		reg.registerElement(4, "fire", Color.RED, new ElementPropertyList(new Burning()));
		reg.registerElement(5, "oil", Color.ORANGE, new ElementPropertyList(new Flameable(), new Fluid(4)));
	}

}
