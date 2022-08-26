import React from 'react';
import GlobalStyle from './globalStyles';
import HomePage from './pages/HomePage';
import SignupPage from './pages/SignupPage';
import {
	BrowserRouter,
	Routes,
	Route,
	Link
  } from "react-router-dom";
import Footer from './components/Footer/Footer';

function App() {
	return (
		<BrowserRouter>
			<GlobalStyle />
			<Routes>
				<Route exact path="/" component={HomePage} />
				<Route path="/sign-up" component={SignupPage} />
			</Routes>
			<Footer />
		</BrowserRouter>
	);
}

export default App;
