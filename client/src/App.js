import { createGlobalStyle } from 'styled-components';
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
    <>
      <GlobalStyle />
      <Signup />
    </>
  );
}

export default App;
