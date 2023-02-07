import { Routes, Route, useNavigate } from "react-router-dom";
import Home from "pages/Home";
import Dietetics from "pages/Dietetics";
import Exercise from "pages/Exercise";
import Timer from "pages/Exercise/Timer";
import Routine from "pages/Routine";
import InputRoutine from "pages/InputRoutine";
import MyPage from "pages/MyPage";
import Workset from "pages/Exercise/Workset";

import TopBar from "components/TopBar";
import BottomNav from "components/BottomNav";
import { useEffect, useState } from "react";

// jsx
const App = () => {
  const [largeCategory, setLargeCategory] = useState("");
  const [subCategory, setSubCategory] = useState("");
  const [hidden, setHidden] = useState(false);
  const [navValue, setNavValue] = useState(1);
  const navigate = useNavigate();

  useEffect(() => {
    if (navValue === 0) navigate("/dietetics");
    else if (navValue === 1) navigate("/");
    else if (navValue === 2) navigate("/exercise");
  }, [navValue]);

  return (
    <>
      <TopBar
        largeCategory={largeCategory}
        subCategory={subCategory}
        isHidden={hidden}
      />
      <Routes>
        <Route
          path="/"
          element={
            <Home
              setLargeCategory={setLargeCategory}
              setSubCategory={setSubCategory}
              setHidden={setHidden}
            />
          }
        />
        <Route
          path="/dietetics"
          element={
            <Dietetics
              setLargeCategory={setLargeCategory}
              setSubCategory={setSubCategory}
              setHidden={setHidden}
            />
          }
        />

        <Route
          path="/exercise/*"
          element={
            <Exercise
              setLargeCategory={setLargeCategory}
              setSubCategory={setSubCategory}
              setHidden={setHidden}
            />
          }
        >
          <Route path="workset" element={<Workset />} />
        </Route>
        <Route path="/routine/" element={<Routine />} />
        <Route path="/routineset/" element={<InputRoutine />} />
        <Route
          path="/mypage"
          element={
            <MyPage
              setNavValue={setNavValue}
              setLargeCategory={setLargeCategory}
              setSubCategory={setSubCategory}
              setHidden={setHidden}
            />
          }
        />
      </Routes>
      <BottomNav navValue={navValue} setNavValue={setNavValue} />
    </>
  );
};

export default App;
