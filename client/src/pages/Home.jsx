import { useEffect, useState, useRef } from 'react';
import { Link } from 'react-router-dom';
import styled from 'styled-components';
import glass from '../static/glass.png';
import locker from '../static/locker.png';
import { FaBuilding } from 'react-icons/fa';
import { IoPeople } from 'react-icons/io5';

const StyledHome = styled.div`
  font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans',
    'Helvetica Neue', sans-serif;
  padding: 48px;
  margin: auto;
  background-color: #f8f9f9;
  > .home-container {
    padding: 32px;
    background: linear-gradient(180deg, #232629 0%, #525960 130%);
    border-radius: 7px;
    > .bubbles {
      display: flex;
      justify-content: center;
      margin: auto;
      max-width: 950px;
      > .bubble {
        position: relative;
        flex-basis: 50%;
        text-align: center;
        font-size: 13px;
        color: #232629;
        margin: 16px;
        padding: 24px;
        border-top-right-radius: 7px;
        border-top-left-radius: 7px;
        > h2 {
          font-weight: 300;
          line-height: 1.3;
          margin: 0 1.4rem;
          margin-bottom: 19px;
        }
        > img {
          width: 50px;
          margin-bottom: 11px;
        }
        ::after {
          clip-path: polygon(18px 0, 32px 0, 0 40px, 0 38px, 0 0, 18px 0);
          width: 32px;
          height: 32px;
          position: absolute;
          top: 99%;
          content: '';
          border-radius: 0 5px 0;
          display: block;
        }
      }
      > .left {
        background-color: #fee3cd;
        border-bottom-left-radius: 7px;
        button {
          background-color: #f2740d;
          border: none;
          border-radius: 3px;
          padding: 12px 32px;
          color: #fff;
          cursor: pointer;
          :hover {
            background-color: #da680b;
          }
        }
        > div {
          margin-top: 12px;
          > a {
            color: #3b4045;
            :hover {
              color: #da680b;
            }
          }
        }
        ::after {
          background-color: #fee3cd;
          transform: scaleX(-1);
          right: 0;
          left: auto;
        }
      }
      > .right {
        background-color: #cde9fe;
        border-bottom-right-radius: 7px;
        > .get-started {
          display: flex;
          justify-content: center;
          align-items: center;
          max-width: 210px;
          margin: auto;
          margin-bottom: 12px;
          > .line {
            flex-basis: 33.3333333%;
            border-top: 1px solid #6bbbf7;
          }
          > .text {
            padding: 0 12px;
            font-size: 13px;
            flex-shrink: 0;
          }
        }
        > .button-container {
          display: flex;
          justify-content: center;
          margin: auto;
          > button {
            display: flex;
            align-items: center;
            gap: 3px;
            background-color: #0a95ff;
            border: none;
            border-radius: 3px;
            padding: 12px;
            color: #fff;
            cursor: pointer;
            :nth-child(2) {
              margin-left: 8px;
            }
          }
        }
        ::after {
          background: #cde9fe;
          left: 0;
        }
      }
    }
    > .title {
      color: #fff;
      font-weight: 700;
      font-size: 55px;
      line-height: 1.3;
      text-align: center;
      margin: 64px 0;
      z-index: 30;
      overflow: hidden;
      position: relative;
      > .jobs-container {
        position: relative;
        transition: width 0.2s, height 0.2s;
        display: inline-flex;
        white-space: nowrap;
        text-align: center;
        vertical-align: bottom;
        flex-direction: column;
        height: 72px;
        > span {
          color: #f2740d;
          display: block;
          position: absolute;
          top: 100%;
          left: auto;
          right: auto;
          :first-child {
            opacity: 1;
          }
        }
        > .slide-in {
          animation: slideIn 1s forwards;
          transform: translate3d(0, -100%, 0);
        }
        > .slide-out {
          animation: slideOut 1s forwards;
          transform: translate3d(0, -100%, 0);
        }
        @keyframes slideIn {
          0% {
            opacity: 0;
            transform: translate3d(0, -150%, 0);
          }
          100% {
            opacity: 1;
            transform: translate3d(0, -100%, 0);
          }
        }
        @keyframes slideOut {
          0% {
            opacity: 1;
            transform: translate3d(0, -100%, 0);
          }
          30% {
            opacity: 0;
          }
          100% {
            opacity: 0;
            transform: translate3d(0, -50%, 0);
          }
        }
      }
    }
    > .bar {
      height: 8px;
      width: 64px;
      margin: 0 auto;
      background-color: #6a737c;
      border-radius: 1000px;
    }
    > .statistics {
      display: flex;
      justify-content: center;
      align-items: center;
      max-width: 920px;
      margin: 64px auto;
      > .item {
        text-align: center;
        flex-basis: 25%;
        > .sub-title {
          color: #fff;
          font-weight: 600;
          font-size: 21px;
          margin-bottom: 4px;
        }
        > .content {
          font-size: 14px;
          color: #9fa6ad;
          font-weight: 300;
          line-height: 1.4;
          padding: 0 24px;
        }
      }
    }
    > a {
      display: flex;
      justify-content: center;
      text-decoration: none;
      > .questions {
        color: #ffffff;
        font-size: 13px;
        background-color: #f2740d;
        box-shadow: inset 0 1px 0 0 hsl(0deg 0% 100% / 40%);
        padding: 10px;
        border: 1px solid transparent;
        border-radius: 3px;
        cursor: pointer;
      }
    }
  }
`;

