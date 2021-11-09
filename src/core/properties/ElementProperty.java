package core.properties;

import core.Element;
import core.Map;
import core.Registry;
import core.interfaces.IElement;

public abstract class ElementProperty implements IElement {

	public ElementProperty() {
	}

	public abstract void action(int x, int y, Map map, Registry reg);

	public abstract String getName();

	@Override
	public String toString() {
		return getName();
	}

	public boolean equals(IElement e) {
		if (e instanceof Element) {
			for (ElementProperty property : ((Element) e).getProperties().elementProperties) {
				if (property.getName() == getName())
					return true;
			}
			return false;
		} else if (e instanceof ElementProperty) {
			return ((ElementProperty) e).getName() == getName();
		}
		return false;
	}

}
