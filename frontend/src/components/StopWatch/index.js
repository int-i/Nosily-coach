// import { useState, useEffect } from "react";
// import ReactStopwatch from "react-stopwatch";
// import * as styled from "./style.js";

// const Stopwatch = ({elapsedTime, setElapsedTime, setExercising}) => {// state 변수 isRunning을 선언하고, 그 값을 false로 초기화
//   const [isRunning, setIsRunning] = useState(false);

//   // isRunning이 true일 때, elapsedTime을 1씩 증가시키는 setInterval 함수 생성
//   useEffect(() => {
//     let intervalId = null;
//     if (isRunning) {
//       intervalId = setInterval(() => {
//         setElapsedTime((prevTime) => prevTime + 1);
//       }, 10);
//     }
//     if (elapsedTime >= 1000) setExercising(prev => !prev);
//     return () => clearInterval(intervalId);  // isRunning이 false가 되면, setInterval 함수를 제거
//   }, [isRunning]);

//   const handleStartStopClick = () => { // Start/Stop 버튼 클릭 시, isRunning 값을 반전시키는 함수
//     setIsRunning((prevRunning) => !prevRunning);
//   };

//   const handleResetClick = () => {  // Reset 버튼 클릭 시, elapsedTime을 0으로 초기화하는 함수
//     setElapsedTime(0);
//   };

//   const formatTime = (time) => { // elapsedTime을 분, 초, 밀리초로 포맷팅하는 함수
//     const minutes = Math.floor(time / 6000);
//     const seconds = Math.floor(time / 100) - minutes * 60;
//     const milliseconds = time - seconds * 100 - minutes * 6000;
//     return `${minutes.toString().padStart(2, "0")}:${seconds
//       .toString()
//       .padStart(2, "0")}.${milliseconds.toString().padStart(2, "0")}`;
//   };
// console.log(Stopwatch)
//   return ( // Stopwatch 컴포넌트 UI 렌더링
//     <div>
//       <styled.StopWatchContainer>  {/* 현재 시간 표시 */}
//         <div>{formatTime(elapsedTime)}</div>
//         <div>
//         {/* Start/Stop, Reset 버튼 */}
//           <styled.NewButton onClick={handleStartStopClick}>
//             {isRunning ? "❚❚" : "▷"}
//           </styled.NewButton>
//           <styled.NewButton onClick={handleResetClick}>↻</styled.NewButton>
//         </div>
//       </styled.StopWatchContainer>

//     </div>
//   );
// };

// export default Stopwatch;
