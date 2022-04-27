package com.sample.api.controller;

import com.sample.api.dto.MenuDto;
import com.sample.api.service.MenuService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/menu")
public class MenuController {

    private final MenuService menuService;
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.initDirectFieldAccess();
    }

    @Operation(summary = "메뉴 목록 api", description = "메뉴 목록")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<MenuDto.GetMenuRes> findMenus(@Valid @ParameterObject MenuDto.GetMenuReq req) {
        return menuService.findMenus(req).stream().map(MenuDto.GetMenuRes::new).collect(Collectors.toList());
    }

    @Operation(summary = "메뉴 상세 api", description = "메뉴 상세")
    @GetMapping("/{menuId}")
    @ResponseStatus(HttpStatus.OK)
    public MenuDto.GetMenuRes findMenus(@PathVariable int menuId) {
        return new MenuDto.GetMenuRes(menuService.findMenu(menuId));
    }
}
