import Skeleton from 'react-loading-skeleton';
import 'react-loading-skeleton/dist/skeleton.css';
import { StyledSummary } from './Summary';

function SummaryLoading() {
  return (
    <StyledSummary>
      <div className='stats'>
        <Skeleton width={'50px'} height={'15px'} count={3} />
      </div>
      <div className='content'>
        <h3 className='title'>
          <Skeleton />
        </h3>
        <div className='body'>
          <Skeleton count={2} />
        </div>
        <div className='meta'>
          <div className='tags'>
            <Skeleton />
          </div>
          <div className='user'>
            <Skeleton width={'100px'} />
          </div>
        </div>
      </div>
    </StyledSummary>
  );
}

export default SummaryLoading;
