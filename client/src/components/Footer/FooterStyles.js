import styled from 'styled-components';
import { Link } from 'react-router-dom';
import { dark } from '../../data/GlobalData';

export const FooterContainer = styled.div`
	background-color: ${dark};
	padding: 4rem 0 2rem 0;
	display: flex;
	flex-direction: column;
	justify-content: center;
	align-items: center;
`;

export const FooterLinksContainer = styled.div`
	width: 100%;
	max-width: 1000px;
	display: flex;
	justify-content: center;

	@media screen and (max-width: 820px) {
		padding-top: 32px;
	}
`;

export const FooterLinksWrapper = styled.div`
	display: flex;
	flex-wrap: wrap;
	@media screen and (max-width: 820px) {
		/* flex-direction: column; */
		justify-content: center;
	}
`;

export const FooterLinkItems = styled.div`
	display: flex;
	flex-direction: column;
	align-items: flex-start;
	margin: 16px;
	width: 160px;
	box-sizing: border-box;
	color: #fff;

	@media screen and (max-width: 420px) {
		margin: 0;
		padding: 10px;
		width: 100%;
		align-items: center;
	}
`;

export const FooterLinkTitle = styled.h2`
	margin-bottom: 16px;
`;

export const FooterLink = styled(Link)`
	color: #fff;
	text-decoration: none;
	margin-bottom: 0.5rem;

	&:hover {
		color: #0467fb;
		transition: 0.3s ease-out;
	}
`;

export const SocialMedia = styled.section`
	max-width: 1000px;
	width: 100%;
`;

export const SocialMediaWrap = styled.div`
	display: flex;
	justify-content: space-between;
	align-items: center;
	width: 90%;
	max-width: 1000px;
	margin: 40px auto 0 auto;

	@media screen and (max-width: 820px) {
		flex-direction: column;
	}
`;

export const SocialLogo = styled(Link)`
	color: #fff;
	justify-self: start;
	cursor: pointer;
	text-decoration: none;
	font-size: 2rem;
	display: flex;
	align-items: center;
	margin-bottom: 16px;
`;

export const SocialIcon = styled.img`
	margin-right: 10px;
	width: 40px;
`;

export const WebsiteRights = styled.small`
	color: #fff;
	margin-bottom: 16px;
`;

export const SocialIcons = styled.div`
	display: flex;
	justify-content: space-between;
	align-items: center;
	width: 240px;
`;

export const SocialIconLink = styled.a`
	color: #fff;
	font-size: 24px;
`;
