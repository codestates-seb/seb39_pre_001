import { NavLink as Link } from "react-router-dom";
import styled from 'styled-components';

export const Nav = styled.nav`
background: #b9bbb6;
height: 65px;
display: flex;
z-index: 12;

.logoImage {
    height: 20px;
}

.NavIcon {
    font-size: 25px;
}

.Dropdown-btn {
    padding: 0 1rem;
    text-align: center;
    align-items: center;
    justify-content: center;
    height: 100%;
    border: none;
}

.home-img {
    height: 25px;
    padding: 0 0.2rem;
}
button {
    width: 140px;
  height: 45px;
  font-family: 'Roboto', sans-serif;
  font-size: 11px;
  text-transform: uppercase;
  letter-spacing: 2.5px;
  font-weight: 500;
  color: #000;
  background-color: #fff;
  border: none;
  border-radius: 15px;
  box-shadow: 0px 8px 15px rgba(0, 0, 0, 0.1);
  transition: all 0.3s ease 0s;
  cursor: pointer;
  outline: none;
  margin-left: 15px;
}
`;


export const NavLink = styled(Link)`
color: #222;
display: flex;
align-items: center;
text-decoration: none;
padding: 0 1rem;
height: 100%;
cursor: pointer;
`;

export const NavMenu = styled.div `
display: flex;
align-items: center;
margin-right: -24px;

@media screen and (max-width: 768px) {
    display: none;
}
`