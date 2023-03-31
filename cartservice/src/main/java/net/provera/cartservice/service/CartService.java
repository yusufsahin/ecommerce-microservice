package net.provera.cartservice.service;

import java.util.List;

import net.provera.cartservice.dao.model.CartItem;

public interface CartService {
	 
	void addItemToCart(String userId, CartItem cartItem);

    List<CartItem> getCartItems(String userId);

    void updateCartItem(String userId, int itemIndex, CartItem cartItem);

    void removeCartItem(String userId, int itemIndex);
}
