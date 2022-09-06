import { Link, useNavigate, useParams } from 'react-router-dom';
import styled from 'styled-components';
import Answer from '../components/Answer';
import Answers from '../components/Answers';
import userImg from '../static/user.png';
import { AiOutlineLike, AiOutlineDislike, AiFillLike, AiFillDislike } from 'react-icons/ai';
import { useState, useEffect } from 'react';
import axios from 'axios';
import { ReactMarkdown } from 'react-markdown/lib/react-markdown';

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
    > h1 {
      font-size: 27px;
      font-weight: 500;
      margin: 0 0 24px 0;
      width: 80%;
      max-width: 600px;
      overflow-wrap: break-word;
    }
  }
  > .info {
    display: flex;
    flex-wrap: wrap;
    padding-bottom: 8px;
    margin-bottom: 16px;
    border-bottom: 1px solid #e3e6e8;
    > div {
      margin: 0 16px 8px 0;
      font-size: 13px;
      > span {
        color: #6a737c;
      }
    }
  }
  > .body-container {
    display: flex;
    font-size: 15px;
    > .vote {
      display: flex;
      flex-direction: column;
      justify-content: flex-start;
      padding-right: 16px;
      gap: 10px;
      > div {
        display: flex;
        align-items: center;
        justify-content: space-evenly;
        width: 36px;
        font-size: 18px;
      }
    }
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
      > .tags {
        display: flex;
        flex-wrap: wrap;
        > div {
          font-size: 12px;
          color: #39739d;
          background-color: #e1ecf4;
          margin: 0 2px 2px 0;
          padding: 4.8px 6px;
          border-radius: 4px;
        }
      }
      > .author-container {
        display: flex;
        justify-content: space-between;
        margin: 16px 0;
        font-size: 13px;
        > .editor {
          > a {
            margin: 4px;
            text-decoration: none;
            color: #6a737c;
            :first-child {
              margin-left: 0px;
            }
          }
        }
        > .author-info {
          display: flex;
          padding: 6px;
          background-color: #d9eaf7;
          border-radius: 3px;
          width: 130px;
          > img {
            display: block;
            width: 32px;
          }
          > a {
            text-decoration: none;
            color: #0074cc;
            margin-left: 8px;
          }
        }
      }
    }
  }
`;

const StyledAskButton = styled.button`
  box-sizing: content-box;
  color: #ffffff;
  background-color: #0a95ff;
  box-shadow: inset 0 1px 0 0 hsl(0deg 0% 100% / 40%);
  padding: 10px;
  border: 1px solid transparent;
  border-radius: 3px;
  font-size: 13px;
  cursor: pointer;
  width: 80px;
  height: 15px;
`;

function QuestionAnswer({ token }) {
  const navigate = useNavigate();
  const { questionId } = useParams();
  const [data, setData] = useState({ user: { displayName: '' }, tags: [] });
  const {
    id = questionId,
    title,
    description,
    tags,
    user: { displayName },
    likes,
    dislikes,
    views,
    createdAt,
    answers,
  } = data;

  useEffect(() => {
    const dataFetch = async () => {
      await axios
        .get(`https://cors-jwy.herokuapp.com/http://119.71.184.39:8080/questions/${questionId}`)
        .then(function (response) {
          setData(response.data.data);
        })
        .catch(function (error) {
          console.log(error);
        });
    };
    dataFetch();
  }, [likes, dislikes, questionId]);

  // 질문 삭제
  const deleteHandler = async () => {
    if (window.confirm('정말 삭제하시겠습니까?')) {
      await axios
        .delete(`https://cors-jwy.herokuapp.com/http://119.71.184.39:8080/questions/${questionId}`, {
          headers: {
            'x-auth-token': token,
          },
        })
        .then(() => {
          alert('삭제되었습니다.');
        })
        .catch(function (error) {
          console.log(error);
        });
      await navigate('/questions');
    }
  };

  // 질문 좋아요
  const likeHandler = () => {
    axios
      .patch(
        `https://cors-jwy.herokuapp.com/http://119.71.184.39:8080/questions/${questionId}/like`,
        {},
        {
          headers: {
            'x-auth-token': token,
          },
        }
      )
      .then(window.location.reload())
      .catch(function (error) {
        console.log(error);
      });
  };

  // 질문 싫어요
  const dislikeHandler = () => {
    axios
      .patch(
        `https://cors-jwy.herokuapp.com/http://119.71.184.39:8080/questions/${questionId}/dislike`,
        {},
        {
          headers: {
            'x-auth-token': token,
          },
        }
      )
      .catch(function (error) {
        console.log(error);
      });
  };

  return (
    <StyledQuestionAnswer>
      <div className='title'>
        <h1>{title}</h1>
        <Link to='/questions/ask'>
          <StyledAskButton>Ask Question</StyledAskButton>
        </Link>
      </div>
      <div className='info'>
        <div>{createdAt}</div>
        <div>
          <span>Viewed</span> {views} times
        </div>
      </div>
      <div className='body-container'>
        <div className='vote'>
          <div onClick={likeHandler}>
            {likes} <AiOutlineLike />
          </div>
          <div onClick={dislikeHandler}>
            {dislikes} <AiOutlineDislike />{' '}
          </div>
        </div>
        <div className='body'>
          <p className='main'>
            <ReactMarkdown>{description}</ReactMarkdown>
          </p>
          <div className='tags'>
            {tags.map((tag, i) => (
              <div key={i}>{tag}</div>
            ))}
          </div>
          <div className='author-container'>
            <div className='editor'>
              <Link to={`/questions/${String(id)}/edit`}>edit</Link>
              <Link to={`/questions/` + id} onClick={deleteHandler}>
                delete
              </Link>
            </div>
            <div className='author-info'>
              <img src={userImg} alt='user-img'></img>
              <a href='/'>{displayName}</a>
            </div>
          </div>
        </div>
      </div>
      <Answers questionId={id} answers={answers} token={token} />
      <Answer questionId={id} token={token} />
    </StyledQuestionAnswer>
  );
}

export default QuestionAnswer;
