package com.menu.api.repository;

import com.menu.api.model.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MenuRepository extends JpaRepository<Menu, Integer> {
    List<Menu> findAllByOrderByPositionAsc();
//    Optional<List<Menu>> findAll(Menu menu);
}
