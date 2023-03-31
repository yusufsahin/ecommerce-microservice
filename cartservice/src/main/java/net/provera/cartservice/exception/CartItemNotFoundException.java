package net.provera.cartservice.exception;

public class CartItemNotFoundException extends RuntimeException {
    public CartItemNotFoundException(String userId, int itemIndex) {
        super("Cart item not found for user: " + userId + " at index: " + itemIndex);
    }
}