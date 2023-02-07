import styled from "styled-components";

export const Container = styled.div`
  display: flex;
  justify-content: space-between;

  padding: 20px;
  background-color: #1e90ff;
`;

export const LargeCategory = styled.div`
  font-size: 16px;
  color: white;
`;

export const SubCategory = styled.div`
  font-size: 26px;
  font-weight: bold;
  color: white;
`;

export const ProfileImg = styled.img`
  width: ${(props) => (props.width ? props.width : "44px")};
  height: ${(props) => (props.width ? props.width : "44px")};
  border-radius: 50%;
`;
