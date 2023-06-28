import React from "react";
import {Link} from "react-router-dom";
import "../pages/layout/Layout.css"
const WelcomePage = () => {
  return(
      <>
          <nav>
              <div className={"btn-div-for-login-and-register"}>
                  <ul>
                      <li>
                          <Link to="/Login">
                              <button className={"btn-left"} type="button">Login</button>
                          </Link>
                      </li>
                      <li>
                          <Link to="/register">
                              <button type="button">Register</button>
                          </Link>
                      </li>
                  </ul>
              </div>
          </nav>
          <p>Welcome to Collect Your Collections!</p>
      </>
  );
}

export default WelcomePage;