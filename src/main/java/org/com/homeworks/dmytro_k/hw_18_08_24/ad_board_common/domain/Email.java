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

public class Email {

    @Id
    @Column(name = "email_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    @Column(name = "email_address")
    String emailAddress;
}
