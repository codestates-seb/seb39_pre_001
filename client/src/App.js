import Questions from './pages/Questions';
import QuestionCreator from './pages/QuestionCreator';
import QuestionAnswer from './pages/QuestionAnswer';
import Login from './pages/Login';
import Signup from './pages/Signup';
import { createGlobalStyle } from 'styled-components';
import { BrowserRouter, Routes, Route, useLocation } from 'react-router-dom';
import Home from './pages/Home';
import NavBar from './components/NavBar';
import Footer from './components/Footer';
import Background from './components/Background';
import NavBarLoggedIn from './components/NavBarLoggedIn';
import NotFound from './components/NotFound';
import { useState } from 'react';
import axios from 'axios';

const GlobalStyle = createGlobalStyle`
  body {
    font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif;
    width: 100%;
    height: 100vh;
    margin: 0;
  }
`;

function App() {
  const [isLogin, setIsLogin] = useState(false);

  return (
    <div className='App'>
      <GlobalStyle />
      <BrowserRouter>
        {isLogin ? <NavBarLoggedIn isLogin={isLogin} setIsLogin={setIsLogin} /> : <NavBar isLogin={isLogin} setIsLogin={setIsLogin} />}
        <Background />
        <Routes>
          <Route path='/' element={<Home />} />
          <Route path='/questions' element={<Questions />} />
          <Route path='/questions/ask' element={<QuestionCreator />} />
          <Route path='/questions/:questionId' element={<QuestionAnswer />} />
          <Route path='/users/login' element={<Login isLogin={isLogin} setIsLogin={setIsLogin} />} />
          <Route path='/users/join' element={<Signup />} />
          <Route path={'*'} element={<NotFound />}></Route>
        </Routes>
        <Footer />
      </BrowserRouter>
    </div>
  );
}

export default App;
