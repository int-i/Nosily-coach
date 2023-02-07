import styled from "styled-components";

export const Pointblock = styled.div`
  display: flex;
  align-items: flex-end;
  justify-content: flex-start;
  padding-bottom: 16px;
  padding-left: 16px;

  width: 360px;
  height: 128px;

  left: 0px;
  top: 0px;
  background: #1e90ff;
  text-align: left;
  font-size: 26px;
  color: white;
  font-family: "Spoqa Han Sans Neo";
`;

export const Container = styled.div`
  display: flex;
  flex-direction: column;

  ///justify-content: space-around;
  gap: 10px;

  //align-items: center;
  //margin-top: 20px;
  margin-bottom: 5em;
`;
export const RowContainer = styled.div`
  display: flex;
  flex-direction: row;
  justify-content: space-around;
  align-items: center;
`;
