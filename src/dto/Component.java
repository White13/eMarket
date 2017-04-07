package dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Component {
	

	private int id;
	private String name;
	private String supplier;
	List<Product>produits = new ArrayList<Product>();
		

	public Component(int id, String name, String supplier) {
		this.id = id;
		this.name = name;
		this.supplier = supplier;
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
	public String getSupplier() {
		return supplier;
	}
	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}
	

}
