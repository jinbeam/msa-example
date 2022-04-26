import client from './client';

export const getMenus = () => client.get(`${!process.env.REACT_APP_API_BASE_URL && 'http://'}${process.env.REACT_APP_MENU_API}/menu`);
