package net.provera.cartservice.dao.model;

import java.util.List;
import java.util.ArrayList;

import lombok.Data;

@Data
public class Cart {
	 
	private String userId;
	private List<CartItem> items;

	public Cart(String userId) {
		this.userId = userId;
		this.items = new ArrayList<>();
	}

}
