import styled from 'styled-components';
import userImg from '../static/user.png';
import { Link } from 'react-router-dom';

export const StyledSummary = styled.div`
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
      /* Summary에서 Title 2줄로 제한 */
      overflow: hidden;
      text-overflow: ellipsis;
      display: -webkit-box;
      -webkit-line-clamp: 2;
      -webkit-box-orient: vertical;
      word-wrap: break-word;
      > a {
        text-decoration: none;
        font-size: 17px;
        color: #0074cc;
        :visited {
          color: #0063bf;
        }
      }
    }
    > .body {
      font-size: 13px;
      margin: -2px 0 8px 0;
      /* Summary에서 Description 2줄로 제한 */
      line-height: 1.4;
      overflow: hidden;
      text-overflow: ellipsis;
      display: -webkit-box;
      -webkit-line-clamp: 2;
      -webkit-box-orient: vertical;
      word-wrap: break-word;
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
  const {
    questionId,
    title,
    description,
    tags,
<<<<<<< Updated upstream
    user: { displayName },
    date,
    likes,
    dislikes,
    view,
=======
    // user: { displayName },
    createdAt,
    likes,
    dislikes,
    views,
>>>>>>> Stashed changes
  } = question;
  return (
    <StyledSummary>
      <div className='stats'>
        <div className='like'>{likes} likes</div>
        <div className='dislike'>{dislikes} dislikes</div>
<<<<<<< Updated upstream
        <div className='view'>view views</div>
=======
        <div className='view'>{views} views</div>
>>>>>>> Stashed changes
      </div>
      <div className='content'>
        <h3 className='title'>
          <Link to={'/questions/' + String(questionId)}>{title}</Link>
        </h3>
        <div className='body'>{description}</div>
        <div className='meta'>
          <div className='tags'>
            {tags.map((tag, i) => (
              <div key={i}>{tag}</div>
            ))}
          </div>
          <div className='user'>
            <img src={userImg} alt='user' />
<<<<<<< Updated upstream
            {displayName} 이(가) date
=======
            displayName 이(가) {createdAt}에 작성
>>>>>>> Stashed changes
          </div>
        </div>
      </div>
    </StyledSummary>
  );
}

export default Summary;
