import styled from 'styled-components';
import Summary from './Summary';
import question from '../data/dummy';
import Pagination from 'react-js-pagination';
import { useState, useEffect } from 'react';

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
  > .pagination-container {
    display: flex;
    flex-wrap: wrap-reverse;
    row-gap: 30px;
    justify-content: space-between;
    margin: 20px 0;
    > .pagination {
      display: flex;
      justify-content: center;
      align-items: center;
      list-style: none;
      padding: 0;
      margin: 0;
      > li {
        display: flex;
        align-items: center;
        height: 23px;
        margin: 0 2px;
        padding: 0 8px;
        border-radius: 3px;
        border: 1px solid #d6d9dc;
        font-size: 13px;
        color: #3b4045;
        cursor: pointer;
        :hover {
          background-color: #e3e6e8;
        }
        > a {
          margin-top: 2px;
          text-decoration: none;
          color: #3b4045;
        }
        &.active {
          background-color: #f48225;
          cursor: default;
          > a {
            color: white;
            cursor: auto;
          }
        }
      }
    }
    select {
      margin-left: auto;
      border: 1px solid #d6d9dc;
      border-radius: 3px;
      font-size: 13px;
      color: #3b4045;
    }
  }
`;

function Questions() {
  const [data, setData] = useState(question);
  const [page, setPage] = useState(1);
  const [items, setItems] = useState(5);

  const handlePageChange = (page) => {
    setPage(page);
  };
  const itemChange = (e) => {
    setItems(Number(e.target.value));
  };

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
        {data.slice(items * (page - 1), items * (page - 1) + items).map((e) => (
          <Summary key={e.id} question={e}></Summary>
        ))}
      </div>
      <div className='pagination-container'>
        <Pagination
          activePage={page}
          itemsCountPerPage={items}
          totalItemsCount={data.length}
          pageRangeDisplayed={5}
          onChange={handlePageChange}></Pagination>
        <select name='items' onChange={itemChange}>
          <option value='5'>5개</option>
          <option value='10'>10개</option>
          <option value='15'>15개</option>
          <option value='20'>20개</option>
        </select>
      </div>
    </StyledQuestions>
  );
}

export default Questions;
