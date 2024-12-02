package com.recap;

import java.math.BigDecimal;

public record Product(int id,
                      String name,
                      String category,
                      BigDecimal price,
                      int quantity
                      ) {
}
