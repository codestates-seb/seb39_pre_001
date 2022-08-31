import styled from 'styled-components';
import { GiHamburgerMenu } from 'react-icons/gi';
import logo from '../static/logo.png';

const StyledHeader = styled.header`
  background: #f8f9f9;
  box-shadow: rgba(0, 0, 0, 0.05) 0px 1px 2px;
  height: 75px;
  list-style: none;
  display: flex;
  padding-top: 15px;
  box-sizing: border-box;
`;
const LogoLink = styled.a`
  font-size: 30px;
  text-decoration: none;
  color: #222;
  margin: 0 1.5rem;

  b {
    font-weight: bold;
  }

  .logoImage {
    height: 40px;
  }
`;

const MenuIcon = styled.div`
  font-size: 25px;
  padding: 17px 20px;
  margin-left: 15px;
  cursor: pointer;
`;

const MenuItem = styled.a`
  font-size: 22px;
  padding: 15px 20px;
`;

const MenuLink = styled.a`
  text-decoration: none;
  color: rgba(0, 0, 0, 0.5);
  padding: 10px;
`;

const SearchItem = styled.div`
  padding: 9px 20px;
  width: 43%;
`;

const SearchInput = styled.input`
  width: 100%;
  padding: 10px 6px;
`;

const MenuButton = styled.div`
  list-style: none;
  padding: 15px 10px;
`;

const MenuButtonA = styled.a`
  text-decoration: none;
  color: #39739c;
  background: #e1ecf4;
  border: 1px solid #39739c;
  padding: 15px;
`;

const MenuButtonB = styled.a`
  text-decoration: none;
  background: #0995fe;
  color: #fff;
  border: 1px solid #0995fe;
  padding: 15px;
  margin-left: 12px;
`;

function Header() {
  return (
    <StyledHeader>
      <MenuIcon>
        <GiHamburgerMenu />
      </MenuIcon>
      <LogoLink href='/' className='logo'>
        <img className='logoImage' src={logo} alt='logo' />
        Stack<b>Overflow</b>
      </LogoLink>
      <MenuItem>
        <MenuLink href='' className='about'>
          about
        </MenuLink>
        <MenuLink href='' className='product'>
          product
        </MenuLink>
        <MenuLink href='' className='forTeams'>
          forTeams
        </MenuLink>
      </MenuItem>
      <SearchItem>
        <form action='' className='search'>
          <SearchInput type='text' placeholder='Search...' />
        </form>
      </SearchItem>
      <MenuButton>
        <MenuButtonA href='/users/login' className='login'>
          Log in
        </MenuButtonA>
        <MenuButtonB href='/users/join' className='signup'>
          Sign Up
        </MenuButtonB>
      </MenuButton>
    </StyledHeader>
  );
}

export default Header;
