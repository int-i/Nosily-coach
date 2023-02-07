import { useState } from "react";
import * as styled from "./style.js";
import { Link } from "react-router-dom";
import { SubTitle } from "components/SubTitle/style.js";

const ExerciseButton = ({ part }) => {
  const [운동시간, set운동시간] = useState(0);
  const [목표달성, set목표달성] = useState(0);

  return (
    <>
      <styled.ExerciseButton>
        {/* color prop을 전달하여 버튼 색상을 지정 */}
        <styled.Work>
          <SubTitle>{part}</SubTitle>

          <styled.WorkAttribute>
            <div>{운동시간}</div>
            <div>{목표달성}</div>
          </styled.WorkAttribute>
        </styled.Work>
        <Link to="workset">
          <styled.EditButton>Edit</styled.EditButton>
        </Link>
      </styled.ExerciseButton>
    </>
  );
};
export default ExerciseButton;
