import { useEffect, useState } from "react";
import { useLocation } from "react-router-dom";
import axios from "axios";
import { Product } from "../../Models/Product"; // Import the Product interface
import Card from "../../Components/Card/Card";
import Nav from "../../Components/Nav/Nav";

const SearchResults = () => {
    const [products, setProducts] = useState<Product[]>([]); // State for products
    const [isLoading, setIsLoading] = useState(false); // State for loading
    const [error, setError] = useState<string | null>(null); // State for error handling
    const location = useLocation(); // Hook to access the current URL
    const searchParams = new URLSearchParams(location.search); // Extract URL parameters
    const searchTerm = searchParams.get("name"); // Get the search term

    useEffect(() => {
        const fetchProducts = async () => {
            if (!searchTerm) return; // Don't fetch if there's no search term

            setIsLoading(true);
            setError(null);

            try {
                const response = await axios.get<Product[]>(
                    `http://localhost:8080/api/products/search?name=${searchTerm}`
                );
                setProducts(response.data); // Update state with fetched products
            } catch (error) {
                console.error("Erro ao buscar produtos:", error);
                setError("Erro ao buscar produtos. Tente novamente mais tarde.");
            } finally {
                setIsLoading(false);
            }
        };

        fetchProducts(); // Fetch products when the search term changes
    }, [searchTerm]);

    return (
        <div>
            <Nav />
            <h2>Resultados da busca para: "{searchTerm}"</h2>

            {isLoading && <p>Carregando...</p>} {/* Show loading message */}

            {error && <p style={{ color: "red" }}>{error}</p>} {/* Display error message */}

            {!isLoading && !error && products.length === 0 && (
                <p>Nenhum produto encontrado.</p> // Display message if no products are found
            )}

            <div style={{ display: "flex", flexWrap: "wrap", gap: "16px" }}>
                {products.map((product) => (
                    <Card key={product.id} produto={product} /> // Use `produto` prop
                ))}
            </div>
        </div>
    );
};

export default SearchResults;