package com.menu.api.service;

import com.menu.api.dto.MenuDto;
import com.menu.api.exception.ResourceNotFoundException;
import com.menu.api.repository.MenuRepository;
import com.menu.api.model.Menu;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class MenuService {
    private final MenuRepository menuRepository;

    public List<Menu> findMenus(MenuDto.GetMenuReq req) {
        return menuRepository.findAllByOrderByPositionAsc();
    }

    public Menu findMenu(int menuId) {
        return menuRepository.findById(menuId).orElseThrow(() -> new ResourceNotFoundException(menuId));
    }
}
