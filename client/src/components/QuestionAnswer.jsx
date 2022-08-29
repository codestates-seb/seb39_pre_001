import { useParams } from 'react-router-dom';
import styled from 'styled-components';
import question from '../data/dummy';
import userImg from '../static/user.png';

const StyledQuestionAnswer = styled.div`
  font-size: 16px;
  margin: auto;
  padding: 24px;
  width: 80%;
  max-width: 750px;
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
        width: 36px;
        font-size: 18px;
      }
    }
    > .body {
      > .main {
        margin-top: 0;
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

function QuestionAnswer() {
  const { questionId } = useParams();
  console.log(typeof questionId);
  const { id, title, body, tags, author, date, like, dislike, view } = question.filter(
    (e) => String(e.id) === questionId
  )[0];

  return (
    <StyledQuestionAnswer>
      <div className='title'>
        <h1>{title}</h1>
        <StyledAskButton>Ask Question</StyledAskButton>
      </div>
      <div className='info'>
        <div>{date}</div>
        <div>
          <span>Viewed</span> {view} times
        </div>
      </div>
      <div className='body-container'>
        <div className='vote'>
          <div>{like} 👍</div>
          <div>{dislike} 👎</div>
        </div>
        <div className='body'>
          <p className='main'>{body}</p>
          <div className='tags'>
            {tags.map((tag, i) => (
              <div key={i}>{tag}</div>
            ))}
          </div>
          <div className='author-container'>
            <div className='editor'>
              <a href='/'>edit</a>
              <a href='/'>delete</a>
            </div>
            <div className='author-info'>
              <img src={userImg} alt='user-img'></img>
              <a href='/'>{author}</a>
            </div>
          </div>
        </div>
      </div>
    </StyledQuestionAnswer>
  );
}

export default QuestionAnswer;
