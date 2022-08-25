// import { Link } from 'react-router-dom';
import { useState } from 'react';
import styled from 'styled-components';

const EmailLoginForm = styled.form`
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  width: 288px;
  height: 234px;
  border-radius: 4px;
  background-color: white;
  border: none;
  box-shadow: 0 0 8px 4px rgba(0, 0, 0, 0.04);
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

const ErrorMessage = styled.span`
  color: red;
  font-weight: 500;
  font-size: 12px;
`;

const EmailLogin = () => {
  const [email, setEmail] = useState('');

  // error message
  const [emailMessage, setEmailMessage] = useState('');

  // validation check
  const emailChangeHandler = (e) => {
    const emailRegex = /([\w-.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/;
    const currentEmail = e.target.value;
    setEmail(currentEmail);

    if (!emailRegex.test(currentEmail)) {
      setEmailMessage('올바른 이메일 형식이 아닙니다.');
    } else {
      setEmailMessage('');
    }
  };

  return (
    <EmailLoginForm>
      <InputEmail>
        <Label>Email</Label>
        <Input type="email" size="30" maxLength="100" onChange={emailChangeHandler} />
        {email.length > 0 && <ErrorMessage>{emailMessage}</ErrorMessage>}
      </InputEmail>
      <InputPassword>
        <LabelLinkWrapper>
          <Label>Password</Label>
          <Link>Forgot password?</Link>
        </LabelLinkWrapper>
        <Input type="password" autoComplete="off" />
      </InputPassword>
      <LoginButton type="submit">Log in</LoginButton>
    </EmailLoginForm>
  );
};

export default EmailLogin;