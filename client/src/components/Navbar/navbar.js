import React from "react";
import { Nav, NavLink, NavMenu } from "./NavbarStyles";
import {GiHamburgerMenu} from 'react-icons/gi';

export const Navbar = () => {
  return (
    <Nav>
      <GiHamburgerMenu className="NavIcon"/>
      <NavMenu>
        <NavLink to = "/about" activeStyle> About </NavLink>
        <NavLink to = "/product" activeStyle> Product </NavLink>
        <NavLink to = "/forTeams" activeStyle> For Teams </NavLink>
      </NavMenu>
    </Nav>
  )

}