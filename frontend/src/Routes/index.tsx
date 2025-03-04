import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import Home from '../Pages/HomePage/Home';
import Colchoes from '../Pages/Categorys/Colchoes/Colchoes';
import Camas from '../Pages/Categorys/Camas/Camas';
import Sofas from '../Pages/Categorys/Sofas/sofas';
import Moveis from '../Pages/Categorys/Moveis/Moveis';
import ProdutoDetalhes from '../Pages/ProductDetails/ProductDetails'; // Importe a página de detalhes do produto

const AppRoutes = () => {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/colchoes" element={<Colchoes />} />
        <Route path="/camas" element={<Camas />} />
        <Route path="/sofas" element={<Sofas />} />
        <Route path="/moveis" element={<Moveis />} />
        <Route path="/produto/:id" element={<ProdutoDetalhes />} /> {/* Adicionada a rota de detalhes do produto */}
      </Routes>
    </Router>
  );
};

export default AppRoutes;
