import styled from 'styled-components';
import Summary from './Summary';
import question from '../data/dummy';

const StyledQuestions = styled.div`
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
    justify-content: space-between;
    > h1 {
      font-size: 27px;
      font-weight: 500;
      margin: 0 0 24px 0;
    }
    > button {
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
    }
  }
  > .sort {
    display: flex;
    align-items: center;
    justify-content: space-between;
    margin-bottom: 12px;
    > .questions-counter {
      font-size: 17px;
    }
    > .sort-container {
      > button {
        font-size: 12px;
        color: #6a737c;
        border: 1px solid #838c95;
        padding: 10px;
        background-color: #ffffff;
        :first-child {
          border-radius: 3px;
          border-top-right-radius: 0;
          border-bottom-right-radius: 0;
        }
        :not(:last-child) {
          margin-right: -1px;
        }
        :last-child {
          border-radius: 3px;
          border-top-left-radius: 0;
          border-bottom-left-radius: 0;
        }
        &.is-selected {
          background-color: #e3e6e8;
          color: #3b4045;
        }
      }
    }
  }
`;

function Questions() {
  return (
    <StyledQuestions>
      <div className='title'>
        <h1>All Questions</h1>
        <button>Ask Question</button>
      </div>
      <div className='sort'>
        <div className='questions-counter'>{question.length} questions</div>
        <div className='sort-container'>
          <button className='is-selected'>최신순</button>
          <button>좋아요순</button>
          <button>싫어요순</button>
        </div>
      </div>
      <div className='questions-container'>
        {question.map((e) => (
          <Summary key={e.id} question={e}></Summary>
        ))}
      </div>
    </StyledQuestions>
  );
}

export default Questions;
