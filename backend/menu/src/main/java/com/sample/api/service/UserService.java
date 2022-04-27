package com.sample.api.service;

import com.sample.api.dto.UserDto;
import com.sample.api.model.User;
import com.sample.api.spec.UserSpec;
import com.sample.api.exception.ResourceNotFoundException;
import com.sample.api.repository.UserRepository;
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
