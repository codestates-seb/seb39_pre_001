import styled from 'styled-components';
import google from '../static/google.png';
import { BsGithub } from 'react-icons/bs';
import { ImFacebook2 } from 'react-icons/im';

const GoogleLogo = styled.img.attrs({
  src: `${google}`,
})`
  width: 18px;
  height: 18px;
  margin-right: 5px;
`;

const GithubLogo = styled(BsGithub)`
  width: 18px;
  height: 18px;
  margin-right: 5px;
`;

const FacebookLogo = styled(ImFacebook2)`
  width: 18px;
  height: 18px;
  margin-right: 5px;
`;

const GoogleSignupButton = styled.button`
  display: flex;
  justify-content: center;
  align-items: center;
  width: 316px;
  height: 38px;
  padding: 10.4px;
  margin: 4px 0px 4px;
  border: 1px solid #d6d9dc;
  border-radius: 4px;
  background-color: #ffffff;
  font-weight: 500;
  :hover {
    background-color: #f8f9f9;
  }
  cursor: pointer;
`;

const GithubSignupButton = styled.button`
  display: flex;
  justify-content: center;
  align-items: center;
  width: 316px;
  height: 38px;
  padding: 10.4px;
  margin: 4px 0px 4px;
  border: 1px solid #2f3337;
  border-radius: 4px;
  background-color: #2f3337;
  color: white;
  :hover {
    background-color: #232629;
  }
  cursor: pointer;
`;

const FacebookSignupButton = styled.button`
  display: flex;
  justify-content: center;
  align-items: center;
  width: 316px;
  height: 38px;
  padding: 10.4px;
  margin: 4px 0px 4px;
  border: 1px solid #385499;
  border-radius: 4px;
  background-color: #385499;
  color: white;
  :hover {
    background-color: #314a86;
  }
  cursor: pointer;
`;

const SocialSignupWrapper = styled.div`
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  box-shadow: 0 0 8px rgba(0, 0, 0, 0.04);
  width: 316px;
  height: 137.39px;
  margin: -4px 0px 16px;
`;

const SocialSignup = () => {
  return (
    <SocialSignupWrapper>
      <GoogleSignupButton>
        <GoogleLogo />
        Sign up with Google
      </GoogleSignupButton>
      <GithubSignupButton>
        <GithubLogo />
        Sign up with GitHub
      </GithubSignupButton>
      <FacebookSignupButton>
        <FacebookLogo />
        Sign up with Facebook
      </FacebookSignupButton>
    </SocialSignupWrapper>
  );
};

export default SocialSignup;
