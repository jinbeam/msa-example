package com.menu.api.service;

import com.menu.api.dto.UserDto;
import com.menu.api.exception.ResourceNotFoundException;
import com.menu.api.model.User;
import com.menu.api.repository.UserRepository;
import com.menu.api.spec.UserSpec;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * Created by jspark
 */
@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional(readOnly = true)
    public User findUser(Integer id) {
        return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
    }

    @Transactional(readOnly = true)
    public Page<User> findUsers(UserDto.FindUserReq req, Pageable pageable) {
        Page<User> pUser = userRepository.findAll(getSpec(req), pageable);

        return pUser;
    }

    private Specification<User> getSpec(UserDto.FindUserReq req) {
        Specification<User> spec = Specification.where(UserSpec.deleteYn("N"));

        if(req != null) {
            if(req.getNickname() != null && !(req.getNickname()).equals("")) spec = spec.and(UserSpec.nickname(req.getNickname()));
        }

        return spec;
    }

}
