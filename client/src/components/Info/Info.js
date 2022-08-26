import React from 'react';
import { infoData } from '../../data/InfoData';

import {
	InfoSection,
	BottomLine,
	Image,
	InfoWrapper,
	InfoNumber,
	InfoText,
	InfoDesc,
	InfoRow,
	InfoColumn,
	InfoHeading,
} from './InfoStyles';

const Info = ({ id }) => {
	const { headline, description, bottomLine } = infoData;

	return (
		<InfoSection id={id}>
			<InfoRow>
				<InfoColumn>
					<Image src="./assets/heromain1.jpg" alt="" />
				</InfoColumn>
				<InfoColumn>
					<InfoWrapper>
						<InfoHeading>{headline}</InfoHeading>
						<InfoDesc>{description}</InfoDesc>

						<BottomLine>
							{bottomLine.map((el, index) => (
								<InfoColumn key={index}>
									<InfoNumber>{el.number}</InfoNumber>
									<InfoText>{el.numberText}</InfoText>
								</InfoColumn>
							))}
						</BottomLine>
					</InfoWrapper>
				</InfoColumn>
			</InfoRow>
		</InfoSection>
	);
};

export default Info;