const Home = () => {
  const jobs = ['developer', 'data scientist', 'system admin', 'mobile developer', 'game developer'];
  const [index, setIndex] = useState(0);

  // 커스텀 훅 -> 텍스트 변경을 위한 반복 실행 함수
  function useInterval(callback, delay) {
    const savedCallback = useRef(); // 최근에 들어온 callback을 저장할 ref를 하나 만든다.

    useEffect(() => {
      savedCallback.current = callback; // callback이 바뀔 때마다 ref를 업데이트 해준다.
    }, [callback]);

    useEffect(() => {
      function tick() {
        savedCallback.current(); // tick이 실행되면 callback 함수를 실행시킨다.
      }
      if (delay !== null) {
        // 만약 delay가 null이 아니라면
        let id = setInterval(tick, delay); // delay에 맞추어 interval을 새로 실행시킨다.
        return () => clearInterval(id); // unmount될 때 clearInterval을 해준다.
      }
    }, [delay]); // delay가 바뀔 때마다 새로 실행된다.
  }

  // 커스텀훅 실행
  useInterval(() => {
    index === jobs.length - 1 ? setIndex(0) : setIndex(index + 1);
  }, 2000);

  const widthChanger = (i) => {
    if (i === 0) {
      return { width: '265px' };
    } else if (i === 1) {
      return { width: '355px' };
    } else if (i === 2) {
      return { width: '367px' };
    } else if (i === 3) {
      return { width: '447px' };
    } else if (i === 4) {
      return { width: '418px' };
    }
  };

  return (
    <StyledHome>
      <div className='home-container'>
        <div className='bubbles'>
          <div className='bubble left'>
            <img src={glass} alt='glass'></img>
            <h2>Find the best answer to your technical question, help others answer theirs</h2>
            <Link to='/users/join'>
              <button>Join the community</button>
            </Link>
            <div>
              or <Link to='/questions'>search content</Link>
            </div>
          </div>
          <div className='bubble right'>
            <img src={locker} alt='locker'></img>
            <h2>Want a secure, private space for your technical knowledge?</h2>
            <div className='get-started'>
              <span className='line'></span>
              <span className='text'>Get started</span>
              <span className='line'></span>
            </div>
            <div className='button-container'>
              <button>
                For large organizations <FaBuilding />
              </button>
              <button>
                For small teams <IoPeople />
              </button>
            </div>
          </div>
        </div>
        <h1 className='title'>
          Every{' '}
          <span className='jobs-container' style={widthChanger(index)}>
            {jobs.map((job, i) => {
              return (
                <span key={i} className={index === i ? 'slide-in' : 'slide-in slide-out'}>
                  {job}
                </span>
              );
            })}
          </span>
          has a
          <br />
          tab open to Stack Overflow
        </h1>
        <div className='bar'></div>
        <div className='statistics'>
          <div className='item'>
            <div className='sub-title'>100+ million</div>
            <div className='content'>{'monthly visitors to Stack Overflow & Stack Exchange'}</div>
          </div>
          <div className='item'>
            <div className='sub-title'>45.1+ billion</div>
            <div className='content'>Times a developer got help since 2008</div>
          </div>
          <div className='item'>
            <div className='sub-title'>179% ROI</div>
            <div className='content'>from companies using Stack Overflow for Teams</div>
          </div>
          <div className='item'>
            <div className='sub-title'>5,000+</div>
            <div className='content'>Stack Overflow for Teams instances active every day</div>
          </div>
        </div>
        <Link to='/questions'>
          <button className='questions'>Questions</button>
        </Link>
      </div>
    </StyledHome>
  );
};

export default Home;
