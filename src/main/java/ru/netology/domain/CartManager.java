package ru.netology.domain;

import ru.netology.domain.PurchaseItem.PurchaseItem;

public class CartManager {
    private PurchaseItem[] items = new PurchaseItem[0];

    public void add(PurchaseItem item) {
        int length = items.length + 1;
        PurchaseItem[] tmp = new PurchaseItem[length];
        for (int i = 0; i < items.length; i++) {
            tmp[i] = items[i];
        }
        int lastIndex  = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

}
