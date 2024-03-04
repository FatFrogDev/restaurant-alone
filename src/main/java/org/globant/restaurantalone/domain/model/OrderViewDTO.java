package org.globant.restaurantalone.domain.model;

// import java.util.UUID;

import java.time.LocalDate;
import java.util.UUID;

public class OrderViewDTO {
    // private UUID uuid;
    private LocalDate creationDateTime;
    private String clientDocument;
    private UUID productUUID;
    private int quantity;
    private String extraInformation;
    private String subTotal;
    private Double tax;
    private Double grandTotal;
    private boolean delivered;
    private LocalDate deliveryDate;
}
