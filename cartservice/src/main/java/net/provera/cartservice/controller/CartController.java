package net.provera.cartservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.provera.cartservice.dao.model.CartItem;
import net.provera.cartservice.service.CartService;

@RestController
@RequestMapping("/api/cart")
public class CartController {
	@Autowired
    private CartService cartService;
	 @PostMapping("/{userId}")
	    public ResponseEntity<Void> addItemToCart(@PathVariable String userId, @RequestBody CartItem cartItem) {
	        cartService.addItemToCart(userId, cartItem);
	        return ResponseEntity.ok().build();
	    }

	    @GetMapping("/{userId}")
	    public ResponseEntity<List<CartItem>> getCart(@PathVariable String userId) {
	        List<CartItem> cartItems = cartService.getCartItems(userId);
	        return ResponseEntity.ok(cartItems);
	    }

	    @PutMapping("/{userId}/{itemIndex}")
	    public ResponseEntity<Void> updateCartItem(@PathVariable String userId, @PathVariable int itemIndex, @RequestBody CartItem cartItem) {
	        cartService.updateCartItem(userId, itemIndex, cartItem);
	        return ResponseEntity.ok().build();
	    }

	    @DeleteMapping("/{userId}/{itemIndex}")
	    public ResponseEntity<Void> removeCartItem(@PathVariable String userId, @PathVariable int itemIndex) {
	        cartService.removeCartItem(userId, itemIndex);
	        return ResponseEntity.ok().build();
	    }


}
