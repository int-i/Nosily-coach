import styled from "styled-components";

export const Timerblock = styled.div``;

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

export const Block = styled.div`
  display: flex;
  justify-content: center;
  align-items: center;
  width: 320px;
  height: 77px;
  //margin: 0 auto;
  //margin-top: 1em;

  background: #fdfeff;
  box-shadow: 0px 2px 4px rgba(0, 0, 0, 0.25);
  border-radius: 16px;
`;

export const Container = styled.div`
  display: flex;
  flex-direction: column;
  gap: 20px;

  align-items: center;

  margin-top: 25px;
`;

export const ExerciseContainer = styled.div`
  //item1
  display: flex;
  flex-direction: column;
  width: 320px;

  background: #ffffff;
  box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);
  border-radius: 10px;
  font-family: "Spoqa Han Sans Neo";
`;


export const DateContainer = styled.div`
  font-weight: bold;
  font-size: 20px;
`;