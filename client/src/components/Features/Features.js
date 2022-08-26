import React, { useEffect } from 'react';
import { Container } from '../../globalStyles';
import {
	FeatureText,
	FeatureSection,
	FeatureTitle,
	FeatureWrapper,
	FeatureColumn,
	FeatureImageWrapper,
	FeatureName,
	FeatureImage,
	FeatureTextWrapper,
	FeatureMainText,
} from './FeaturesStyles';
import { featuresData } from '../../data/FeaturesData';
import { useAnimation } from 'framer-motion';
import { useInView } from 'react-intersection-observer';

const Features = ({ id }) => {
	const initial = {
		scale: 0.2,
		y: 40,
		opacity: 0,
	};

	const animation = useAnimation();

	const { ref, inView } = useInView({
		threshold: 0.4,
	});

	useEffect(() => {
		if (inView) {
			animation.start({
				scale: 1,
				y: 0,
				opacity: 1,
			});
		}
	}, [inView, animation]);

	return (
		<FeatureSection id={id}>
			<Container ref={ref}>
				<FeatureTextWrapper
					initial={initial}
					animate={animation}
					transition={{ duration: 0.3 }}
				>
					<FeatureTitle>{featuresData.title}</FeatureTitle>
					<FeatureMainText>{featuresData.text}</FeatureMainText>
				</FeatureTextWrapper>
				<FeatureWrapper>
					{featuresData.content.map((el, index) => (
						<FeatureColumn
							initial={initial}
							animate={animation}
							transition={{ duration: 0.7 + index * 0.1 }}
							key={index}
						>
							<FeatureImageWrapper>
								<FeatureImage src={el.image} alt="feature" />
							</FeatureImageWrapper>
							<FeatureName>{el.name}</FeatureName>
							<FeatureText>{el.description}</FeatureText>
						</FeatureColumn>
					))}
				</FeatureWrapper>
			</Container>
		</FeatureSection>
	);
};

export default Features;
