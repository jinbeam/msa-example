package com.board.api.dto;

import com.board.api.model.Board;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/******************************************************************
 * <pre>
 * com.board.api.dto
 * ㄴ UserDto.java
 *  </pre>
 * @author   : Park Jin Su
 * @version  : 1.0
 * @since 2022/01/25
 * @see <b>Copyright (C) by OSC Company All right reserved.</b>
 *******************************************************************/

public class BoardDto {

    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class GetBoardReq {

        private Integer id;
        private String entityId;
        private String title;
        private String content;
        private Integer createId;
        private LocalDateTime createDt;

        public Board toEntity() {
            return Board.builder().id(id).entityId(entityId).title(title).content(content).createId(createId).createDt(createDt).build();
        }
    }
    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class GetBoardRes {

        private String entityId;
        private String title;
        private String content;
        private Integer createId;
        private LocalDateTime createDt;

        public GetBoardRes(String entityId, String title, String content, Integer createId, LocalDateTime createDt) {
            this.entityId = entityId;
            this.title = title;
            this.content = content;
            this.createId = createId;
            this.createDt = createDt;
        }
    }
}