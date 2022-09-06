import styled from 'styled-components';
import Summary from '../components/Summary';
import Pagination from 'react-js-pagination';
import { useEffect, useState } from 'react';
import { Link } from 'react-router-dom';
import Dropdown from '../components/Dropdown';
import axios from 'axios';
import SummaryLoading from '../components/SummaryLoading';

// 전체 questions page
const QuestionsPageWrapper = styled.div`
  display: flex;
  flex-direction: row;
  justify-content: center;
  max-width: 1000px;
  margin: auto;
  min-height: 70vh;
  > .sidebar {
    flex: 0 0 164px;
    padding-bottom: 50px;
    > nav {
      width: 164px;
      position: sticky;
      top: 47px;
    }
  }
`;

const StyledQuestions = styled.div`
  font-size: 16px;
  padding: 24px;
  width: 80%;
  flex: 1 1 80%;
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
        cursor: pointer;
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
    .btn-pagination {
      display: flex;
      flex-direction: row;
      align-items: center;
      button {
        display: flex;
        justify-content: center;
        align-items: center;
        width: 31.91px;
        height: 27px;
        margin: 0 2px;
        padding: 0 8px;
        color: #3b4045;
        background-color: #ffffff;
        border: 1px solid #babfc3;
        border-radius: 4px;
        cursor: pointer;
        :hover {
          background-color: #d6d9dc;
        }

        &.btn-active {
          color: #ffffff;
          background-color: #f48225;
          cursor: default;
        }
      }
      p {
        display: flex;
        justify-content: center;
        align-items: center;
        height: 27px;
        font-size: 13px;
        margin: 0 2px;
        padding: 0 8px;
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

function Questions() {
  const [data, setData] = useState([]);
  const [loader] = useState([1, 2, 3, 4, 5]);
  const [items, setItems] = useState(5);
  const [page, setPage] = useState(1);
  const [selected, setSelected] = useState('newest');
  const [pageInfo, setPageInfo] = useState({ totalElements: 0 });

  // pagination 버튼 클릭 시 state 이용한 버튼 색상 변경
  const questionCount = [5, 10, 15];
  const [btnActive, setBtnActive] = useState(5);
  const toggleActive = (e) => {
    setBtnActive(Number(e.target.value));
  };

  const handlePageChange = (page) => {
    setPage(page);
  };

  const itemChange = (e) => {
    setItems(Number(e.target.value));
    // console.log(e.target.value);
  };
  const sortHandler = (e) => {
    switch (e.target.value) {
      case 'newest':
        setSelected('newest');
        setData([...data]);
        break;
      case 'like':
        setSelected('like');
        const tempData = [...data];
        const sortedLike = tempData.sort((a, b) => b.like - a.like);
        setData([...sortedLike]);
        break;
      case 'dislike':
        setSelected('dislike');
        const tempData2 = [...data];
        const sortedDislike = tempData2.sort((a, b) => b.dislike - a.dislike);
        setData([...sortedDislike]);
        break;
      default:
        break;
    }
  };

  // 질문 목록 받아오기
  useEffect(() => {
    const dataFetch = async () => {
      await axios
        .get(`https://cors-jwy.herokuapp.com/http://119.71.184.39:8080/questions?page=${page}&size=${items}`)
        .then(function (response) {
          setData(response.data.data);
          setPageInfo(response.data.pageInfo);
        })
        .catch(function (error) {
          console.log(error);
        });
    };
    dataFetch();
  }, [page, items]);

  return (
    <QuestionsPageWrapper>
      <div className='sidebar'>
        <Dropdown />
      </div>
      <StyledQuestions>
        <div className='title'>
          <h1>All Questions</h1>
          <Link to='/questions/ask'>
            <StyledAskButton>Ask Question</StyledAskButton>
          </Link>
        </div>
        <div className='sort'>
          <div className='questions-counter'>{pageInfo.totalElements} questions</div>
          <div className='sort-container' onClick={sortHandler}>
            <button className={selected === 'newest' ? 'is-selected' : null} value={'newest'}>
              최신순
            </button>
            <button className={selected === 'like' ? 'is-selected' : null} value={'like'}>
              좋아요순
            </button>
            <button className={selected === 'dislike' ? 'is-selected' : null} value={'dislike'}>
              싫어요순
            </button>
          </div>
        </div>
        <div className='questions-container'>
          {data.length !== 0
            ? data.map((e) => <Summary key={e.questionId} question={e} />)
            : loader.map((e, i) => <SummaryLoading key={i} />)}
        </div>
        <div className='pagination-container'>
          <Pagination
            activePage={page}
            itemsCountPerPage={items}
            totalItemsCount={pageInfo.totalElements}
            pageRangeDisplayed={5}
            onChange={handlePageChange}></Pagination>
          <div className='btn-pagination' onClick={itemChange}>
            {questionCount.map((el, idx) => {
              return (
                <button key={idx} value={el} className={el === btnActive ? 'btn-active' : ''} onClick={toggleActive}>
                  {el}
                </button>
              );
            })}
            <p>per page</p>
          </div>
        </div>
      </StyledQuestions>
    </QuestionsPageWrapper>
  );
}

export default Questions;
