import styled from 'styled-components';
import userImg from '../static/user.png';

const StyledSummary = styled.div`
  display: flex;
  border-top: 1px solid #d6d9dc;
  padding: 16px;
  padding-right: 24px;
  margin: 0 -24px 0 -24px;
  > .stats {
    display: flex;
    flex-direction: column;
    flex-shrink: 0;
    flex-wrap: wrap;
    align-items: flex-end;
    width: 108px;
    text-align: right;
    margin: 0 16px 4px 0;
    gap: 6px;
    font-size: 13px;
    > .view {
      color: #6a737c;
    }
  }
  > .content {
    width: 600px;
    > .title {
      font-weight: 400;
      padding-right: 24px;
      margin: -2px 0 5px 0;
      line-height: calc(17 / 13);
      > a {
        text-decoration: none;
        font-size: 17px;
      }
    }
    > .body {
      font-size: 13px;
      margin: -2px 0 8px 0;
    }
    > .meta {
      display: flex;
      align-items: center;
      justify-content: space-between;
      flex-wrap: wrap;
      row-gap: 8px;
      > .tags {
        display: flex;
        flex-wrap: wrap;
        gap: 4px;
        > div {
          font-size: 12px;
          color: #39739d;
          background-color: #e1ecf4;
          margin: 0 2px 2px 0;
          padding: 4.8px 6px;
          border-radius: 4px;
        }
      }
      > .user {
        display: flex;
        align-items: center;
        margin-left: auto;
        font-size: 12px;
        > img {
          width: 16px;
          margin-right: 5px;
        }
      }
    }
  }
`;

function Summary({ question }) {
  const { id, title, body, tags, author, date, like, dislike, view } = question;
  return (
    <StyledSummary>
      <div className='stats'>
        <div className='like'>{like} likes</div>
        <div className='dislike'>{dislike} dislikes</div>
        <div className='view'>{view} views</div>
      </div>
      <div className='content'>
        <h3 className='title'>
          <a className='title' href='https://stackoverflow.com/questions/73480702/maximum-concurrent-dpu-usage-count'>
            {id} {title}
          </a>
        </h3>
        <div className='body'>{body}</div>
        <div className='meta'>
          <div className='tags'>
            {tags.map((tag, i) => (
              <div key={i}>{tag}</div>
            ))}
          </div>
          <div className='user'>
            <img src={userImg} alt='user' />
            {author} 이(가) {date}
          </div>
        </div>
      </div>
    </StyledSummary>
  );
}

export default Summary;
