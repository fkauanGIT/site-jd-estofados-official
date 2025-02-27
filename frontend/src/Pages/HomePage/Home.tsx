
import Card from "../../Components/Card/Card";
import Nav from "../../Components/Nav/Nav";
import { Product } from "../../Models/Product";
import "./Home.css"


const Home = () => {

  const handleBuy = (produto: Product) => {
    console.log("Produto comprado:", produto);
    alert(`Você comprou: ${produto.nome}`);
  };
  

  return (
    <> 
        <Nav />

        <div className="titlle">
          <h1>Bem-vindo à nossa loja!</h1>
          <p>Confira nossos produtos incríveis.</p>
        </div>

        <div className="card-container">
        {produtos.map((produto) => (
          <Card
            key={produto.id}
            produto={produto}
            onBuy={() => handleBuy(produto)}
          />
        ))}
      </div>
    </>
  );
};

const produtos: Product[] = [
  {
    id: 1,
    nome: "Colchão Ortopédico",
    descricao: "Conforto e suporte para uma noite de sono perfeita.",
    precoDescont: 1200,
    preco: 1200.0,
    imagem: "https://via.placeholder.com/300",
    categoria: "Colchões",
  },
  {
    id: 2,
    nome: "Sofá Retrátil",
    descricao: "Sofá confortável e moderno para sua sala.",
    precoDescont: 1200,
    preco: 2500.0,
    imagem: "https://via.placeholder.com/300",
    categoria: "Sofás",
  },
  {
    id: 3,
    nome: "Cama Queen Size",
    descricao: "Cama espaçosa com design elegante.",
    precoDescont: 1200,
    preco: 1800.0,
    imagem: "https://via.placeholder.com/300",
    categoria: "Camas",
  },
];

export default Home;