import React from 'react';

import { GiPartyFlags, GiMicrophone } from 'react-icons/gi';
import { TiGroupOutline } from 'react-icons/ti';
const iconStyle = (Icon) => <Icon size="3rem" color="red" />;

export const featuresData = {
	title: 'Our Programs',
	text: "We're a fast-growing event company in Europe and North America. Now in its 11-th year. Ezent has grown to over 2,000 events annually, which makes it one of the most famous event advertising platforms",
	content: [
		{
			name: 'Networking',
			description: 'Meet wonderful people that share your interests and make friends',
			icon: iconStyle(TiGroupOutline),
			image: './assets/features/Network.svg',
		},
		{
			name: 'Best Events',
			description: 'We host the sell tickets to various most desirable events ',
			icon: iconStyle(GiMicrophone),
			image: './assets/features/Speech.svg',
		},
		{
			name: 'Fun',
			description: 'We help you making the events more fun',
			icon: iconStyle(GiPartyFlags),
			image: './assets/features/Fun.svg',
		},
	],
};
