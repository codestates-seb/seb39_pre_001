import React, { useState } from 'react';
import { Link } from 'react-router-dom';
import styled from 'styled-components';
import { GrMenu, GrClose } from 'react-icons/gr';
import { AiOutlineSearch } from 'react-icons/ai';

const NavBarWrapper = styled.div`
	display: flex;
	flex-direction: row;
	justify-content: center;
	align-items: center;
	flex-wrap: nowrap;
	width: 100%;
	max-width: 100%;
	height: 100%;
	background-color: #f8f9f9;
	margin: 0 auto;
	border-top: 3px solid #f48225;
	box-shadow: 0 0 5px 2px rgba(0, 0, 0, 0.08);

	> .nav-bar-wrapper {
		display: flex;
		flex-direction: row;
		justify-content: center;
		align-items: center;
		width: 97.2307692rem;
		height: 100%;
		background-color: #f8f9f9;
		margin: 0 50px;
		> .menuBtn {
			display: flex;
			justify-content: center;
			align-items: center;
			height: 44px;
			padding: 0px 16px;
			cursor: pointer;
			:hover {
				border: none;
				background-color: #e2e6e8;
			}
		}

		> .logo-wrapper {
			display: flex;
			justify-content: center;
			align-items: center;
			width: 166px;
			height: 44px;
			padding: 0px 8px;
			border: none;
			:hover {
				border: none;
				background-color: #e2e6e8;
			}
			> .logo {
				background: url(https://cdn.sstatic.net/Img/unified/sprites.svg?v=fcc0ea44ba27)
					no-repeat 0 -502px;
				width: 146px;
				height: 30px;
			}
		}

		> .nav-items {
			position: relative;
			display: flex;
			white-space: nowrap;
			text-decoration: none;
			color: #525960;
			font-size: 12px;
			margin: 2px;
			padding: 6px 12px;
			:hover {
				border: none;
				background-color: #e2e6e8;
				border-radius: 15px;
			}
		}

		> form {
			padding: 0 12px;
			width: 100%;
			> .input-search {
				display: flex;
				flex-direction: row;
				align-items: center;
				width: 100%;
				flex-wrap: nowrap;
				flex-shrink: 10000;
				flex-grow: 1;
				position: relative;
				padding: 5px 5px;
				background-color: #ffffff;
				border: 1px solid #babfc4;
				border-radius: 4px;
				/* :focus {
      border: 3px solid blue;
    } */

				> input {
					font-size: 12px;
					width: 100%;
					flex-grow: 1;
					height: 14.994px;
					border: none;
					:focus {
						outline: none;
					}
				}
			}
		}

		> .button-login {
			height: 14.546px;
			background-color: #e1ecf4;
			color: #39739d;
			font-size: 12px;
			padding: 8px 10.4px;
			border: 1px solid #39739d;
			border-radius: 4px;
			:hover {
				background-color: #b3d3ea;
			}
		}

		> .button-signup {
			height: 14.546px;
			background-color: #0a95ff;
			color: #ffffff;
			font-size: 12px;
			margin: 0 0 0 4px;
			padding: 8px 10.4px;
			border: 1px solid #0a95ff;
			border-radius: 4px;
			:hover {
				background-color: #0074cc;
			}
		}
	}
`;

const NavLink = styled(Link)`
	text-decoration: none;
	white-space: nowrap;
	margin-left: 5px;
`;

const NavBar = () => {
	// dropdown 메뉴 구현하기
	const [click, setClick] = useState(false);

	const handleClick = () => {
		setClick(!click);
	};

	return (
		<NavBarWrapper>
			<div className="nav-bar-wrapper">
				<div className="menuBtn" onClick={handleClick}>
					{!click ? <GrMenu /> : <GrClose />}
				</div>
				<a href="/" className="logo-wrapper">
					<div className="logo" />
				</a>
				<a href="/about" className="nav-items">
					About
				</a>
				<a href="/products" className="nav-items">
					Products
				</a>
				<a href="/forteams" className="nav-items">
					For Teams
				</a>
				<form className="search">
					<div className="input-search">
						<AiOutlineSearch size={20} color="#838C95" />
						<input
							type="text"
							className="logo-search"
							placeholder="Search..."
						/>
					</div>
				</form>
				<NavLink to="/users/login" className="button-login">
					Log in
				</NavLink>
				<NavLink to="/users/join" className="button-signup">
					Sign up
				</NavLink>
			</div>
		</NavBarWrapper>
	);
};

export default NavBar;