// import { Link } from 'react-router-dom';
import styled from 'styled-components';

const EmailLoginWrapper = styled.div`
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  width: 288px;
  height: 234px;
  border-radius: 4px;
  background-color: white;
  border: none;
  box-shadow: 0 0 8px rgba(0, 0, 0, 0.04);
  margin-top: 20px;
`;

const InputEmail = styled.div`
  display: flex;
  flex-direction: column;
  justify-content: center;
  width: 240px;
  margin-bottom: 25px;
`;

const InputPassword = styled.div`
  display: flex;
  flex-direction: column;
  justify-content: center;
  width: 240px;
  margin-bottom: 15px;
`;

// as-is: a태그  to-be: link
const Link = styled.a`
  font-size: 12px;
  color: #0074cc;
`;

const Label = styled.label`
  font-size: 15px;
  font-weight: 700;
  margin-bottom: 5px;
`;

const Input = styled.input`
  width: 240px;
  height: 32px;
  border: 1px solid #BABFC4;
  border-radius: 4px;
  `;

const LabelLinkWrapper = styled.div`
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  align-items: center;
`;

const LoginButton = styled.button`
  width: 240px;
  height: 37px;
  border: 1px solid #0A95FF;
  border-radius: 4px;
  background-color: #0A95FF;
  color: white;
  :hover {
    background-color: #0074CC;
  }
  cursor: pointer;
`;

const EmailLogin = () => {

  return (
    <EmailLoginWrapper>
      <InputEmail>
        <Label>Email</Label>
        <Input type="text" />
      </InputEmail>
      <InputPassword>
        <LabelLinkWrapper>
          <Label>Password</Label>
          <Link>Forgot password?</Link>
        </LabelLinkWrapper>
        <Input type="password" />
      </InputPassword>
      <LoginButton type="submit">Log in</LoginButton>
    </EmailLoginWrapper>
  );
};

export default EmailLogin;