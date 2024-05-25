package org.example.demo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class CartManager {
    private static CartManager instance;
    private ObservableList<ChiTietMatHangBpdhqt> cartItems;

    private CartManager() {
        cartItems = FXCollections.observableArrayList();
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

    public ObservableList<ChiTietMatHangBpdhqt> getItemsBySite(String site) {
        ObservableList<ChiTietMatHangBpdhqt> filteredItems = FXCollections.observableArrayList();
        for (ChiTietMatHangBpdhqt item : cartItems) {
            if (item.getThuocSite().equals(site)) {
                filteredItems.add(item);
            }
        }
        return filteredItems;
    }

    public ObservableList<String> getAllSites() {
        ObservableList<String> sites = FXCollections.observableArrayList();
        for (ChiTietMatHangBpdhqt item : cartItems) {
            if (!sites.contains(item.getThuocSite())) {
                sites.add(item.getThuocSite());
            }
        }
        return sites;
    }
}
