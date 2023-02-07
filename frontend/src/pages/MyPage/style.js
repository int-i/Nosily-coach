import styled from "styled-components";

export const Container = styled.div`
  display: flex;
  flex-direction: column;
  align-items: center; // 가로축 중앙 정렬
  gap: 20px;

  margin-top: 25px;
`;

export const Label = styled.div`
  font-weight: bold;
  color: var(--color-dodger-blue);
  margin-right: 10px;
`;

export const ATRSet = styled.div`
  display: flex;
  margin-left: 5px;
  margin-bottom: 20px;
`;
