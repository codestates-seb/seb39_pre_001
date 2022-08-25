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
`;

export const NavLink = styled(Link)`
color: #808080;
display: flex;
align-items: center;
text-decoration: none;
padding: 0 1rem;
height: 100%;
cursor: pointer;
&.active {
    color: #000000;
}
`;

export const NavMenu = styled.div `
display: flex;
align-items: center;
margin-right: -24px;

@media screen and (max-width: 768px) {
    display: none;
}
`