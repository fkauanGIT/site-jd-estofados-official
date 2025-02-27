import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import Home from '../Pages/HomePage/Home';
import Colchoes from '../Pages/Categorys/Colchoes/Colchoes';
import Camas from '../Pages/Categorys/Camas/Camas';
import Sofas from '../Pages/Categorys/Sofas/sofas';
import Moveis from '../Pages/Categorys/Moveis/Moveis';

const AppRoutes = () => {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/colchoes" element={<Colchoes />} />
        <Route path="/camas" element={<Camas />} />
        <Route path="/Sofas" element={<Sofas />} />
        <Route path="/Moveis" element={<Moveis />} />
      </Routes>
    </Router>
  );
};

export default AppRoutes;