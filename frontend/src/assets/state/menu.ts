import { atom, selector } from 'recoil';
import * as menuApi from '../api/menu';
import { IMenu } from '../interface/menu';

export const titleState = atom<string>({
  key: 'titleState',
  default: '',
});

export const menuSelector = selector<IMenu[]>({
  key: 'menuSelector',
  get: async () => {
    try {
      const response = await menuApi.getMenus();
      return response.data;
    } catch (error) {
      return [];
    }
  },
});
