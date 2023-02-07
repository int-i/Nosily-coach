// import { useState } from "react";
// import * as styled from "./style.js";
// import { Link } from "react-router-dom";
// import ReactStopwatch from "react-stopwatch";
// import Stopwatch from "components/StopWatch/index.js";
// import RestTime from "components/RestTime/index.js";
// import SetCount from "components/SetCount";

// const Timer = () => {
//   const [elapsedTime, setElapsedTime] = useState(0); // 운동 시간, state 변수 elapsedTime을 선언하고, 그 값을 0으로 초기화
//   const [isExercising, setExercising] = useState(true); // 루틴 중 운동상태인지 휴식상태인지 결정하는 변수

  
//   return (
//     <styled.TimerContainer>
//       <div style={{margin:'40px'}}>
//         {isExercising ? (
//           <Stopwatch elapsedTime={elapsedTime} setElapsedTime={setElapsedTime} setExercising={setExercising}/>
//         ) : (
//           <RestTime elapsedTime={elapsedTime} setElapsedTime={setElapsedTime} />
//         )}
//       </div>
//       <SetCount />
//     </styled.TimerContainer>
//   );
// };

// export default Timer;
