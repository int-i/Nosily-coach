import styled from "styled-components";

export const ContentsBox = styled.div`
  width: ${props => (props.width ? `${props.width}px` : `90vw`)};
  height: ${props => `${props.height}px`};

  margin-top: 8px;

  box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);
  border-radius: 10px;
`;

export const InnerBox = styled.div`
  display: flex;
  flex-direction: ${props => props.axis};
  gap: 10px;

  padding: 15px;
`;
