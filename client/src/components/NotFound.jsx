import styled from 'styled-components';

const NotFoundWrapper = styled.div`
	display: flex;
	flex-direction: column;
	justify-content: center;
	align-items: center;
	height: calc(100vh - 443.86px);
	width: 100%;
`;

const NotFound = () => {
	return (
		<NotFoundWrapper>
			<h1>😵 404 Not Found</h1>
			<h3>Something went wrong...</h3>
		</NotFoundWrapper>
	);
};

export default NotFound;
