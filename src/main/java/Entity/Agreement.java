package Entity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@Service
public class Agreement implements IChilds{
	@JsonIgnoreProperties
	@JsonIgnore
	private String name;

	@JsonProperty(value = "signedBy")
	private String signedBy;
	
	@JsonProperty(value = "products")
	private List<Product> products;
	
	@Override
	public List<Product> getProducts() {
		return products;
	}
	@JsonIgnoreProperties
	@JsonIgnore
	boolean valid;
	
	@Override
	public void setProducts(List<Product> products) {
		boolean isAdded = true;

		// if any product is invalid, all array will be discarded
		for (Product p :products) {
			if( !p.getProducts().isEmpty()) {
				isAdded = false;
				continue;
			}			
		}
		
		//set parent of each product
		if(isAdded) {
			for (Product p : products) {
				p.setParent(this.toString());
				this.products.add(p);
			}	
		}
		valid = isAdded;					
	}


	public Agreement() {
		products = new ArrayList<Product>();
		this.name = "Agreement "+ getDateString();
	}
	
	
	private String getDateString() {
		SimpleDateFormat sfd = new SimpleDateFormat("dd-MMMM-yyyy");
		return sfd.format(new Date());
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSignedBy() {
		return signedBy;
	}
	public void setSignedBy(String signedBy) {
		this.signedBy = signedBy;
	}

	public boolean isValid() {		
		return valid;
	}	
	
}
