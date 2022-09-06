import React, { useEffect, useState } from 'react';
import { Link, useLocation, useNavigate } from 'react-router-dom';
import styled from 'styled-components';
import { GrMenu, GrClose } from 'react-icons/gr';
import { AiOutlineSearch } from 'react-icons/ai';
import { FaUserCircle } from 'react-icons/fa';
import Dropdown from './Dropdown';
import axios from 'axios';

const NavBarWrapper = styled.div`
	position: fixed;
	display: flex;
	flex-direction: row;
	justify-content: center;
	align-items: center;
	flex-wrap: nowrap;
	width: 100%;
	max-width: 100%;
	background-color: #f8f9f9;
	margin: 0 auto;
	border-top: 3px solid #f48225;
	box-shadow: 0 0 5px 3px rgba(0, 0, 0, 0.1);
	z-index: 9999;

	> .nav-bar-wrapper {
		display: flex;
		flex-direction: row;
		justify-content: center;
		align-items: center;
		width: 100%;
		height: 100%;
		max-width: 1000px;
		background-color: #f8f9f9;
		position: relative;
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
		// 햄버거 버튼 dropdown 메뉴
		> .dropdown-menu {
			position: absolute;
			padding: 0;
			margin: 0;
			top: 47px;
			left: 0;
			box-shadow: 0 0 5px 3px rgba(0, 0, 0, 0.1);
			z-index: 999;
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
			max-width: 700px;
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

		> .btn-displayName {
			display: flex;
			align-items: center;
			height: 14.546px;
			background-color: #ffffff;
			color: #39739d;
			font-size: 12px;
			padding: 8px 10.4px;
			border: 1px solid #39739d;
			border-radius: 4px;
			:hover {
				background-color: #b3d3ea;
			}
		}

		> .btn-logout {
			height: 14.546px;
			background-color: #0a95ff;
			color: #ffffff;
			font-size: 12px;
			margin: 0 0 0 4px;
			padding: 8px 10.4px;
			border: 1px solid transparent;
			box-shadow: inset 0 1px 0 0 hsl(0deg 0% 100% / 40%);
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
	> .user-icon {
		display: flex;
		align-items: center;
		margin-right: 5px;
	}
`;

const NavBarLoggedIn = ({ setIsLogin }) => {
	const location = useLocation().pathname;
	const navigate = useNavigate();

	// log out
	const logoutSubmitHandler = () => {
		return axios
			.post('로그아웃 API')
			.then((response) => {
				setIsLogin(false);
			})
			.catch((error) => {
				alert(error);
			});
	};

	// dropdown 메뉴 구현하기
	const [click, setClick] = useState(false);

	useEffect(() => {
		setClick(false);
	}, [location]);

	const handleClick = () => {
		setClick(!click);
	};

	return (
		<NavBarWrapper>
			<div className="nav-bar-wrapper">
				{!(
					location.slice(0, 10) === '/questions' &&
					location !== '/questions/ask'
				) ? (
					<div className="menuBtn" onClick={handleClick}>
						{click ? <GrClose /> : <GrMenu />}
					</div>
				) : (
					''
				)}
				{!(
					location.slice(0, 10) === '/questions' &&
					location !== '/questions/ask'
				) && click ? (
					<div className="dropdown-menu">
						<Dropdown />
					</div>
				) : (
					''
				)}
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
				<NavLink to="/questions" className="btn-displayName">
					<div className="user-icon">
						<FaUserCircle size={16} />
					</div>
					{/* TO-DO: displayName 동적으로 불러오기 -> get으로 displayName 받기?*/}
					emailInfo
				</NavLink>
				{/* TO-DO: Log out API 받으면 버튼 클릭시 실제로 로그아웃되게.. */}
				<NavLink to="/" className="btn-logout" onClick={logoutSubmitHandler}>
					Log out
				</NavLink>
			</div>
		</NavBarWrapper>
	);
};

export default NavBarLoggedIn;
