import * as styled from "./style";

const ContentsBox = ({ children, width, height, axis }) => {
  if (!!axis === false) axis = "column";
  return (
    <>
      <styled.ContentsBox width={width} height={height}>
        <styled.InnerBox axis={axis}>{children}</styled.InnerBox>
      </styled.ContentsBox>
    </>
  );
};

export default ContentsBox;
