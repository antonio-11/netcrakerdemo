package Entity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@Service
public class Product implements IParent, IChilds{		
	
	@JsonProperty(value = "name")
	private String name;
	
	@JsonProperty(value = "price")
	private Double price;
	
	@JsonProperty(value = "products")
	private List<Product> products;
	
	@JsonIgnoreProperties
	//@JsonIgnore
	private String parent;
	
	public Product() {
		products = new ArrayList<Product>();
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public List<Product> getProducts() {
		return products;
	}

	@Override
	public void setProducts(List<Product> products) {
		for(Product p:products) {
			p.setParent(this.toString());
			this.products.add(p);
		}
	}

	@Override
	public String getParent() {
		return parent;
	}

	@Override
	public void setParent(String parent) {
		this.parent = parent;
	}

}
