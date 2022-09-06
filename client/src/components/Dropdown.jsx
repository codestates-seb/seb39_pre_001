import { NavLink } from 'react-router-dom';
import styled from 'styled-components';

const DropdownContainer = styled.nav`
	position: relative;
	display: flex;
	flex-direction: column;
	width: 200px;
	height: 500px;
	left: 0;
	top: 0;
	margin: 0;
	background-color: #ffffff;
`;

const LinkWrapper = styled.div`
	margin: 20px 0px;
	display: flex;
	flex-direction: column;
	> div {
		font-size: 11px;
		padding: 10px;
		margin: 10px 8px 4px 8px;
	}
	> .tab-menu {
		color: #525960;
		font-size: 13px;
		text-decoration: none;
		display: flex;
		align-items: center;
		height: 34px;
		padding: 4px 4px 4px 30px;
		margin: 0;
	}
`;

const NavLinkMenu = styled(NavLink)`
	color: #525960;
	font-size: 13px;
	text-decoration: none;
	display: flex;
	align-items: center;
	height: 34px;
	> svg {
		margin: -1px 4px 0px 0px;
	}

	&.home {
		padding: 4px 4px 4px 8px;
	}

	&.question-menu {
		padding: 8px 6px 8px 8px;
	}

	&.tab-menu {
		padding: 4px 4px 4px 30px;
	}

	:hover {
		color: #0c0d0e;
	}

	&.active {
		font-weight: 700;
		color: #0c0d0e;
		background-color: #f1f2f3;
		border-right: 3px solid #f48225;
	}
`;

const Teams = styled.div`
	display: flex;
	flex-direction: column;
	justify-content: center;
	align-items: center;
	border: 1px solid #e3e6e8;
	border-radius: 4px;

	> .orange-button {
		font-size: 11px;
		color: #ffffff;
		background-color: #f48225;
		padding: 6.6px;
		border: 1px solid transparent;
		box-shadow: inset 0 1px 0 0 hsl(0deg 0% 100% / 40%);
		border-radius: 4px;
		width: 139px;
		height: 27.88px;
	}
	> .white-button {
		font-size: 11px;
		color: #6a737c;
		background-color: #ffffff;
		border: none;
		padding: 6.6px;
		width: 139px;
		height: 27.88px;
	}
`;

const Dropdown = () => {
	return (
		<DropdownContainer>
			<LinkWrapper>
				<NavLinkMenu to="/" className="home">
					Home
				</NavLinkMenu>
				<div>PUBLIC</div>
				<NavLinkMenu to="/questions" className="question-menu">
					<svg width="18" height="18" viewBox="0 0 18 18">
						<path d="M9 1C4.64 1 1 4.64 1 9c0 4.36 3.64 8 8 8 4.36 0 8-3.64 8-8 0-4.36-3.64-8-8-8ZM8 15.32a6.46 6.46 0 0 1-4.3-2.74 6.46 6.46 0 0 1-.93-5.01L7 11.68v.8c0 .88.12 1.32 1 1.32v1.52Zm5.72-2c-.2-.66-1-1.32-1.72-1.32h-1v-2c0-.44-.56-1-1-1H6V7h1c.44 0 1-.56 1-1V5h2c.88 0 1.4-.72 1.4-1.6v-.33a6.45 6.45 0 0 1 3.83 4.51 6.45 6.45 0 0 1-1.51 5.73v.01Z"></path>
					</svg>
					Questions
				</NavLinkMenu>
				<div className="tab-menu">Tags</div>
				<div>TEAMS</div>
				<Teams>
					<div className="textbox">
						<strong>Stack Overflow for Teams -</strong>
						Start collaborating and sharing organizational knowledge.
					</div>
					<img
						src="https://cdn.sstatic.net/Img/teams/teams-illo-free-sidebar-promo.svg?v=47faa659a05e"
						width="139"
						height="114"
						alt="promo"
					/>
					<button className="orange-button">Create a free Team</button>
					<button className="white-button">Why Teams?</button>
				</Teams>
			</LinkWrapper>
		</DropdownContainer>
	);
};

export default Dropdown;
