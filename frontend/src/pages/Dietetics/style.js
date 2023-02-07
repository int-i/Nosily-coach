import styled from "styled-components";

export const Container = styled.div`
  display: flex;
  flex-direction: column;
  gap: 20px;

  align-items: center;

  margin-top: 25px;
`;

export const Nutrient = styled.div`
  //item1
  display: flex;
  flex-direction: column;
  font-weight: medium;
  text-align: center;
`;

export const NutrientCircle = styled.div`
  display: flex;
  justify-content: center;
  align-items: center;
  width: 70px;
  height: 70px;
  border-radius: 50%;
  background-color: ${(props) => props.color};
`;

export const Comment = styled.div`
  //item2
  display: flex;
  font-weight: medium;
  margin-bottom: 10px;
`;

export const CommentCircle = styled.div`
  width: 16px;
  height: 16px;
  border-radius: 50%;
  background-color: ${(props) => props.color};
  margin-right: 5px;
`;

export const TotalKcal = styled.div`
  //item3
  text-align: center;
  font-weight: medium;
`;

export const PointText = styled.span`
  color: var(--color-dodger-blue);
  font-weight: bold;
  margin-right: 10px;
`;
