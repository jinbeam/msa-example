package com.sample.api.service;

import com.sample.api.dto.MenuDto;
import com.sample.api.exception.ResourceNotFoundException;
import com.sample.api.model.Menu;
import com.sample.api.repository.MenuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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
