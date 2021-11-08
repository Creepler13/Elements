package core.properties;

import java.util.ArrayList;

public class ElementPropertyList {

	public ArrayList<ElementProperty> elementProperties = new ArrayList<>();

	public ElementPropertyList(ElementProperty... elementProperties) {
		for (ElementProperty elementProperty : elementProperties) {
			this.elementProperties.add(elementProperty);
		}
	}

	public void addType(ElementProperty elementProperty) {
		this.elementProperties.add(elementProperty);
	}

	public void removeType(ElementProperty elementProperty) {
		this.elementProperties.remove(elementProperty);
	}

	public boolean isEmpty() {
		return elementProperties.size() == 0;
	}

	@Override
	public String toString() {
		String s = "[";
		for (ElementProperty elementProperty : elementProperties) {
			s=s+" "+elementProperty;
		}
		return s+"]";
	}
	
}
