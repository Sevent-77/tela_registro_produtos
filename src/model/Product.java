package model;

public class Product {

    private String name;
    private String code;
    private double price;
    private String category;

    public Product(
            String name,
            String code,
            double price,
            String category) {

        this.setName(name);
        this.setCode(code);
        this.setPrice(price);
        this.setCategory(category);
    }

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	    // getters e setters
	
}
