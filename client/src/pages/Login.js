import styled from 'styled-components';
import logo from '../resources/stack-overflow.png';
import SocialLogin from '../components/SocialLogin';
import EmailLogin from '../components/EmailLogin';
import { RiShareBoxLine } from 'react-icons/ri';

const LoginContainer = styled.div`
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  height: 100vh;
`;

const StackOverflowLogo = styled.img.attrs({
  src: `${logo}`
})`
  width: 32px;
  height: 37px;
  margin: 20px;
`;

const BottomText = styled.div`
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  width: 288px;
  height: 78px;
  font-size: 13px;
  padding-top: 16px;
`;

const Link = styled.a`
  color: #0074cc;
`;

const EmployerSignupText = styled.div`
  margin-top: 10px;
`;

const Login = () => {

  return (
    <LoginContainer>
      <StackOverflowLogo />
      <SocialLogin />
      <EmailLogin />
      <BottomText>
        <div>Don't have an account? <Link>Sign up</Link></div>
        <EmployerSignupText>Are you an employer? <Link>Sign up on Talent<RiShareBoxLine /></Link></EmployerSignupText>
      </BottomText>
    </LoginContainer>
  );
};

export default Login;