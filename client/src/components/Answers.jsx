import styled from 'styled-components';
import { Link } from 'react-router-dom';
import userImg from '../static/user.png';
import { AiOutlineLike, AiOutlineDislike, AiFillLike, AiFillDislike } from 'react-icons/ai';
import axios from 'axios';
import ReactMarkdown from 'react-markdown';

const StyledAnswers = styled.div`
  > .answers-container {
    padding-top: 10px;
    width: auto;
    > .answers-counter {
      font-size: 19px;
      font-weight: 400;
      margin: 0 0 8px 0;
    }
    > .answers-list {
      > .answer {
        display: flex;
        font-size: 15px;
        border-bottom: 1px solid #e3e6e8;
        padding: 16px 0;
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
          width: 100%;
          > .main {
            margin-top: 0;
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
    }
  }
`;

const Answers = ({ questionId, answers = [] }) => {
  // 답변 삭제
  const deleteHandler = async (answerId) => {
    if (window.confirm('정말 삭제하시겠습니까?')) {
      await axios
        .delete(`https://cors-jwy.herokuapp.com/http://119.71.184.39:8080/questions/${questionId}/answer/${answerId}`)
        .then(() => {
          alert('삭제되었습니다.');
        })
        .catch(function (error) {
          console.log(error);
        });
      await window.location.reload();
    }
  };

  return (
    <StyledAnswers>
      <div className='answers-container'>
        <h2 className='answers-counter'>{answers.length} Answers</h2>
        <div className='answers-list'>
          {answers.map((answer) => (
            <div className='answer' key={answer.answerId}>
              <div className='vote'>
                <div>
                  {answer.likes} <AiOutlineLike />
                </div>
                <div>
                  {answer.dislikes} <AiOutlineDislike />{' '}
                </div>
              </div>
              <div className='body'>
                <p className='main'>
                  <ReactMarkdown>{answer.content}</ReactMarkdown>
                </p>
                <div className='author-container'>
                  <div className='editor'>
                    <Link to={`/questions/${questionId}/answer/${answer.answerId}/edit`}>edit</Link>
                    <Link to={`/questions/` + questionId} onClick={() => deleteHandler(answer.answerId)}>
                      delete
                    </Link>
                  </div>
                  <div className='author-info'>
                    <img src={userImg} alt='user-img'></img>
                    <a href='/'>{answer.user.displayName}</a>
                  </div>
                </div>
              </div>
            </div>
          ))}
        </div>
      </div>
    </StyledAnswers>
  );
};

export default Answers;
