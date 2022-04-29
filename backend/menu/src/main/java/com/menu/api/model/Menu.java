package com.menu.api.model;

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
@Table(name = "tb_menu", schema = "sample")
public class Menu {

    @Id
    @Column(name = "menu_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int menuId;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "position")
    private Integer position;

    @Column(name = "category")
    private String category;

    @Column(name = "link")
    private String link;

    @Column(name = "icon")
    private String icon;

    @Column(name = "use_yn")
    private String useYn;

    @Column(name = "parent_id")
    private Integer parentId;

    @Column(name = "create_dt")
    private LocalDateTime createDt;

    @Builder
    public Menu(int menuId, String name, String description, Integer position, String category, String link, String icon, String useYn, Integer parentId, LocalDateTime createDt) {
        this.menuId = menuId;
        this.name = name;
        this.description = description;
        this.position = position;
        this.category = category;
        this.link = link;
        this.icon = icon;
        this.useYn = useYn;
        this.parentId = parentId;
        this.createDt = createDt;
    }
}
