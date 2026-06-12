package service;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Product;

public class ProductService {

    private final List<Product> products = new ArrayList<>();
    private final static String[] columns = {
		    "Nome",
		    "Código",
		    "Preço",
		    "Categoria"
		    };
    private final Map<String, Product> productsByCode = new HashMap<>();
    
    public List<Product> getProducts() {
        return products;
    }

    public boolean addProduct(Product p) {
    	if(productsByCode.containsKey(p.getCode())) {
    		return false;
    	}
    	productsByCode.put(p.getCode(), p);
        return products.add(p);
    }

	public String[] getColumns() {
		return columns;
	}
	
	public void removeProduct(int index) {
		if(index < products.size() && index >= 0) {
			Product removed = products.remove(index);
			productsByCode.remove(removed.getCode());
		}
	}
	
	public int searchProduct(String name) {
		for( int i = 0; i < products.size(); i++) {
			if(products.get(i).getName().equalsIgnoreCase(name)) {
				return i;
			}
		}
		return -1;
	}
    public String getProductDescription(int index) {
    	StringBuilder text = new StringBuilder();
    	Product p = products.get(index);
    	text.append(p.getCode()).append(" - ").append(p.getName());
    	return text.toString();
    }
	
}
