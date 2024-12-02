package com.recap;

import java.math.BigDecimal;

public record Order(String orderId,
                    String item,
                    int quantity,
                    BigDecimal itemPrice,
                    BigDecimal totalPrice
                    ) {
}
