package org.com.homeworks.dmytro_k.hw_18_08_24.ad_board_common.domain;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Phone {

    @Id
    @Column(name = "phone_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    @Column(name = "phone_number")
    String phoneNumber;
}