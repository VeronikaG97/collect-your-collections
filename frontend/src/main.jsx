import React from 'react'
import ReactDOM from 'react-dom/client'
import {createBrowserRouter, createRoutesFromElements, Route, RouterProvider} from "react-router-dom";

import './index.css'
import Layout from "./pages/layout/index.js";
import WelcomePage from "./component/WelcomePage.jsx";
import CollectionsTable from "./component/CollectionsTable.jsx";

const router = createBrowserRouter(
    createRoutesFromElements(
        <Route path={"/"} element={<Layout />}>
            <Route path={"/"} element={<WelcomePage />}/>
            <Route path={"/logged-in"} element={<CollectionsTable />}/>
        </Route>
    )
)


ReactDOM.createRoot(document.getElementById('root')).render(
  <React.StrictMode>
    <RouterProvider router={router} />
  </React.StrictMode>,
)
