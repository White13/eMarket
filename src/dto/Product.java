package dto;

import java.util.ArrayList;
import java.util.List;

public class Product {
	
	private int id;
	private String description;
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	private String name;
	private Double sellingPrice;
	private List<Component> components = new ArrayList<Component>();
	
		
	public Product(int id, String name, double sellingPrice, String description) {
		this.id = id;
		this.name = name;
		this.sellingPrice = sellingPrice;
		this.description = description;
		
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getSellingPrice() {
		return sellingPrice;
	}
	public void setSellingPrice(Double sellingPrice) {
		this.sellingPrice = sellingPrice;
	}
	public List<Component> getComponents() {
		return components;
	}
	public void setComponents(List<Component> components) {
		this.components = components;
	}
	
	
}
