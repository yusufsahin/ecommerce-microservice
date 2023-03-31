package net.provera.cartservice.dao.model;

import lombok.Data;

@Data
public class CartItem {
	 private String productId;
	 private String name;
	 private double price;
	 private int quantity;

}
