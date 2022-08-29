import { Link } from 'react-router-dom';
import styled from 'styled-components';
import TextEditor from '../components/TextEditor';

const AnswerWrapper = styled.div`
  background-color: #FFFFFF;
  width: 100%;
  height: 100vh;
  display: flex;
  flex-direction: column;
  padding: 24px;
`;

const Header = styled.h2`
  /* font-size: 19px; */
  font-weight: 400;
  margin: 0px 0px 19px;
  padding: 20px 0px 0px;
`;

const AnswerSubmitButton = styled.button`
  background-color: #0a95ff;
  color: #fff;
  font-size: 13px;
  font-weight: 500;
  padding: 10.4px;
  margin: 20px 2px;
  border: none;
  border-radius: 4px;
  width: 128.91px;
  cursor: pointer;
  :hover {
    background-color: #0074CC;
  }
`;

const BottomText = styled.div`
  color: #232629;
  font-size: 17px;
  width: 727px;
  margin: 15px 0px 17px;
  line-height: 1.6;
`;

const NavLink = styled(Link)`
  font-weight: 500;
  text-decoration: none;
  color: #0074cc;
  cursor: pointer;
  :hover {
    color: #1E9DFE;
  }
`;

const TagLink = styled.a`
  font-size: 12px;
  color: #39739d;
  background-color: #E1ECF4;
  padding: 4.8px 6px;
  margin: 2px 2px 2px 0px;
  width: 51.15px;
  border-radius: 4px;
  cursor: pointer;
  :hover {
    background-color: #D0E3F1;
  }
`;

const Answer = () => {

  return (
    <AnswerWrapper>
      <Header>Your Answer</Header>
      <TextEditor />
      <AnswerSubmitButton>Post Your Answer</AnswerSubmitButton>
      {/* Link -> 질문 작성 페이지로 이동 */}
      <BottomText>Not the answer you're looking for? Browse other questions tagged <TagLink>macos</TagLink>
        <TagLink>macos-catalina</TagLink> <TagLink>facetime</TagLink> or <NavLink to="/questions">ask your own question</NavLink>.</BottomText>
    </AnswerWrapper>
  );
};

export default Answer;