import React, { useEffect, useState } from 'react';
import { Container, Section } from '../../globalStyles';
import { MasonryGrid, EventImageWrapper, Image, EventHeading } from './EventsSectionStyles';
import { useInView } from 'react-intersection-observer';
import { useAnimation } from 'framer-motion';
import Modal from '../Modal/Modal';
import { ContentButton, ContentHeading, Img, ImgWrapper, Subtitle } from '../Content/ContentStyles';
import { eventsData } from '../../data/EventsData';

const EventsSection = () => {
	const animation = useAnimation();
	const [showModal, setShowModal] = useState(false);
	const [selectedImage, setSelectedImage] = useState(0);
	const { ref, inView } = useInView({
		threshold: 0.2,
	});

	useEffect(() => {
		if (inView) {
			animation.start({
				opacity: 1,
				scale: 1,
			});
		}
	}, [inView, animation]);

	const handleClick = (index) => {
		setShowModal(true);
		setSelectedImage(index);
	};

	return (
		<>
			<Section>
				<Container>
					<EventHeading
						initial={{ opacity: 0, scale: 0.3 }}
						transition={{ duration: 0.4 }}
						animate={animation}
					>
						Find More Events
					</EventHeading>
					<MasonryGrid ref={ref}>
						{eventsData.map((item, index) => (
							<EventImageWrapper
								animate={animation}
								initial={{
									opacity: 0,
									scale: 0.3,
								}}
								transition={{ duration: 0.8 }}
								className={item.class}
								key={index}
								onClick={() => handleClick(index)}
							>
								<Image src={item.img}></Image>
							</EventImageWrapper>
						))}
					</MasonryGrid>
				</Container>
			</Section>
			<Modal show={showModal} onHide={() => setShowModal(false)}>
				<ContentHeading inverse>Title</ContentHeading>
				<ImgWrapper>
					<Img src={eventsData[selectedImage].img} alt="image" />
				</ImgWrapper>
				<Subtitle mt inverse>
					Lorem ipsum dolor sit amet consectetur adipisicing elit. Temporibus omnis
					corrupti officia commodi distinctio nesciunt ex quas quibusdam ipsam
					perspiciatis hic debitis eveniet porro, culpa autem ducimus atque numquam quos.
				</Subtitle>

				<ContentButton inverse>Buy Tickets</ContentButton>
			</Modal>
		</>
	);
};

export default EventsSection;
