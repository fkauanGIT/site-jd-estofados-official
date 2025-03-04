import React, { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import axios from "axios";
import { Product } from "../../Models/Product";
import "./ProductDetails.css"
import Nav from "../../Components/Nav/Nav";

const ProdutoDetalhes: React.FC = () => {
  const { id } = useParams<{ id: string }>();
  const [produto, setProduto] = useState<Product | null>(null);

  useEffect(() => {
    axios.get<Product>(`http://localhost:8080/api/products/${id}`)
      .then((response) => setProduto(response.data))
      .catch((error) => console.error("Erro ao buscar o produto:", error));
  }, [id]);

  if (!produto) {
    return <p>Carregando...</p>;
  }

  return (
    <div>
       <Nav />
    <div className="produto-detalhes">
      <div>
      <img src={produto.image_url} alt={produto.name} className="img"/>
      </div>
      <div className="items">
      <h1>{produto.name}</h1>
      <p>{produto.description}</p>
      <p>Preço: R$ {produto.price.toFixed(2)}</p>
      {produto.discount && <p className="desconto">Desconto: R$ {produto.discount.toFixed(2)}</p>}
      <button>Adicionar ao carrinho</button>
      </div>
    </div>
    </div>
  );
};

export default ProdutoDetalhes;
