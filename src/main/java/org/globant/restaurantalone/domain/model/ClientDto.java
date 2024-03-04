package org.globant.restaurantalone.domain.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClientDto {
    private String document;
    private String fullName;
    private String email;
    private String phone;
    private String deliveryAddress;
}
