import styled from 'styled-components';
import Summary from './Summary';
import question from '../data/dummy';

const StyledQuestions = styled.div`
  font-size: 16px;
  margin: auto;
  padding: 24px;
  width: 750px;
  border-left: 1px solid #666;
  border-right: 1px solid #666;
  > .title {
    display: flex;
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
        <span>{question.length} questions</span>
        <button>최신순</button>
        <button>좋아요순</button>
        <button>싫어요순</button>
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
