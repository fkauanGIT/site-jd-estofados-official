import { Link } from "react-router-dom";
import "./Nav.css"

const Nav = () => {
    return (
        <header>
            <div className="nav">
                <div className="navLinks">
                    <div className="navLogo">
                        <Link to={"/"}>
                            <h1>Loja de Móveis</h1>
                        </Link>
                    </div>
                    <div className="navItems">
                        <Link to={"/Colchoes"}>Colchões</Link>
                        <Link to={"/Camas"}>Camas</Link>
                        <Link to={"/Moveis"}>Móveis</Link>
                        <Link to={"/Sofas"}>Sofá</Link>
                        <Link to={"/Sobrenos"}>Sobre Nós</Link>
                    </div>
                </div>
                <div className="navOthers">
                    <input type="search" placeholder="Buscar..."/>
                    <div className="navOthersIcons">
                        <svg xmlns="http://www.w3.org/2000/svg" width="40" height="40" fill="#fff" className="bi bi-person" viewBox="0 0 16 16">
                            <path d="M8 8a3 3 0 1 0 0-6 3 3 0 0 0 0 6m2-3a2 2 0 1 1-4 0 2 2 0 0 1 4 0m4 8c0 1-1 1-1 1H3s-1 0-1-1 1-4 6-4 6 3 6 4m-1-.004c-.001-.246-.154-.986-.832-1.664C11.516 10.68 10.289 10 8 10s-3.516.68-4.168 1.332c-.678.678-.83 1.418-.832 1.664z"/>
                        </svg>

                        <svg xmlns="http://www.w3.org/2000/svg" width="40" height="40" fill="#fff" className="bi bi-cart" viewBox="0 0 16 16">
                            <path d="M0 1.5A.5.5 0 0 1 .5 1H2a.5.5 0 0 1 .485.379L2.89 3H14.5a.5.5 0 0 1 .491.592l-1.5 8A.5.5 0 0 1 13 12H4a.5.5 0 0 1-.491-.408L2.01 3.607 1.61 2H.5a.5.5 0 0 1-.5-.5M3.102 4l1.313 7h8.17l1.313-7zM5 12a2 2 0 1 0 0 4 2 2 0 0 0 0-4m7 0a2 2 0 1 0 0 4 2 2 0 0 0 0-4m-7 1a1 1 0 1 1 0 2 1 1 0 0 1 0-2m7 0a1 1 0 1 1 0 2 1 1 0 0 1 0-2" />
                        </svg>
                    </div>
                </div>
            </div>
        </header>
    );
};

export default Nav;