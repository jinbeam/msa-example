package com.sample.api.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "tb_user_detail", schema = "sample")
public class UserDetail implements Serializable {
    @Id
    @JoinColumn(name = "id")
    @OneToOne(targetEntity = User.class, fetch = FetchType.EAGER , cascade = CascadeType.DETACH, optional = false)
    private User user;

    @Column(name = "email")
    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

}
