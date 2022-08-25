import styled from 'styled-components';
import SocialSignup from './SocialSignup';
import EmailSignup from './EmailSignup';
import { RiShareBoxLine } from 'react-icons/ri';

const SignupSection = styled.div`
  display: flex;
  flex-direction: column;
`;

const BottomText = styled.div`
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  height: 78px;
  font-size: 13px;
  padding: 16px;
  /* margin: 0px 0px 24px; */
`;

const EmployerSignupText = styled.div`
  margin-top: 10px;
`;

const Link = styled.a`
  color: #0074cc;
`;

// const signupSubmitHandler

const SignupForm = () => {

  return (
    <SignupSection>
      <SocialSignup />
      <EmailSignup />
      <BottomText>
        <div>Don't have an account? <Link>Sign up</Link></div>
        <EmployerSignupText>Are you an employer? <Link>Sign up on Talent<RiShareBoxLine /></Link></EmployerSignupText>
      </BottomText>
    </SignupSection>
  );
};

export default SignupForm;