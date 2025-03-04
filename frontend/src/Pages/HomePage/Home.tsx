import { useEffect, useState, useCallback } from "react";
import Card from "../../Components/Card/Card";
import Nav from "../../Components/Nav/Nav";
import { Product } from "../../Models/Product";
import "./Home.css";

const Home = () => {
  const [bestSellers, setBestSellers] = useState<Product[]>([]);
  const [promotions, setPromotions] = useState<Product[]>([]);

  const fetchProducts = useCallback(async (endpoint: string, setter: (data: Product[]) => void) => {
    try {
      const response = await fetch(`http://localhost:8080/api/products/${endpoint}`);
      if (!response.ok) throw new Error(`Erro ao buscar ${endpoint}`);
      const data = await response.json();
      setter(data);
    } catch (error) {
      console.error(error);
    }
  }, []);

  useEffect(() => {
    fetchProducts("bestsellers", setBestSellers);
    fetchProducts("promotions", setPromotions);
  }, [fetchProducts]);


  return (
    <>
      <Nav />
      <div className="titlle">
        <h1>Bem-vindo à nossa loja!</h1>
        <h3>Confira nossos produtos incríveis.</h3>
      </div>

      {[{ title: "Mais Vendidos", products: bestSellers }, { title: "Promoções", products: promotions }].map(
        ({ title, products }) => (
          <section key={title}>
            <h2>{title}</h2>
            <div className="card-container">
              {products.map((produto) => (
                <Card key={produto.id} produto={produto} />
              ))}
            </div>
          </section>
        )
      )}
    </>
  );
};

export default Home;
