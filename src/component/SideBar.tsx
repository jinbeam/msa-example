import { Divider, Drawer, IconButton, List, ListItem, ListItemIcon, ListItemText } from '@mui/material';
import ChevronLeftIcon from '@mui/icons-material/ChevronLeft';
import { upMenu, downMenu } from '../assets/data/menu';
import React from 'react';
import { Link } from 'react-router-dom';

interface props {
  drawerWidth: number;
  DrawerHeader: React.ElementType;
  handleDrawerClose: () => void;
  open: boolean;
}

function SideBar({ drawerWidth, DrawerHeader, handleDrawerClose, open }: props) {
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
        <img src="/resources/img/logo.png" style={{ height: '100%' }} />

        <IconButton onClick={handleDrawerClose}>
          <ChevronLeftIcon />
        </IconButton>
      </DrawerHeader>
      <Divider />
      <List>
        {upMenu.map((menu) => (
          <ListItem button key={menu.key}>
            <ListItemIcon>{menu.icon}</ListItemIcon>
            <ListItemText primary={menu.name} />
          </ListItem>
        ))}
      </List>
      <Divider />
      <List>
        {downMenu.map((menu) => (
          <ListItem button key={menu.key}>
            <ListItemIcon>{menu.icon}</ListItemIcon>
            <ListItemText primary={menu.name} />
          </ListItem>
        ))}
      </List>
    </Drawer>
  );
}

export default SideBar;
