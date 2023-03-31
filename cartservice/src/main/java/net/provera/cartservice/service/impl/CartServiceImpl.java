package net.provera.cartservice.service.impl;

import java.util.List;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import net.provera.cartservice.dao.model.CartItem;
import net.provera.cartservice.service.CartService;

import net.provera.cartservice.exception.*;


@Service
public class CartServiceImpl implements CartService {
	 	@Autowired
	    private RedisTemplate<String, Object> redisTemplate;

	    private static final String CART_KEY_PREFIX = "cart:";
	    @Autowired
	    private ObjectMapper objectMapper;

	    @Override
	    public void addItemToCart(String userId, CartItem cartItem) {
	        validateCartItem(cartItem);
	        redisTemplate.opsForHash().put(CART_KEY_PREFIX + userId, cartItem.getProductId(), cartItem);
	    }

	    @Override
	    public List<CartItem> getCartItems(String userId) {
	        List<Object> objectList = redisTemplate.opsForHash().values(CART_KEY_PREFIX + userId);
	        return objectList.stream()
	                .map(obj -> objectMapper.convertValue(obj, CartItem.class))
	                .collect(Collectors.toList());
	    }

	    @Override
	    public void updateCartItem(String userId, int itemIndex, CartItem cartItem) {
	        validateCartItem(cartItem);
	        if (redisTemplate.opsForHash().hasKey(CART_KEY_PREFIX + userId, cartItem.getProductId())) {
	            redisTemplate.opsForHash().put(CART_KEY_PREFIX + userId, cartItem.getProductId(), cartItem);
	        } else {
	            throw new CartItemNotFoundException(userId, itemIndex);
	        }
	    }

	    @Override
	    public void removeCartItem(String userId, int itemIndex) {
	        CartItem cartItem = getItemAtIndex(userId, itemIndex);
	        if (cartItem != null) {
	            redisTemplate.opsForHash().delete(CART_KEY_PREFIX + userId, cartItem.getProductId());
	        } else {
	            throw new CartItemNotFoundException(userId, itemIndex);
	        }
	    }

	    private CartItem getItemAtIndex(String userId, int itemIndex) {
	        List<CartItem> cartItems = getCartItems(userId);
	        return (itemIndex >= 0 && itemIndex < cartItems.size()) ? cartItems.get(itemIndex) : null;
	    }

	    private void validateCartItem(CartItem cartItem) {
	        if (cartItem.getProductId() == null || cartItem.getProductId().isEmpty()) {
	            throw new IllegalArgumentException("Product ID cannot be null or empty.");
	        }
	        if (cartItem.getName() == null || cartItem.getName().isEmpty()) {
	        throw new IllegalArgumentException("Product name cannot be null or empty.");
	        }
	        if (cartItem.getQuantity() <= 0) {
	        throw new IllegalArgumentException("Product quantity must be greater than 0.");
	        }
	        }
	        
}
