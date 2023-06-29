import React from 'react'
import ReactDOM from 'react-dom/client'
import {createBrowserRouter, createRoutesFromElements, Route, RouterProvider} from "react-router-dom";

import './index.css'
import Layout from "./pages/layout/index.js";
import WelcomePage from "./component/WelcomePage.jsx";
import BookService from "./component/BookService.jsx";
import CreateBook from "./pages/CreateBook.jsx";

const router = createBrowserRouter(
    createRoutesFromElements(
        <Route path={"/"} element={<Layout />}>
            <Route path={"/"} element={<WelcomePage />}/>
            <Route path={"/logged-in"} element={<BookService />}/>
            <Route path={"/createBook"} element={<CreateBook />}/>
        </Route>
    )
)


ReactDOM.createRoot(document.getElementById('root')).render(
  <React.StrictMode>
    <RouterProvider router={router} />
  </React.StrictMode>,
)
