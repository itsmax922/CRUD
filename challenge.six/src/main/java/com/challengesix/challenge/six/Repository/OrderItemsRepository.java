package com.challengesix.challenge.six.Repository;

import com.challengesix.challenge.six.model.OrderItems;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class OrderItemsRepository {

    public static HashMap<Integer, OrderItems> orderItemMap = new HashMap<>();

    static {
        orderItemMap.put(1, new OrderItems(1));
        orderItemMap.put(2, new OrderItems(2));
        orderItemMap.put(3, new OrderItems(3));
    }

    public static int getQuantity(int itemId) {
        return orderItemMap.getOrDefault(itemId, null).getQuantity();
    }
}
