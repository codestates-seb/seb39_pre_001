import { Link } from 'react-router-dom';
import styled from 'styled-components';
import logo from '../static/stack-overflow.png';
import SocialLogin from '../components/SocialLogin';
import EmailLogin from '../components/EmailLogin';
import { RiShareBoxLine } from 'react-icons/ri';
import axios from 'axios';

const LoginContainer = styled.div`
<<<<<<< Updated upstream
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  height: 100vh;
  background-color: #f1f2f3;
`;

const StackOverflowLogo = styled.img.attrs({
  src: `${logo}`,
=======
	display: flex;
	flex-direction: column;
	justify-content: center;
	align-items: center;
	height: 100vh;
	background-color: #f1f2f3;
`;

const StackOverflowLogo = styled.img.attrs({
	src: `${logo}`,
>>>>>>> Stashed changes
})`
	width: 32px;
	height: 37px;
	margin: 20px;
`;

const BottomText = styled.div`
	display: flex;
	flex-direction: column;
	justify-content: space-evenly;
	align-items: center;
	width: 288px;
	height: 78px;
	font-size: 13px;
	padding-top: 16px;
`;

const NavLink = styled(Link)`
<<<<<<< Updated upstream
  font-weight: 500;
  text-decoration: none;
  color: #0074cc;
  cursor: pointer;
  :hover {
    color: #1e9dfe;
  }
`;

const Login = () => {
  return (
    <LoginContainer>
      <StackOverflowLogo />
      <SocialLogin />
      <EmailLogin />
      <BottomText>
        <div>
          Don't have an account? <NavLink to='/users/join'>Sign up</NavLink>
        </div>
        <div>
          Are you an employer? Sign up on Talent
          <RiShareBoxLine />
        </div>
      </BottomText>
    </LoginContainer>
  );
=======
	font-weight: 500;
	text-decoration: none;
	color: #0074cc;
	cursor: pointer;
	:hover {
		color: #1e9dfe;
	}
`;

const Login = ({ setIsLogin }) => {
	return (
		<LoginContainer>
			<StackOverflowLogo />
			<SocialLogin />
			<EmailLogin setIsLogin={setIsLogin} />
			<BottomText>
				<div>
					Don't have an account? <NavLink to="/users/join">Sign up</NavLink>
				</div>
				<div>
					Are you an employer? Sign up on Talent
					<RiShareBoxLine />
				</div>
			</BottomText>
		</LoginContainer>
	);
>>>>>>> Stashed changes
};

export default Login;
