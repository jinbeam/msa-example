import { BrowserRouter, Routes, Route } from 'react-router-dom';
import HomeContainer from './container/HomeContainer';
import MainLayout from './layout/MainLayout';

function App() {
  return (
    <BrowserRouter>
      <MainLayout>
        <Routes>
          <Route path="/" element={<HomeContainer />} />
        </Routes>
      </MainLayout>
    </BrowserRouter>
  );
}

export default App;
