import React from "react";
import { Nav, NavLink, NavMenu } from "./NavbarStyles";
import Dropdown from "react-bootstrap/Dropdown";
import { GiHamburgerMenu } from "react-icons/gi";
import styled from "styled-components";

const TextLogo = styled.h1`
font-size: 25px;
  font-weight: 700;
  > span[class="primary"] {
    color: rgb(255, 47, 110);
  }
  > span:not(.primary) {
    color: #222;
  }
`;


export const Navbar = () => {
  return (
    <Nav>
      <Dropdown>
        <Dropdown.Toggle variant="none" className="Dropdown-btn">
          <GiHamburgerMenu className="NavIcon" />
        </Dropdown.Toggle>

        <Dropdown.Menu>
          <Dropdown.Item href="#/Questions">Questions</Dropdown.Item>
        </Dropdown.Menu>
      </Dropdown>
      <NavLink to="/" className="home-btn">
        <img src="img/stack-overflow.png" className="home-img"></img>
        <TextLogo>
        <span>Stack</span>
        <span className="primary">overflow</span>
        </TextLogo>
      </NavLink>
      <NavMenu>
        <NavLink to="/about" activeStyle>
          {" "}
          About{" "}
        </NavLink>
        <NavLink to="/product" activeStyle>
          {" "}
          Product{" "}
        </NavLink>
        <NavLink to="/forTeams" activeStyle>
          {" "}
          For Teams{" "}
        </NavLink>
      </NavMenu>
      {/* <ButtonGroup>
      <button className="login-btn">Log In</button>
      <button className="signup-btn">Sign Up</button>
      </ButtonGroup> */}
      <button className="login-btn">Log In</button>
      <button className="signup-btn">Sign Up</button>
    </Nav>
  );
};
