import styled from "styled-components";

export const Container = styled.div`
  display: flex;
  flex-direction: column;
  gap: 20px;

  align-items: center;
`;

export const Block = styled.div`
  background-color: #fcffe7;
  width: 50vw;
  color: #2b3467;
  padding: 1em 0;
  //border: 1px solid black;

  text-align: center;
  display: block;
  margin: 0 auto;
  margin-top: 30px;
  border-radius: 15px;
`;

export const CalenderContainer = styled.div`
  display: flex;
  justify-content: center;
  align-items: center;
  margin-bottom: 30px;
  margin-top: 5px;
`;

export const Dot = styled.div`
  height: 8px;
  width: 8px;
  background-color: #f87171;
  border-radius: 50%;
  display: flex;
  margin-left: 1px;
`;

export const Title = styled.div`
  text-align: center;
  font-size: 18px;
  line-height: 1.5;
  margin-top: 10px;

  //border: 1px solid black;
  //text-align: center;
  display: black;
  margin: auto;
  margin-top: 30px;
`;

export const Pointblock = styled.div`
  position: absolute;
  width: 360px;
  height: 128px;
  left: 0px;
  top: 0px;
  background: #1e90ff;
`;

export const TopContainer = styled.div`
  padding: 1em;
  width: 332px;
  height: 176px;
  left: 13px;
  top: 190px;//컨테이너 위치

  background: #fdfeff;
  box-shadow: 0px 2px 4px rgba(0, 0, 0, 0.25);
  border-radius: 16px;
`;

export const ContentsBox = styled.div`
  display: flex;
  flex-direction: column;
  //align-items: stretch;
  flex-grow: 1;
  //align-content: stretch;
  //justify-content: 'space-between';
  padding: 1em;
  width: 332px;
  height: 284px;
  left: 13px;
  top: 434px;

  background: #fdfeff;
  box-shadow: 0px 2px 4px rgba(0, 0, 0, 0.25);
  border-radius: 16px;
`;


export const Nutrient = styled.div`//item1
  position: top;
  //width: 155px;
  //height: 23px;
  left: 94px;
  top: 680px;
  padding: 0 auto;
`;

export const Comment = styled.div`//item2

`;

export const TotalKcal = styled.div`//item3
  font-weight: bold;
  
`;

export const PointText = styled.div`
  color:#1E90FF;
  font-weight: bold;

`;

export const EditAdd = styled.div`
color:#5686B6;
font-size: 16px;
`;

export const TitleBox = styled.div`
  display: flex;
  flex-direction: column;
`;
