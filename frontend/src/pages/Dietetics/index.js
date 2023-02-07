//import DietCalendar from "components/DietCalendar";
//import MealRecord from "components/MealRecord";
//import Timer from "../../components/Timer";

import { useState, useEffect } from "react";
import SubTitle from "components/SubTitle";
import ContentsBox from "components/ContentsBox";
import BoxItem from "components/ContentsBox/BoxItem";
import * as styled from "./style.js";

const Dietetics = ({ setLargeCategory, setSubCategory, setHidden }) => {
  const [value, onChange] = useState(new Date());

  const [음식목록들, set음식목록들] = useState([
    "계란말이",
    "닭가슴살",
    "김치찌개",
    "초코송이",
  ]);

  const [칼로리, set칼로리] = useState("0");

  const [mark, setMark] = useState([]);
  useEffect(() => {
    setMark(["2023-01-02", "2023-01-03", "2022-01-10"]);
  }, []);

  setLargeCategory("식단 관리");
  setSubCategory(`${value.getMonth() + 1}월 ${value.getDate()}일의 식단`);
  setHidden(false);
  return (
    <styled.Container>
      <div>
        <SubTitle>오늘의 식단</SubTitle>
        <ContentsBox height={170}>
          <BoxItem>
            <styled.PointText>아침</styled.PointText> {음식목록들[0]}
          </BoxItem>
          <BoxItem>
            <styled.PointText>점심</styled.PointText> {음식목록들[1]}
          </BoxItem>
          <BoxItem>
            <styled.PointText>저녁</styled.PointText> {음식목록들[2]}
          </BoxItem>
          <BoxItem>
            <styled.PointText>간식</styled.PointText> {음식목록들[3]}
          </BoxItem>
        </ContentsBox>
      </div>
      <div>
        <SubTitle>영양분 섭취량</SubTitle>
        <ContentsBox height={260}>
          <div style={{ display: "flex", justifyContent: "space-around" }}>
            <styled.Nutrient>
              <styled.NutrientCircle color={"#FFE072"}>
                600
              </styled.NutrientCircle>
              <div>단백질</div>
            </styled.Nutrient>
            <styled.Nutrient>
              <styled.NutrientCircle color={"#FF7292"}>
                1200
              </styled.NutrientCircle>
              <div>탄수화물</div>
            </styled.Nutrient>
            <styled.Nutrient>
              <styled.NutrientCircle color={"#1E90FF"}>
                1000
              </styled.NutrientCircle>
              <div>지방</div>
            </styled.Nutrient>
          </div>
          <div style={{ marginTop: "10px" }}>
            <styled.Comment>
              <styled.CommentCircle color={"#1E90FF"} />
              적당해요!
            </styled.Comment>
            <styled.Comment>
              <styled.CommentCircle color={"#FF7292"} />
              적정량을 넘었어요
            </styled.Comment>
            <styled.Comment>
              <styled.CommentCircle color={"#FFE072"} />
              부족해요...
            </styled.Comment>
          </div>
          <div>
            <styled.TotalKcal>
              총 칼로리{" "}
              <span
                style={{
                  color: "#FF7292",
                  fontSize: "18px",
                  fontWeight: "bold",
                }}
              >
                {칼로리}
              </span>{" "}
              kcal
            </styled.TotalKcal>
          </div>
        </ContentsBox>
      </div>
    </styled.Container>
  );

  // return (
  //   <>
  //     <DietCalendar setSubCategory={setSubCategory} />
  //     {/*<MealRecord />*/}
  //     {/* <Timer/> */}
  //   </>
  // );
};

export default Dietetics;
