import Questions from './pages/Questions';
import QuestionCreator from './pages/QuestionCreator';
import QuestionAnswer from './pages/QuestionAnswer';
import Header from './components/Header';
import Login from './pages/Login';
import Signup from './pages/Signup';
import Answer from './components/Answer';
import { createGlobalStyle } from 'styled-components';
import { BrowserRouter, Routes, Route } from 'react-router-dom';

const GlobalStyle = createGlobalStyle`
  body {
    font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif;
    width: 100%;
    height: 100vh;
  }
`;

function App() {
  return (
    <div className='App'>
      <GlobalStyle />
      <Header />
      <BrowserRouter>
        <Routes>
          <Route path='/questions' element={<Questions />} />
          <Route path='/questions/ask' element={<QuestionCreator />} />
          <Route path='/questions/:questionId' element={<QuestionAnswer />} />
          <Route path='/users/login' element={<Login />} />
          <Route path='/users/join' element={<Signup />} />
          <Route path='/questions/questionId/answer' element={<Answer />} />
        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
