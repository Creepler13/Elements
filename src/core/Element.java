package core;

import java.awt.Color;

import core.interfaces.IElement;
import core.properties.ElementProperty;
import core.properties.ElementPropertyList;

public class Element implements IElement {

	private int id;
	private String name;
	private Color color;
	private ElementPropertyList properties;

	public Element(int id, String name, Color color, ElementPropertyList properties) {
		this.id = id;
		this.name = name;
		this.color = color;
		this.properties = properties;
	}

	public String getName() {
		return name;
	};

	public int getID() {
		return id;
	};

	public Color getColor() {
		return color;
	};

	public void setProperties(ElementPropertyList propertyList) {
		this.properties = propertyList;
	}

	public ElementPropertyList getProperties() {
		return properties;
	}

	public boolean hasProperty(String name) {
		for (ElementProperty property : getProperties().elementProperties) {
			if (property.getName() == name)
				return true;
		}
		return false;
	}

	public ElementProperty getProperty(String name) {
		for (ElementProperty property : getProperties().elementProperties) {
			if (property.getName() == name)
				return property;
		}
		return null;
	}

	@Override
	public String toString() {
		return getName() + "[" + getID() + "]," + getProperties();
	}

	public boolean equals(IElement e) {
		if (e instanceof Element) {
			return ((Element) e).getID() == getID();
		} else if (e instanceof ElementProperty) {
			return getProperties().contains((ElementProperty) e);
		}
		return false;
	}

	public boolean hasProperty(ElementProperty e1) {
		return getProperties().contains(e1);
	}

}
