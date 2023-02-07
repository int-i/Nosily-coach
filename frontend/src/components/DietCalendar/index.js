import { useState, useQuery, useEffect } from "react";
import Calendar from "react-calendar";
import moment from "moment/moment.js";
import "react-calendar/dist/Calendar.css"; // css import
import * as styled from "./style.js";
import SubTitle from "components/SubTitle";

const DietCalendar = ({ setSubCategory }) => {
  const [value, onChange] = useState(new Date());

  const [음식목록들, set음식목록들] = useState([
    "계란말이",
    "닭가슴살",
    "김치찌개",
  ]);

  const [칼로리, set칼로리] = useState("0");

  const [mark, setMark] = useState([]);
  useEffect(() => {
    setMark(["2023-01-02", "2023-01-03", "2022-01-10"]);
  }, []);

  setSubCategory(`${value.getDate()}일에 먹은 식단`);

  return (
    <styled.Container>
      {/* <styled.CalenderContainer>
          <Calendar
            onChange={onChange}
            formatDay={(locale, date) => moment(date).format("DD")}
            value={value}
            className="mx-auto w-full text-sm border-b"
            tileContent={({ date, view }) => {
              if (mark.find((x) => x === moment(date).format("YYYY-MM-DD"))) {
                return (
                  <>
                    <div className="flex justify-center items-center absoluteDiv">
                      <styled.Dot></styled.Dot>
                    </div>
                  </>
                );
              }
            }}
          />
          </styled.CalenderContainer> */}
      <div>
        <SubTitle>오늘의 식단</SubTitle>
        <></>
        <styled.TopContainer>
          <styled.ContentsBox>
            {" "}
            <styled.PointText>아침</styled.PointText> {음식목록들[0]}{" "}
          </styled.ContentsBox>

          <styled.ContentsBox>
            {" "}
            <styled.PointText>점심</styled.PointText> {음식목록들[1]}{" "}
          </styled.ContentsBox>
          <styled.ContentsBox>
            {" "}
            <styled.PointText>저녁</styled.PointText> {음식목록들[2]}{" "}
            
            </styled.ContentsBox>
            <styled.ContentsBox>
              <styled.PointText>아침</styled.PointText> {음식목록들[0]}{" "}
            </styled.ContentsBox>
          
        </styled.TopContainer>
      </div>
      <div>
        <SubTitle>영양분 섭취량</SubTitle>
        <styled.ContentsBox>
          <styled.Nutrient>단백질,지방,탄수화물데이터</styled.Nutrient>
          <styled.Comment>적당,과다,부족평가</styled.Comment>
          <styled.TotalKcal>총 칼로리 {칼로리} kcal</styled.TotalKcal>
        </styled.ContentsBox>
      </div>
    </styled.Container>
  );
};

export default DietCalendar;
