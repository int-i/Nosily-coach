import ContentsBox from "components/ContentsBox";
import SubTitle from "components/SubTitle";
import { ProfileImg } from "components/TopBar/style";

import { LineChart, Line, XAxis, YAxis, Tooltip } from "recharts";

import * as styled from "./style";

const data = [
  { name: "한달 전", weight: 84 },
  { name: "", weight: 74 },
  { name: "현재", weight: 78 },
  { name: "", weight: 73 },
  { name: "한달 뒤", weight: 69 },
];

const MyPage = ({
  setNavValue,
  setLargeCategory,
  setSubCategory,
  setHidden,
}) => {
  setNavValue(3);
  setLargeCategory("꼬치코치");
  setSubCategory("마이페이지");
  setHidden(true);

  return (
    <styled.Container>
      <div>
        <SubTitle>프로필</SubTitle>
        <ContentsBox axis="row">
          <ProfileImg src="img/icon.png" alt="profile" width={"60px"} />
          <div>
            <styled.ATRSet>
              <styled.Label>이름</styled.Label>
              <div>원초롱</div>
            </styled.ATRSet>
            <styled.ATRSet>
              <styled.Label>나이</styled.Label>
              <div>24세</div>
            </styled.ATRSet>
            <styled.ATRSet>
              <styled.Label>몸무게</styled.Label>
              <div>78kg</div>
            </styled.ATRSet>
            <styled.ATRSet>
              <styled.Label>골격근</styled.Label>
              <div>33kg</div>
            </styled.ATRSet>
          </div>
          <div>
            <styled.ATRSet>
              <styled.Label>성별</styled.Label>
              <div>남성</div>
            </styled.ATRSet>
            <styled.ATRSet>
              <styled.Label>키</styled.Label>
              <div>180cm</div>
            </styled.ATRSet>
            <styled.ATRSet>
              <styled.Label>체지방</styled.Label>
              <div>25.7%</div>
            </styled.ATRSet>
          </div>
        </ContentsBox>
      </div>
      <div>
        <SubTitle>몸무게 그래프</SubTitle>
        <ContentsBox>
          <div style={{ textAlign: "center" }}>
            <styled.Label>체중 감량 예측 AI가 본 한 달 뒤 몸무게</styled.Label>
          </div>
          <LineChart width={250} height={200} data={data}>
            <XAxis dataKey="name" />
            <YAxis type="number" domain={["auto", "auto"]} />
            <Tooltip />
            <Line type="monotone" dataKey="weight" stroke="#8884d8" />
          </LineChart>
        </ContentsBox>
      </div>
    </styled.Container>
  );
};

export default MyPage;
