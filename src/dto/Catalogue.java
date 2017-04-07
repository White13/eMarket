package dto;

import java.util.ArrayList;
import java.util.List;

public class Catalogue {
	
	private List<Product>listProduct = new ArrayList<Product>();

	public List<Product> getListProduct() {
		return listProduct;
	}

	public void setListProduct(List<Product> listProduct) {
		this.listProduct = listProduct;
	}

	

}
