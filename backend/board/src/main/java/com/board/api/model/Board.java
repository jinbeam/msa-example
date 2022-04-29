package com.board.api.model;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

/******************************************************************
 * <pre>
 * com.sample.api.model
 * ㄴ Menu.java
 *  </pre>
 * @author   : Park Jin Su
 * @version  : 1.0
 * @since 2022/04/25
 * @see <b>Copyright (C) by OSC Company All right reserved.</b>
 *******************************************************************/
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "tb_board", schema = "sample")
public class Board {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "entity_id")
    private String entityId;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @Column(name = "view_count")
    private int viewCount;

    @Column(name = "create_id")
    private Integer createId;

    @Column(name = "create_dt")
    private LocalDateTime createDt;

    @Builder
    public Board(int id, String entityId, String title, String content, int viewCount, Integer createId, LocalDateTime createDt) {
        this.id = id;
        this.entityId = entityId;
        this.title = title;
        this.content = content;
        this.viewCount = viewCount;
        this.createId = createId;
        this.createDt = createDt;
    }
}
