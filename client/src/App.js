import {BrowserRouter as Router, Routes, Route} from "react-router-dom";
import {About} from "./pages/about";
import {Product} from "./pages/product";
import {ForTeams} from "./pages/forTeams";
import { Navbar } from "./components/Navbar/navbar";



function App() {
  return (
   <Router>
    <Navbar />
    <Routes>
      <Route path="/about" exact element={<About/>} />
      <Route path="/product" exact element={<Product/>} />
      <Route path="/forTeams" exact element={<ForTeams/>} />
    </Routes>
   </Router>
  );
}

export default App;
