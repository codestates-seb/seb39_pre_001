import Questions from './pages/Questions';
import QuestionCreator from './pages/QuestionCreator';
import QuestionAnswer from './pages/QuestionAnswer';
import Login from './pages/Login';
import Signup from './pages/Signup';
import { createGlobalStyle } from 'styled-components';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import Home from './pages/Home';
import NavBar from './components/NavBar';
import Footer from './components/Footer';
import Background from './components/Background';
import QuestionEdit from './pages/QuestionEdit';

const GlobalStyle = createGlobalStyle`
  body {
    font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif;
    width: 100%;
    height: 100vh;
    margin: 0;
  }
`;

function App() {
  return (
    <div className='App'>
      <GlobalStyle />
      <BrowserRouter>
        <NavBar />
        <Background />
        <Routes>
          <Route path='/' element={<Home />} />
          <Route path='/questions' element={<Questions />} />
          <Route path='/questions/ask' element={<QuestionCreator />} />
          <Route path='/questions/:questionId' element={<QuestionAnswer />} />
          <Route path='/users/login' element={<Login />} />
          <Route path='/users/join' element={<Signup />} />
          <Route path='/questions/:questionId/edit' element={<QuestionEdit />} />
        </Routes>
        <Footer />
      </BrowserRouter>
    </div>
  );
}

export default App;
