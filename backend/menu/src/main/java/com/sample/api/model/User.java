package com.sample.api.model;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/******************************************************************
 * <pre>
 * com.sample.api.model
 * ㄴ User.java
 *  </pre>
 * @author   : Park Jin Su
 * @version  : 1.0
 * @since 2022/01/25
 * @see <b>Copyright (C) by OSC Company All right reserved.</b>
 *******************************************************************/
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "tb_user", schema = "sample")
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "password")
    private String password;

    @Column(name = "username")
    private String username;

    @Column(name = "nickname")
    private String nickname;

    @Column(name = "delete_yn")
    private String deleteYn;

    @Embedded
    DateTime dateTime;

    @OneToOne(mappedBy = "user", cascade = CascadeType.PERSIST, orphanRemoval = true, fetch = FetchType.LAZY)
    private UserDetail userDetail;

    @PrePersist
    public void prePersist() {
//        this.id = id;
//        this.userId = userId;
//        this.username = username;
//        this.nickname = nickname;
    }
    @Builder
    public User(int id, String userId, String password, String username, String nickname, String deleteYn) {
        this.id = id;
        this.userId = userId;
        this.password = password;
        this.username = username;
        this.nickname = nickname;
        this.deleteYn = deleteYn;
    }
}