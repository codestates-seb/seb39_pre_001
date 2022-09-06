import { Link, useNavigate, useParams } from 'react-router-dom';
import styled from 'styled-components';
import Answer from '../components/Answer';
import question from '../data/dummy';
import userImg from '../static/user.png';
import { AiOutlineLike, AiOutlineDislike, AiFillLike, AiFillDislike } from 'react-icons/ai';
import { useState, useEffect } from 'react';
import axios from 'axios';
import { ReactMarkdown } from 'react-markdown/lib/react-markdown';
import TextEditor from '../components/TextEditor';

const StyledQuestionAnswer = styled.div`
  font-size: 16px;
  margin: auto;
  padding: 24px;
  width: 80%;
  max-width: 1000px;
  border-left: 1px solid #d6d9dc;
  border-right: 1px solid #d6d9dc;
  border-bottom: 1px solid #d6d9dc;
  > .title {
    display: flex;
    flex-wrap: wrap-reverse;
    justify-content: space-between;
    align-items: flex-end;
    > h2 {
      font-size: 17px;
      font-weight: 400;
      margin: 0 0 24px 0;
      width: 80%;
      max-width: 600px;
      overflow-wrap: break-word;
      > a {
        text-decoration: none;
      }
    }
  }
  > .body-container {
    display: flex;
    font-size: 15px;
    > .body {
      width: calc(100% - 70px);
      > .main {
        margin-top: 0;
        overflow-wrap: break-word;
        > p {
          :first-child {
            margin-top: 0;
          }
        }
      }
    }
  }
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

const Header = styled.h2`
  font-size: 19px;
  font-weight: 400;
  margin: 0px 0px 19px;
  padding: 20px 0px 0px;
`;

function AnswerEdit({ token }) {
  const navigate = useNavigate();
  const { questionId, answerId } = useParams();
  const [content, setContent] = useState('');
  const [data, setData] = useState({ user: { displayName: '' }, tags: [], answers: [] });
  const { title, description } = data;

  useEffect(() => {
    const dataFetch = async () => {
      await axios
        .get(`https://cors-jwy.herokuapp.com/http://119.71.184.39:8080/questions/${questionId}`)
        .then(function (response) {
          setData(response.data.data);
          setContent(response.data.data.answers.filter((e) => e.answerId === +answerId)[0].content);
        })
        .catch(function (error) {
          console.log(error);
        });
    };
    dataFetch();
  }, []);

  // 답변 수정 등록
  const submitHandler = async () => {
    const data = {
      answerId,
      content,
    };
    await axios
      .patch(
        `https://cors-jwy.herokuapp.com/http://119.71.184.39:8080/questions/${questionId}/answer/${answerId}`,
        data,
        {
          headers: {
            'x-auth-token': token,
          },
        }
      )
      .catch(function (error) {
        console.log(error);
      });
    await navigate(`/questions/${questionId}`);
  };

  return (
    <StyledQuestionAnswer>
      <div className='title'>
        <h2>
          <Link to={`/questions/${questionId}`}>{title}</Link>
        </h2>
      </div>
      <div className='body-container'>
        <div className='body'>
          <p className='main'>
            <ReactMarkdown>{description}</ReactMarkdown>
          </p>
        </div>
      </div>
      <Header>Answer</Header>
      <TextEditor content={content} setContent={setContent} />
      <AnswerSubmitButton onClick={submitHandler}>Post Your Answer</AnswerSubmitButton>
    </StyledQuestionAnswer>
  );
}

export default AnswerEdit;
