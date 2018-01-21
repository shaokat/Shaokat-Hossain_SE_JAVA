package com.shaokat.model;

public enum ProductType {
	RAM("RAM"), Motherboard("Motherboard"),GraphicsCard("Graphics Card");

	private final String typeName;
	
	ProductType(String typeName) {
		this.typeName = typeName;

	}
	public String getTypeName(){
		return this.typeName;
	}

}
