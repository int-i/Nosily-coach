import { useState } from "react"; // react의 useState 함수 사용
import * as styled from "./style.js"; // styled.js 파일에서 정의한 스타일들 가져오기
import { useLocation, Outlet } from "react-router-dom"; // react-router-dom의 useLocation, Outlet 함수 사용
import RoutineBox from "components/RoutineBox";


const InputRoutine = () => {
  const[파트,set파트]=useState("스쿼트")
  const[몇세트,set몇세트]=useState("10")
  const[횟수,set횟수]=useState(0)
  const[시간,set시간]=useState(0)
  const[무게,set무게]=useState(0)
  return (
    <>
      <styled.Pointblock>
        <h2>운동 루틴 설정</h2>
      </styled.Pointblock>

      <styled.RoutineContainer>
        <RoutineBox>
        {/* <div>{파트}</div>
        <div>{몇세트}</div>
        <div>{횟수}</div>
        <div>{시간}</div>
        <div>{무게}</div> */}
        </RoutineBox>


      </styled.RoutineContainer>
    </>
  );
};

export default InputRoutine;
