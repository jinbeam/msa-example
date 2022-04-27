package com.sample.api.controller;

import com.sample.api.dto.UserDto;
import com.sample.api.service.UserService;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/******************************************************************
 * <pre>
 * com.sample.api.controller
 * ㄴ UserController.java
 *  </pre>
 * @author   : Park Jin Su
 * @version  : 1.0
 * @since 2022/01/25
 * @see <b>Copyright (C) by OSC Company All right reserved.</b>
 *******************************************************************/
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/user")
public class UserController {

    private final UserService userService;

    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    public Page<UserDto.FindUserRes> findUser(@Valid final UserDto.FindUserReq req,
                                              @PageableDefault(sort = {"cartNo"}, direction = Sort.Direction.DESC, size = Integer.MAX_VALUE) @Parameter(hidden = true) Pageable pageable) {
        return userService.findUsers(req, pageable).map(UserDto.FindUserRes::new);
    }

    @GetMapping("/{userNo}")
    @ResponseStatus(value = HttpStatus.OK)
    public UserDto.FindUserRes findUser(@PathVariable int userNo) {
        return new UserDto.FindUserRes(userService.findUser(userNo));
    }
}
