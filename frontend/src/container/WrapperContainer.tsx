import { useSetRecoilState } from 'recoil';
import { titleState } from '../assets/state/menu';

interface props {
  title: string;
  children: React.ReactNode;
}

function WrapperContainer({ title, children }: props) {
  const setCurrentTitle = useSetRecoilState(titleState);
  setCurrentTitle(title);
  return <>{children}</>;
}

export default WrapperContainer;
