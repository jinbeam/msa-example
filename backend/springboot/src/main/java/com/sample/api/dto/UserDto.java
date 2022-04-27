package com.sample.api.dto;

import com.sample.api.model.User;
import com.sample.api.model.DateTime;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/******************************************************************
 * <pre>
 * com.sample.api.dto
 * ㄴ UserDto.java
 *  </pre>
 * @author   : Park Jin Su
 * @version  : 1.0
 * @since 2022/01/25
 * @see <b>Copyright (C) by OSC Company All right reserved.</b>
 *******************************************************************/

public class UserDto {

    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class SaveUserReq {

        private int id;
        private String userId;
        private String username;
        private String nickname;

        @Builder
        public SaveUserReq(int id, String userId, String username, String nickname) {
            this.id = id;
            this.userId = userId;
            this.username = username;
            this.nickname = nickname;
        }

        public User toEntity() {
            return User.builder()
                    .id(id)
                    .userId(userId)
                    .username(username)
                    .nickname(nickname)
                    .build();

        }
    }

    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class FindUserReq {

        private String userId;
        private String password;
        private String username;
        private String nickname;

        @Builder
        public FindUserReq(String userId, String username, String nickname) {

            this.userId = userId;
            this.username = username;
            this.nickname = nickname;
        }

        public User toEntity() {
            return User.builder()
                    .userId(userId)
                    .username(username)
                    .nickname(nickname)
                    .build();

        }
    }

    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class FindUserRes {

        private String userId;
        private String username;
        private String nickname;
        private DateTime datetime;

        @Builder
        public FindUserRes(User user) {
            this.userId = user.getUserId();
            this.username = user.getUsername();
            this.nickname = user.getNickname();
            this.datetime = user.getDateTime();
        }
    }

    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class GetTokenReq {

        private String userId;
        private String password;

        @Builder
        public GetTokenReq(String userId, String password) {
            this.userId = userId;
            this.password = password;
        }

        public User toEntity() {
            return User.builder()
                    .userId(userId)
                    .password(password)
                    .build();

        }
    }
}
