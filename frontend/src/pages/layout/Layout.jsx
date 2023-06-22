import { Outlet, Link } from "react-router-dom";

import "./Layout.css";
import Footer from "./Footer.jsx";

const Layout = () => (
  <div className="Layout">
    <nav>
      <ul>
        <li className="grow">
          <Link to="/">Collect Your Collections</Link>
        </li>
        <li>
          <Link to="/Login">
            <button type="button">Login</button>
          </Link>
        </li>
        <li>
          <Link to="/register">
            <button type="button">Register</button>
          </Link>
        </li>
      </ul>
    </nav>
    <Outlet />
    <Footer />
  </div>
);

export default Layout;
