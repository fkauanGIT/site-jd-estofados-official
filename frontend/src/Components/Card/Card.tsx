import React from "react";
import { Product } from "../../Models/Product"; // Importando o modelo
import "./Card.css";

// Definindo as props do componente Card
interface CardProps {
  produto: Product; // Usando o modelo Produto
  onBuy: () => void;
}

const Card: React.FC<CardProps> = ({ produto, onBuy }) => {
  return (
    <div className="card">
      <img src={produto.imagem} alt={produto.nome} className="card-image" />
      <div className="card-content">
        <h3 className="card-title">{produto.nome}</h3>
        <p className="card-description">{produto.descricao}</p>
        <p className="card-price-descont">R$ {produto.precoDescont.toFixed(2)}</p>
        <p className="card-price">R$ {produto.preco.toFixed(2)}</p>
        <button onClick={onBuy} className="card-button">
          Comprar
        </button>
      </div>
    </div>
  );
};

export default Card;