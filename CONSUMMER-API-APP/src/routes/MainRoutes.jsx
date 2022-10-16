import React from "react";
import { Routes, Route } from "react-router-dom";
import FormProduto from "../components/FormProduto";

import Home from "../components/Home";
import Produtos from "../components/Produtos";

export default function MainRoutes() {
    return (

        <Routes>
            <Route path="/" element={<Home />} />
            <Route path="/produtos" element={<Produtos />} />
            <Route path="/incluir" element={<FormProduto />} />
            <Route path="/editar/:id" element={<FormProduto />} />
        </Routes>
      
    )
}