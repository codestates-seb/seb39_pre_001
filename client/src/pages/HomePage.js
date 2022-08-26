import React from 'react';
import Content from '../components/Content/Content';
import EventsSection from '../components/EventsSection/EventsSection';
import Features from '../components/Features/Features';
import Hero from '../components/Hero/Hero';
import Info from '../components/Info/Info';
import { heroData } from '../data/HeroData';

const HomePage = () => {
	return (
		<>
			<Hero />
			<Info id="about" />
			<Features id="programs" />

			<div id="events">
				{heroData.map((contentData, index) => (
					<Content {...contentData} key={index} />
				))}
				<EventsSection />
			</div>
		</>
	);
};

export default HomePage;
