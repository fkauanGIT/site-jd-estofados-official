import React from "react";
import { Product } from "../../Models/Product"; // Importando o modelo
import "./Card.css";
import { Link } from "react-router-dom";

// Definindo as props do componente Card
interface CardProps {
  produto: Product; // Usando o modelo correto
}

const Card: React.FC<CardProps> = ({ produto }) => {
  return (
    <div className="card">
      <img src={produto.image_url} alt={produto.name} className="card-image" />
      <div className="card-content">
        <h3 className="card-title">{produto.name}</h3>
        <p className="card-description">{produto.description}</p>
        <p className="card-price-descont">
          R$ {produto.discount ? produto.discount.toFixed(2) : "0.00"}
        </p>
        <p className="card-price">
          R$ {produto.price ? produto.price.toFixed(2) : "0.00"}
        </p>
        <Link to={`/produto/${produto.id}`} className="card-button">
            Comprar
        </Link>
      </div>
    </div>
  );
};

export default Card;
