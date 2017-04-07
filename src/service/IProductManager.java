package service;

import java.util.List;

import dto.Catalogue;
import dto.Product;

public interface IProductManager {
	
	public void createProduct(Catalogue cat, String nom, double sellingPrice, String description); 
		
		//ajouter le produit au catalogue
	
	
	public List<Product>getProduct();
	
		
	public void deletedProduct(int id);
		
		//supression du Produit du catalogue et BDD 
		
	
	
	public void updateProduct(int id, double sellingPrice);
		//recuperer le produit de la bd
		//modifie son prix
		//inserer ds la bd
		
	

}
