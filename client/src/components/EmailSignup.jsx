import { useState } from 'react';
import styled from 'styled-components';
import { RiQuestionFill } from 'react-icons/ri';

const EmailSignupForm = styled.form`
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  width: 268px;
  height: 610px;
  border-radius: 4px;
  background-color: white;
  border: none;
  box-shadow: 0 0 8px 4px rgba(0, 0, 0, 0.04);
  margin: 0px 0px 24px;
  padding: 24px;
`;

const InputInfo = styled.div`
  display: flex;
  flex-direction: column;
  width: 268px;
  margin: 10px 0px 10px;
`;

const InputPassword = styled.div`
  display: flex;
  flex-direction: column;
  width: 268px;
  margin: 10px 0px 0px;
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
  width: 262px; // 268px
  height: 28px; // 32px
  border: 1px solid #BABFC4;
  border-radius: 4px;
  `;

const TextPassword = styled.div`
  width: 268px;
  height: 47px;
  font-size: 12px;
  color: #6a737c;
  margin: 4px 0px;
`;

const ReCaptchaContainer = styled.div`
  width: 268px;
  height: 156px;
  background-color: #F1F2F3;
  padding: 8px 0px 2px;
  margin: 6px 0px;
`;

const SignupDetails = styled.div`
  display: flex;
  flex-direction: row;
  font-size: 12px;
  width: 268px;
  height: 53.56px;
  margin: 6px 0px;s
`;

const InputCheckbox = styled.input`
  width: 13px;
  height: 13px;
`;

const TextCheckbox = styled.div`
  width: 233px;
  height: 53.56px;
`;

const QuestionDetailIcon = styled(RiQuestionFill)`
  color: #6A737C;
  width: 14px;
  height: 14px;
`;

const SignupButton = styled.button`
  width: 268px;
  height: 37px;
  margin: 2px 0px;
  padding: 10.4px;
  border: 1px solid #0A95FF;
  border-radius: 4px;
  background-color: #0A95FF;
  color: white;
  :hover {
    background-color: #0074CC;
  }
  cursor: pointer;
`;

const TextTerms = styled.div`
  width: 268px;
  height: 31.38px;
  margin: 32px 0px 0px;
  font-size: 12px;
  font-weight: 400;
  color: #6a737c;
`;

const ErrorMessage = styled.span`
  color: red;
  font-weight: 500;
  font-size: 12px;
`;

const EmailSignup = () => {
  const [name, setName] = useState('');
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');

  // error message
  const [nameMessage, setNameMessage] = useState('');
  const [emailMessage, setEmailMessage] = useState('');
  const [passwordMessage, setPasswordMessage] = useState('');

  // validation check
  const nameChangeHandler = (e) => {
    setName(e.target.value);

    if (e.target.value.length < 5 || e.target.value.length > 11) {
      setNameMessage('이름은 5글자 이상 10글자 이하여야 합니다.');
    } else {
      setNameMessage('');
    }
  };

  const emailChangeHandler = (e) => {
    const emailRegex = /([\w-.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/
    const currentEmail = e.target.value;
    setEmail(currentEmail);

    if (!emailRegex.test(currentEmail)) {
      setEmailMessage('올바른 이메일 형식이 아닙니다.');
    } else {
      setEmailMessage('');
    }
  };

  const passwordChangeHandler = (e) => {
    const passwordRegex = /^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{8,}$/
    const currentPassword = e.target.value;
    setPassword(currentPassword);

    if (!passwordRegex.test(currentPassword)) {
      setPasswordMessage('비밀번호는 영문자 + 숫자 조합으로 8글자 이상이어야 합니다.');
    } else {
      setPasswordMessage('');
    }
  }


  return (
    <EmailSignupForm>
      <InputInfo>
        <Label>Display name</Label>
        <Input type="text" onChange={nameChangeHandler} />
        {name.length > 0 && <ErrorMessage>{nameMessage}</ErrorMessage>}
      </InputInfo>
      <InputInfo>
        <Label>Email</Label>
        <Input type="email" size="30" maxLength="100" onChange={emailChangeHandler} />
        {email.length > 0 && <ErrorMessage>{emailMessage}</ErrorMessage>}
      </InputInfo>
      <InputPassword>
        <Label>Password</Label>
        <Input type="password" autoComplete="off" onChange={passwordChangeHandler} />
        {password.length > 0 && (
          <ErrorMessage>{passwordMessage}</ErrorMessage>
        )}
        <TextPassword>Passwords must contain at least eight characters, including at least 1 letter and 1 number.</TextPassword>
      </InputPassword>
      <ReCaptchaContainer>나는 로봇이 아니다🤖</ReCaptchaContainer>
      <SignupDetails>
        <InputCheckbox type="checkbox" />
        <TextCheckbox>Opt-in to receive occasional product updates, user research invitations, company announcements, and digests.</TextCheckbox>
        <QuestionDetailIcon />
      </SignupDetails>
      <SignupButton type="submit">Sign up</SignupButton>
      <TextTerms>By clicking “Sign up”, you agree to our <Link>terms of service</Link>, <Link>privacy policy</Link> and <Link>cookie policy</Link></TextTerms>
    </EmailSignupForm>
  );
};

export default EmailSignup;