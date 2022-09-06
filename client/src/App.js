import Questions from './pages/Questions';
import QuestionCreator from './pages/QuestionCreator';
import QuestionAnswer from './pages/QuestionAnswer';
import Login from './pages/Login';
import Signup from './pages/Signup';
import { createGlobalStyle } from 'styled-components';
import { BrowserRouter, Routes, Route, useNavigate } from 'react-router-dom';
import Home from './pages/Home';
import NavBar from './components/NavBar';
import NavBarLoggedIn from './components/NavBarLoggedIn';
import Footer from './components/Footer';
import Background from './components/Background';
import QuestionEdit from './pages/QuestionEdit';
import AnswerEdit from './pages/AnswerEdit';
import { useState } from 'react';
import { useCookies } from 'react-cookie';

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
  const [cookies] = useCookies(['user-access-token']);
  const token = cookies['user-access-token'];

  return (
    <div className='App'>
      <GlobalStyle />
      <BrowserRouter>
        {token ? (
          <NavBarLoggedIn isLogin={isLogin} setIsLogin={setIsLogin} />
        ) : (
          <NavBar isLogin={isLogin} setIsLogin={setIsLogin} />
        )}
        <Background />
        <Routes>
          <Route path='/' element={<Home />} />
          <Route path='/questions' element={<Questions token={token} />} />
          <Route path='/questions/ask' element={<QuestionCreator token={token} />} />
          <Route path='/questions/:questionId' element={<QuestionAnswer token={token} />} />
          <Route path='/questions/:questionId/edit' element={<QuestionEdit token={token} />} />
          <Route path='/questions/:questionId/answer/:answerId/edit' element={<AnswerEdit token={token} />} />
          <Route path='/users/login' element={<Login isLogin={isLogin} setIsLogin={setIsLogin} />} />
          <Route path='/users/join' element={<Signup />} />
        </Routes>
        <Footer />
      </BrowserRouter>
    </div>
  );
}

export default App;
