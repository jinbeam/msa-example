package com.sample.api.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.sample.api.annotation.NullOrNotBlank;
import com.sample.api.model.Menu;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.PositiveOrZero;
import java.time.LocalDateTime;

public class MenuDto {

    @Getter
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class GetMenuRes {
        private int menuId;
        private String name;
        private String description;
        private Integer position;
        private String icon;
        private String link;
        private String category;
        private String useYn;
        private Integer parentId;
        private LocalDateTime createDt;

        public GetMenuRes(final Menu menu) {
            this.menuId = menu.getMenuId();
            this.name = menu.getName();
            this.description = menu.getDescription();
            this.position = menu.getPosition();
            this.icon = menu.getIcon();
            this.link = menu.getLink();
            this.category = menu.getCategory();
            this.useYn = menu.getUseYn();
            this.parentId = menu.getParentId();
            this.createDt = menu.getCreateDt();
        }
    }

    @Getter
    @ToString
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class GetMenuReq {
        
//        @Parameter(description = "메뉴 아이디")
//        private int menuId;
        
        @Parameter(description = "메뉴 명")
        @NullOrNotBlank
        private String name;

        @Parameter(description = "메뉴 설명")
        @NullOrNotBlank
        private String description;
        @Parameter(description = "메뉴 순서")
        @PositiveOrZero
        private Integer position;
        @Parameter(description = "메뉴 주소")
        @NullOrNotBlank
        private String link;
        @Parameter(description = "메뉴 사용 여부")
        @NullOrNotBlank
        private String useYn;
        @Parameter(description = "부모 메뉴 아이디")
        @PositiveOrZero
        private Integer parentId;
        @Parameter(description = "메뉴 생성일")
        @NullOrNotBlank
        private String createDt;

        public Menu toEntity() {
            return Menu.builder()
//                    .menuId(this.menuId)
                    .name(this.name)
                    .description(this.description)
                    .position(this.position)
                    .link(this.link)
                    .useYn(this.useYn)
                    .parentId(this.parentId)
                    .build();
        }
    }
}
