import styled from 'styled-components';
import google from '../resources/google.png';
import { BsGithub } from 'react-icons/bs';
import { ImFacebook2 } from 'react-icons/im';

const GoogleLogo = styled.img.attrs({
  src: `${google}`
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

const SocialLoginWrapper = styled.div`
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  box-shadow: 0 0 8px rgba(0, 0, 0, 0.04);
`;

const GoogleLoginButton = styled.button`
  display: flex;
  justify-content: center;
  align-items: center;
  width: 288px;
  height: 37px;
  padding: 10.4px;
  margin: 4px 0px 4px;
  border: 1px solid #D6D9DC;
  border-radius: 4px;
  background-color: #FFFFFF;
  font-weight: 500;
  :hover {
    background-color: #F8F9F9;
  }
  cursor: pointer;
`;

const GithubLoginButton = styled.button`
  display: flex;
  justify-content: center;
  align-items: center;
  width: 288px;
  height: 37px;
  padding: 10.4px;
  margin: 4px 0px 4px;
  border: 1px solid #2F3337;
  border-radius: 4px;
  background-color: #2F3337;
  color: white;
    :hover {
    background-color: #232629;
  }
  cursor: pointer;
`;

const FacebookLoginButton = styled.button`
  display: flex;
  justify-content: center;
  align-items: center;
  width: 288px;
  height: 37px;
  padding: 10.4px;
  margin: 4px 0px 4px;
  border: 1px solid #385499;
  border-radius: 4px;
  background-color: #385499;
  color: white;
      :hover {
    background-color: #314A86;
  }
  cursor: pointer;
`;

const SocialLogin = () => {

  return (
    <SocialLoginWrapper>
      <GoogleLoginButton><GoogleLogo />Log in with Google</GoogleLoginButton>
      <GithubLoginButton><GithubLogo />Log in with GitHub</GithubLoginButton>
      <FacebookLoginButton><FacebookLogo />Log in with Facebook</FacebookLoginButton>
    </SocialLoginWrapper>
  );
};

export default SocialLogin;