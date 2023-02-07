import { useEffect,useState } from "react";
import React from "react";
import ReactDOM from "react-dom";
import * as styled from "./style.js";


const SetCount = () => {
    const[달성갯수,set달성갯수] = useState(0);
    const[목표갯수,set목표갯수] = useState(0);
    return(
        <styled.SetCount>

            <div>{달성갯수}/{목표갯수}</div>
            
        </styled.SetCount>
    );

};
export default SetCount;