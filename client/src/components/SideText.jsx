import styled from 'styled-components';
import { BsQuestionSquareFill } from 'react-icons/bs';
import { MdOutlineSwitchLeft } from 'react-icons/md';
import { AiFillTags, AiFillTrophy } from 'react-icons/ai';

const SideTextContainer = styled.div`
  width: 412px;
  height: 285px;
  margin-right: 48px;
`;

const Headline = styled.div`
  width: 412px;
  font-size: 27px;
  margin: 0 0 32px;
`;

const DetailSideTextWrapper = styled.div`
  display: flex;
  align-items: center;
  margin-bottom: 24px;
`;

const DetailSideText = styled.div`
  font-size: 15px;
`;
const DetailSideBottomText = styled.div`
  font-size: 13px;
`;

// as-is: a tag , to-be: link
const Link = styled.a`
  color: #0074cc;
`;

const IconWrapper = styled.div`
  width: 28px;
  height: 24px;
  margin-right: 7px;
  color: #0A95FF;
`;

const QuestionSquareIcon = styled(BsQuestionSquareFill)`
  width: 22px;
  height: 21px;
`;

const UpDownIcon = styled(MdOutlineSwitchLeft)`
  transform: rotate(-0.25turn);
  width: 26px;
  height: 26px;
`;

const TagIcon = styled(AiFillTags)`
  width: 26px;
  height: 26px;
`;

const TrophyIcon = styled(AiFillTrophy)`
  width: 26px;
  height: 26px;
`;

const SideText = () => {
  return (
    <SideTextContainer>
      <Headline>Join the Stack Overflow community</Headline>
      <DetailSideTextWrapper>
        <IconWrapper>
          <QuestionSquareIcon />
        </IconWrapper>
        <DetailSideText>Get unstuck — ask a question</DetailSideText>
      </DetailSideTextWrapper>
      <DetailSideTextWrapper>
        <IconWrapper>
          <UpDownIcon />
        </IconWrapper>
        <DetailSideText>Unlock new privileges like voting and commenting</DetailSideText>
      </DetailSideTextWrapper>
      <DetailSideTextWrapper>
        <IconWrapper>
          <TagIcon />
        </IconWrapper>
        <DetailSideText>Save your favorite tags, filters, and jobs</DetailSideText>
      </DetailSideTextWrapper>
      <DetailSideTextWrapper>
        <IconWrapper>
          <TrophyIcon />
        </IconWrapper>
        <DetailSideText>Earn reputation and badges</DetailSideText>
      </DetailSideTextWrapper>
      <DetailSideBottomText>Collaborate and share knowledge with a private group for FREE.<br />
        <Link>Get Stack Overflow for Teams free for up to 50 users.
        </Link>
      </DetailSideBottomText>
    </SideTextContainer >
  );
};

export default SideText;