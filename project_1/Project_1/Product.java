package Project_1;

public class Product {

	private String name;
	private String id;
	private String size;
	private String collection;
	private String image;
	private String quantity;
	
	public Product() {
		name = "not set";
		id = "not set";
		size = "not set";
		collection = "not set";
		image = "not set";
		quantity = "not set";
		

	}
	
	public Product(String n, String i, String s, String c, String im, String q) {
		name = n;
		id = i;
		size = s;
		collection = c;
		image = im;
		quantity = q;
		
	}
	
	// getters and setters for private data
	public String getName() {
		return name;
	}
	public void setName(String n) {
		name = n;
	}
	public String getId() {
		return id;
	}
	public void setId(String i) {
		id = i;
	}	
	public String getSize() {
		return size;
	}
	public void setSize(String s) {
		size = s;
	}	
	public String getCollection() {
		return collection;
	}
	public void setCollection(String c) {
		collection = c;
	}	
	public String getImage() {
		return image;
	}
	public void setImage(String im) {
		image = im;
	}	
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String q) {
		quantity = q;
	}	
	
	
	// string representation of this product
	public String toString () {
		return name + id + size + collection + image + quantity;
	}

}
