export interface IMenu {
  menuId: number;
  name: string;
  description: string;
  position: number;
  icon: string;
  link: string;
  category: string;
  useYn: string;
  parentId: number;
  createDt: Date;
}
