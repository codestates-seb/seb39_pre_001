import { Link } from 'react-router-dom';
import styled from 'styled-components';
import TextEditor from './TextEditor';

const AnswerWrapper = styled.div`
  background-color: #ffffff;
  display: flex;
  flex-direction: column;
`;

const Header = styled.h2`
  font-size: 19px;
  font-weight: 400;
  margin: 0px 0px 19px;
  padding: 20px 0px 0px;
`;

const AnswerSubmitButton = styled.button`
  /* background-color: #0a95ff;
  color: #fff;
  font-size: 13px;
  font-weight: 500;
  padding: 10.4px;
  margin: 20px 2px;
  border: none;
  border-radius: 4px;
  width: 128.91px;
  cursor: pointer; */
  color: #ffffff;
  font-size: 13px;
  background-color: #0a95ff;
  box-shadow: inset 0 1px 0 0 hsl(0deg 0% 100% / 40%);
  padding: 10px;
  margin: 25px 0;
  border: 1px solid transparent;
  border-radius: 3px;
  width: 128px;
  cursor: pointer;
  :hover {
    background-color: #0074cc;
  }
`;

const BottomText = styled.div`
  color: #232629;
  font-size: 17px;
  margin: 15px 0px 17px;
  line-height: 1.6;
`;

const NavLink = styled(Link)`
  font-weight: 500;
  text-decoration: none;
  color: #0074cc;
  cursor: pointer;
  :hover {
    color: #1e9dfe;
  }
`;

const TagLink = styled.a`
  font-size: 12px;
  color: #39739d;
  background-color: #e1ecf4;
  padding: 4.8px 6px;
  margin: 2px 2px 2px 0px;
  width: 51.15px;
  border-radius: 4px;
  cursor: pointer;
  :hover {
    background-color: #d0e3f1;
  }
`;

const Answer = () => {
  return (
    <AnswerWrapper>
      <Header>Your Answer</Header>
      <TextEditor />
      <AnswerSubmitButton>Post Your Answer</AnswerSubmitButton>
      {/* Link -> 질문 작성 페이지로 이동 */}
      <BottomText>
        Not the answer you're looking for? Browse other questions tagged <TagLink>macos</TagLink>
        <TagLink>macos-catalina</TagLink> <TagLink>facetime</TagLink> or{' '}
        <NavLink to='/questions/ask'>ask your own question</NavLink>.
      </BottomText>
    </AnswerWrapper>
  );
};

export default Answer;
