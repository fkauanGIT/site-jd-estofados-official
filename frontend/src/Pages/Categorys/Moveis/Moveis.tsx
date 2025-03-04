import { useState, useEffect } from "react";
import axios from "axios";
import { Product } from "../../../Models/Product"; // Ajuste o caminho se necessário
import Nav from "../../../Components/Nav/Nav";
import Card from "../../../Components/Card/Card"; // Importando o componente Card

const Colchoes = () => {
  const [products, setProducts] = useState<Product[]>([]); // Estado tipado corretamente

  useEffect(() => {
    axios
      .get<Product[]>("http://localhost:8080/api/products")
      .then((response) => {
        // 🔹 Filtrando apenas os produtos da categoria "Colchões"
        const colchaoProducts = response.data.filter(
          (product) => product.category.toLowerCase() === "moveis"
        );
        setProducts(colchaoProducts);
      })
      .catch((error) => console.error("Erro ao buscar produtos:", error));
  }, []);

  return (
    <div className="body">
      <Nav />
      <h1>Móveis</h1>
      <div className="cards_products_colchoes">
        {products.length === 0 ? (
          <p>Nenhum colchão encontrado.</p>
        ) : (
          products.map((product) => (
            <Card key={product.id} produto={product} />
          ))
        )}
      </div>
    </div>
  );
};

export default Colchoes;
