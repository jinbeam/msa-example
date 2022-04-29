package com.board.api.controller;

import com.board.api.dto.BoardDto;
import com.board.api.service.BoardService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/board")
public class BoardController {

    private final BoardService boardService;
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.initDirectFieldAccess();
    }

    @Operation(summary = "게시판 목록 api", description = "게시판 목록")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public BoardDto.GetBoardRes getBoard(
            @PageableDefault(sort = {"boardNo"}, direction = Sort.Direction.DESC, size = Integer.MAX_VALUE) @Parameter(hidden = true) @Nullable Pageable pageable,
            @ParameterObject BoardDto.GetBoardReq req) {
        return null;
    }

    @Operation(summary = "게시판 목록 api", description = "게시판 목록")
    @GetMapping("/{entityId}")
    @ResponseStatus(HttpStatus.OK)
    public BoardDto.GetBoardRes getBoard(@PathVariable String entityId) {
        return null;
    }
}
