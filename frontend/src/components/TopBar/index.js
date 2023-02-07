import { useState } from "react";
import { Link } from "react-router-dom";
import * as styled from "./style.js";

const TopBar = ({ largeCategory, subCategory, isHidden }) => {
  const [profile, setProfile] = useState("img/icon.png");
  return (
    <>
      <styled.Container>
        <div>
          <styled.LargeCategory>{largeCategory}</styled.LargeCategory>
          <styled.SubCategory>{subCategory}</styled.SubCategory>
        </div>
        {isHidden ? (
          <></>
        ) : (
          <>
            <Link to="/mypage">
              <styled.ProfileImg src={profile} alt="profile image" />
            </Link>
          </>
        )}
      </styled.Container>
    </>
  );
};

export default TopBar;
