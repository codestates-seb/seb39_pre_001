import styled from 'styled-components';

const StyledSummary = styled.div`
  display: flex;
  border-top: 1px solid #888;
  padding: 10px;
  > .stats {
    width: 100px;
    text-align: right;
    margin: 0 16px 4px 0;
    > div {
      margin-bottom: 10px;
    }
  }
  > .content {
    width: 400px;
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
        <a className='title' href='https://stackoverflow.com/questions/73480702/maximum-concurrent-dpu-usage-count'>
          {title}
        </a>
        <div className='body'>{body}</div>
        <div className='meta'>
          <div className='tags'>
            {tags.map((e, i) => (
              <div key={i}>{e}</div>
            ))}
          </div>
          <div className='user'>
            {author} 이(가) {date}
          </div>
        </div>
      </div>
    </StyledSummary>
  );
}

export default Summary;
