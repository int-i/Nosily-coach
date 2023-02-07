import { useState } from "react"; // react의 useState 함수 사용
import * as styled from "./style.js"; // styled.js 파일에서 정의한 스타일들 가져오기
import { useLocation, Outlet } from "react-router-dom"; // react-router-dom의 useLocation, Outlet 함수 사용
import RoutineBox from "components/RoutineBox";

const Routine = () => {
  const [Date, SetDate] = useState("2023/2/7");
  return (
    <>
      <styled.Pointblock>운동 루틴</styled.Pointblock>
      <styled.Block>
        <styled.DateContainer>
         
          <div>{Date}</div>
          
        </styled.DateContainer>
      </styled.Block>

      <styled.RoutineContainer>
        <RoutineBox />
        <RoutineBox />
        <RoutineBox />
        <RoutineBox />
      </styled.RoutineContainer>
    </>
  );
};

export default Routine;
