import React, { useRef, useEffect } from 'react';
import { AnimatePresence } from 'framer-motion';
import { Background, CloseModalButton, ModalWrapper } from './ModalStyles';

const Modal = ({ show, onHide, children }) => {
	const modalRef = useRef();

	const closeModal = (e) => {
		if (modalRef.current === e.target) {
			onHide();
		}
	};

	const backgroundVariants = {
		initial: {
			opacity: 0,
		},
		animate: {
			opacity: 1,
			transition: {
				duration: 0.4,
			},
		},
	};

	const modalVariants = {
		initial: {
			opacity: 0,
			y: 200,
		},
		animate: {
			opacity: 1,
			y: 0,
			transition: {
				duration: 0.4,
				type: 'spring',
				stiffness: 100,
			},
		},
		exit: {
			opacity: 0,
			y: -200,
		},
	};

	useEffect(() => {
		if (show) {
			document.body.style.overflow = 'hidden';
		} else {
			document.body.style.overflow = 'visible';
		}
	}, [show]);

	return (
		<AnimatePresence>
			{show && (
				<Background
					variants={backgroundVariants}
					animate="animate"
					initial="initial"
					onClick={closeModal}
					ref={modalRef}
					exit={{
						opacity: 0,
					}}
				>
					<ModalWrapper
						variants={modalVariants}
						animate="animate"
						initial="initial"
						exit={{
							opacity: 0,
							y: '-100vh',
						}}
					>
						{children}
						<CloseModalButton aria-label="Close modal" onClick={onHide} />
					</ModalWrapper>
				</Background>
			)}
		</AnimatePresence>
	);
};

export default Modal;
