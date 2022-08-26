import { BrowserRouter, Routes, Route, Link } from 'react-router-dom';
import { createGlobalStyle } from 'styled-components';
import Login from './pages/Login';
import Signup from './pages/Signup';

const GlobalStyle = createGlobalStyle`
  body {
    font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif;
    background: #F1F2F3;
    width: 100%;
    height: 100vh;
  }
`;

const App = () => {
  return (
    <BrowserRouter>
      <GlobalStyle />
      <Routes>
        <Route path="/users/login" element={<Login />} />
        <Route path="/users/join" element={<Signup />} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;