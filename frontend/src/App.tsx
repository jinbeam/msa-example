import { BrowserRouter, Routes, Route } from 'react-router-dom';
import BoardContainer from './container/BoardContainer';
import HomeContainer from './container/HomeContainer';
import IntroContainer from './container/IntoContainer';
import UserContainer from './container/UserContainer';
import WrapperContainer from './container/WrapperContainer';
import MainLayout from './layout/MainLayout';

function App() {
  return (
    <BrowserRouter>
      <MainLayout>
        <Routes>
          <Route
            path="/"
            element={
              <WrapperContainer title="HOME">
                <HomeContainer />
              </WrapperContainer>
            }
          />
          <Route
            path="/introduction"
            element={
              <WrapperContainer title="소개">
                <IntroContainer />
              </WrapperContainer>
            }
          />
          <Route
            path="/user"
            element={
              <WrapperContainer title="사용자">
                <UserContainer />
              </WrapperContainer>
            }
          />
          <Route
            path="/board"
            element={
              <WrapperContainer title="게시판">
                <BoardContainer />
              </WrapperContainer>
            }
          />
        </Routes>
      </MainLayout>
    </BrowserRouter>
  );
}

export default App;
