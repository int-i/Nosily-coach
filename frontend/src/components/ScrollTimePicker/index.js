import { useState } from "react";
import { Timeit } from "react-timeit";

import * as styled from "./style.js";

const ScrollTimePicker = () => {
  const [time, setTime] = useState();

  return (
    <styled.timeContainer>
      <Timeit onChange={(time) => setTime(time)} defualtValue="10:10" />
    </styled.timeContainer>
  );
};

export default ScrollTimePicker;
