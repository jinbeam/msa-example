package com.sample.api.spec;

import com.sample.api.model.User;
import org.springframework.data.jpa.domain.Specification;

public class UserSpec {
    public static Specification<User> deleteYn(final String deleteYn) {
        return (root, query, cb) -> cb.equal(root.get("deleteYn"), deleteYn);
    }
    public static Specification<User> nickname(final String nickname) {
        return (root, query, cb) -> cb.like(root.get("nickname"), "%"+nickname+"%");
    }
}
