import { useState } from 'react';
import styled from 'styled-components';
import '@toast-ui/editor/dist/toastui-editor.css';
import TextEditor from '../components/TextEditor';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';

const StyledQuestionCreator = styled.div`
  background-color: #f1f2f3;
  padding: 24px;
  > .creator-container {
    margin: auto;
    max-width: 1000px;
    > h1 {
      margin-top: 0;
      font-weight: 400;
      font-size: 27px;
    }
    > .form-container {
      display: flex;
      flex-direction: column;
      background-color: #fff;
      max-width: 1000px;
      box-shadow: 0 1px 3px hsla(0, 0%, 0%, 0.06), 0 2px 6px hsla(0, 0%, 0%, 0.06), 0 3px 8px hsla(0, 0%, 0%, 0.09);
      padding: 16px;
      border: 1px solid #d6d9dc;
      border-radius: 3px;
      > h3 {
        font-size: 13px;
        margin: 20px 0 5px 0;
        :first-child {
          margin-top: 10px;
        }
      }
      > p {
        font-size: 12px;
        margin: 0;
        margin-bottom: 4px;
      }
      > input {
        border: 1px solid #babfc4;
        border-radius: 3px;
        padding: 8px 9px;
      }
      > .tag-maker {
        display: flex;
        box-sizing: border-box;
        border: 1px solid #babfc4;
        border-radius: 3px;
        padding: 4px 5px;
        width: 100%;
        > span {
          display: flex;
          font-size: 12px;
          color: #39739d;
          margin: 2px;
          padding: 4px;
          padding-left: 8px;
          background-color: #e1ecf4;
          border-radius: 3px;
<<<<<<< Updated upstream
=======
          white-space: nowrap;
>>>>>>> Stashed changes
          > button {
            font-size: 12px;
            color: #39739d;
            font-weight: 700;
            border: none;
            background-color: transparent;
            cursor: pointer;
          }
        }
        > input {
          box-sizing: border-box;
          width: 100%;
          border: none;
          margin-left: 4px;
        }
      }
    }
  }
`;

const StyledButton = styled.button`
  box-sizing: content-box;
  color: #ffffff;
  background-color: #0a95ff;
  box-shadow: inset 0 1px 0 0 hsl(0deg 0% 100% / 40%);
  margin: 40px 0 16px 0;
  padding: 10px;
  border: 1px solid transparent;
  border-radius: 3px;
  font-size: 13px;
  cursor: pointer;
`;

function QuestionCreator() {
  const [title, setTitle] = useState('');
  const [content, setContent] = useState('');
  const [tags, setTags] = useState([]);
  const navigate = useNavigate();

  const tagInputHandler = (e) => {
    if (e.target.value === ' ') {
      e.target.value = '';
      return;
    }
    if (e.target.value[e.target.value.length - 1] === ' ') {
<<<<<<< Updated upstream
      setTags([...tags, e.target.value.slice(0, -1)]);
=======
      if (!tags.includes(e.target.value.slice(0, -1))) {
        setTags([...tags, e.target.value.slice(0, -1)]);
      }
>>>>>>> Stashed changes
      e.target.value = '';
      return;
    }
  };

  const tagDeleteHandler = (e, idx) => {
    e.preventDefault();
    const filteredTags = tags.filter((e, i) => !(i === idx));
    setTags(filteredTags);
  };

  const titleHandler = (e) => {
    setTitle(e.target.value);
  };

  const submitHandler = async () => {
    const data = {
      title: title,
      description: content,
      tags: tags,
<<<<<<< Updated upstream
      userId: 1,
    };
    await axios
      .post('https://cors-jwy.herokuapp.com/http://119.71.184.39:8080/questions/ask', data)
      .catch(function (error) {
        console.log(error);
      });
    await navigate('/questions');
=======
      userId: 4,
    };
    if (!title) {
      alert('제목을 입력하세요.');
    } else if (content.length < 10) {
      alert('본문을 10자 이상 입력하세요.');
    } else if (tags.length > 5) {
      alert('태그를 5개 이하로 입력하세요.');
    } else {
      await axios
        .post('https://cors-jwy.herokuapp.com/http://119.71.184.39:8080/questions/ask', data)
        .catch(function (error) {
          console.log(error);
        });
      await navigate('/questions');
    }
    return;
>>>>>>> Stashed changes
  };

  return (
    <StyledQuestionCreator>
      <div className='creator-container'>
        <h1>Ask a public question</h1>
        <form className='form-container'>
          <h3>Title</h3>
          <p>Be specific and imagine you're asking a question to another person</p>
          <input
            type='text'
            name='title'
            placeholder='e.g. Is there an R function for finding the index of an element in a vector?'
            autoComplete='off'
            onChange={titleHandler}
          />
          <h3>Body</h3>
          <p>Include all the information someone would need to answer your question</p>
          <TextEditor content={content} setContent={setContent} />
          <h3>Tags</h3>
          <p>Add up to 5 tags to describe what your question is about</p>
          <div className='tag-maker'>
            {tags.map((tag, i) => (
              <span key={i}>
                {tag} <button onClick={(e) => tagDeleteHandler(e, i)}>X</button>
              </span>
            ))}
            <input
              type='text'
              name='tags'
              placeholder='e.g. (ruby-on-rails .net sql-server)'
              autoComplete='off'
              onChange={tagInputHandler}
            />
          </div>
        </form>
        <StyledButton onClick={submitHandler}>Review your question</StyledButton>
      </div>
    </StyledQuestionCreator>
  );
}

export default QuestionCreator;
