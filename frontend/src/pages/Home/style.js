import styled from "styled-components";

export const Container = styled.div`
  display: flex;
  flex-direction: column;
  align-items: center; // 가로축 중앙 정렬
  gap: 20px;

  margin-top: 25px;
`;

export const BoxItem = styled.div`
  display: flex;
  gap: 5px;
  justify-content: center;
  align-items: center;
  margin: 10px;
`;

export const Height = styled.div`
  font-weight: bold;
  font-size: 24px;
`;

export const Weight = styled.div`
  font-weight: bold;
  font-size: 24px;

  margin-left: 10px;
`;

export const Intake = styled.div`
  font-weight: bold;
  font-size: 24px;
  margin-right: 5px;
`;

export const TotalTime = styled.div`
  font-weight: bold;
  font-size: 24px;
`;

export const Description = styled.div`
  color: var(--color-manatee);
  text-align: center;
`;
