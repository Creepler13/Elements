package core.properties;

import core.Map;
import core.Registry;

public abstract class ElementProperty {

	public ElementProperty() {
	}

	public abstract void action(int x, int y, Map map, Registry reg);

	public abstract String getName();
	
	@Override
	public String toString() {
		return getName();
	}
}
