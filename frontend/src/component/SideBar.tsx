import { Divider, Drawer, IconButton, List, ListItem, ListItemIcon, ListItemText } from '@mui/material';
import ChevronLeftIcon from '@mui/icons-material/ChevronLeft';
import { upMenu, downMenu } from '../assets/data/menu';
import React, { useEffect } from 'react';
import { Link } from 'react-router-dom';
import styled from '@emotion/styled';
import { useRecoilValue } from 'recoil';
import { menuSelector } from '../assets/state/menu';
import { IMenu } from '../assets/interface/menu';

const Logo = styled(Link)`
  background: url(/resources/img/logo.png) no-repeat center;
  width: 100%;
  min-height: 50px;
  background-size: cover;
`;

const MenuIconButton = styled(ListItemIcon)`
  & > svg {
    -webkit-user-select: none;
    -moz-user-select: none;
    -ms-user-select: none;
    user-select: none;
    width: 1em;
    height: 1em;
    display: inline-block;
    fill: currentColor;
    -webkit-flex-shrink: 0;
    -ms-flex-negative: 0;
    flex-shrink: 0;
    -webkit-transition: fill 200ms cubic-bezier(0.4, 0, 0.2, 1) 0ms;
    transition: fill 200ms cubic-bezier(0.4, 0, 0.2, 1) 0ms;
    font-size: 1.5rem;
  }
`;

interface props {
  drawerWidth: number;
  DrawerHeader: React.ElementType;
  handleDrawerClose: () => void;
  open: boolean;
}
function SideBar({ drawerWidth, DrawerHeader, handleDrawerClose, open }: props) {
  const menus = useRecoilValue(menuSelector);

  return (
    <Drawer
      sx={{
        width: drawerWidth,
        flexShrink: 0,
        '& .MuiDrawer-paper': {
          width: drawerWidth,
          boxSizing: 'border-box',
        },
      }}
      variant="persistent"
      anchor="left"
      open={open}
    >
      <DrawerHeader>
        <Logo to="/" />
        <IconButton onClick={handleDrawerClose}>
          <ChevronLeftIcon />
        </IconButton>
      </DrawerHeader>
      <Divider />
      <List>
        {menus
          .filter((menu: IMenu) => menu.category === 'up')
          .map((menu: IMenu) => (
            <Link to={menu.link} key={menu.menuId}>
              <ListItem button>
                <MenuIconButton dangerouslySetInnerHTML={{ __html: menu.icon }}></MenuIconButton>
                <ListItemText primary={menu.name} />
              </ListItem>
            </Link>
          ))}
        {/* {upMenu.map((menu) => (
          <Link to={menu.to} key={menu.key}>
            <ListItem button>
              <ListItemIcon>{menu.icon}</ListItemIcon>
              <ListItemText primary={menu.name} />
            </ListItem>
          </Link>
        ))} */}
      </List>
      <Divider />
      <List>
        {menus
          .filter((menu: IMenu) => menu.category === 'down')
          .map((menu: IMenu) => (
            <Link to={menu.link} key={menu.menuId}>
              <ListItem button>
                <MenuIconButton dangerouslySetInnerHTML={{ __html: menu.icon }}></MenuIconButton>
                <ListItemText primary={menu.name} />
              </ListItem>
            </Link>
          ))}
        {/* {downMenu.map((menu) => (
          <Link to={menu.to} key={menu.key}>
            <ListItem button>
              <ListItemIcon>{menu.icon}</ListItemIcon>
              <ListItemText primary={menu.name} />
            </ListItem>
          </Link>
        ))} */}
      </List>
    </Drawer>
  );
}

export default SideBar;
