import { useState } from "react";
import * as styled from "./style.js";
import { Link } from "react-router-dom";

const RoutineBox = ({ part }) => {
  
  const [한세트갯수, set한세트갯수] = useState(0);
  const [한세트시간, set한세트시간] = useState(0);
  const [목표무게, set목표무게] = useState(0);
  const [휴식시간, set휴식시간] = useState(0);

  return (
    <>
      {/* <Link to="/routineset"> */}
        {/* 버튼을 클릭하면 routineset 페이지로 이동 */}
        <styled.RoutineBox>
          <div>{part}</div>
          <div>{한세트갯수},{한세트시간}</div>
          <div>{목표무게}</div>
          <div>{휴식시간}</div>
        </styled.RoutineBox>
      {/* </Link> */}
    </>
  );
};
export default RoutineBox;
