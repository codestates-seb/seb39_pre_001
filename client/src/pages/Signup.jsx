import styled from 'styled-components';
import NavBar from '../components/NavBar';
import SideText from '../components/SideText';
import SignupForm from '../components/SignupForm';

const SignupContainer = styled.div`
  display: flex;
  flex-direction: row;
  justify-content: center;
  align-items: center;
  min-height: 100vh;
  flex-wrap: wrap;
  padding: 24px;
`;

const Signup = () => {

  return (
    <>
      <NavBar />
      <SignupContainer>
        <SideText />
        <SignupForm />
      </SignupContainer>
    </>
  );
};

export default Signup;