import SubTitle from "components/SubTitle";
import ContentsBox from "components/ContentsBox";
import * as styled from "./style.js";

const Home = ({ setLargeCategory, setSubCategory, setHidden }) => {
  setLargeCategory("꼬치코치");
  setSubCategory("요약");
  setHidden(false);

  return (
    <>
      <styled.Container>
        <div>
          <SubTitle>오늘의 나는</SubTitle>
          <ContentsBox>
            <styled.BoxItem>
              <styled.Height>169</styled.Height>
              <div>cm</div>
              <styled.Weight>100</styled.Weight>
              <div>kg</div>
            </styled.BoxItem>
          </ContentsBox>
        </div>
        <div>
          <SubTitle>오늘의 섭취량</SubTitle>
          <ContentsBox>
            <styled.BoxItem>
              <styled.Intake>1000</styled.Intake>
              <div>Kcal</div>
            </styled.BoxItem>
          </ContentsBox>
        </div>
        <div>
          <SubTitle>오늘의 운동 시간</SubTitle>
          <ContentsBox>
            <styled.BoxItem>
              <styled.TotalTime>03:03:03</styled.TotalTime>
            </styled.BoxItem>
          </ContentsBox>
        </div>
        <img src="img/icon.png" alt="icon" width="48px" />
        <styled.Description>
          AI기능을 탑재한 꼬치코치와 함께
          <br />
          즐거운 하루 보내세요 :&#41;
        </styled.Description>
      </styled.Container>
    </>
  );
};

export default Home;
