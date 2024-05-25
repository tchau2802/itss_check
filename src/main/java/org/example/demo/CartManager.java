package org.example.demo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class CartManager {
    private static CartManager instance;
    private ObservableList<ChiTietMatHangBpdhqt> cartItems;
    private ObservableList<String> sites;

    private CartManager() {
        cartItems = FXCollections.observableArrayList();
        sites = FXCollections.observableArrayList("Site A", "Site B", "Site C");
    }

    public static CartManager getInstance() {
        if (instance == null) {
            instance = new CartManager();
        }
        return instance;
    }

    public void addToCart(ChiTietMatHangBpdhqt item) {
        cartItems.add(item);
    }

    public ObservableList<ChiTietMatHangBpdhqt> getCartItems() {
        return cartItems;
    }

    public ObservableList<String> getSites() {
        return sites;
    }
}
