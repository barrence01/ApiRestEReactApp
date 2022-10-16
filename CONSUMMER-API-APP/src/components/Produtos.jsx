import React from "react";
import { useState, useEffect } from 'react'
import { Link } from "react-router-dom";

import {AiFillDelete as Ex} from 'react-icons/ai' // Botão de excluir do react icons
import {RiEdit2Fill as Ed} from 'react-icons/ri' // Botão de editar do react icons

export default function Produtos() {


    // Função para consumir a API
    //LISTA DE PRODUTOS
    const [produtos, setProdutos] = useState([])

    //CRIANDO O USE-EFFECT PARA CHAMAR O FETCH ASSINCRONO(FUNÇÃO ASSINCRONA)
    //Assincrono: Não é executado na ordem, é executado quando o sistema estiver pronto para executar
    useEffect(() => {
        
        //FUNÇÃO ASSINCRONA
        // const getProdutos = async () => {
        //     const response = await fetch('http://localhost:8080/LojaApp/rest/produto/') // const que recebe a resposta da requisição
        //     const data = await response.json() // const que recebe a resposta convertida em formato json
        //     setProdutos(data)
        // }
        // getProdutos()
        fetch('http://localhost:8080/LojaApp/rest/produto/').then((resposta) => { // const que recebe a resposta da requisição e atribui a resposta a uma variável chamada "resposta"
            return resposta.json(); // retorna a resposta convertida em formato json
        }).then((resposta) => {
            setProdutos(resposta); // atribui a resposta convertida em formato json ao useState "produtos"
        }).catch((error) => { // caso ocorra algum erro, o catch captura o erro e o exibe no console
            console.log(error)
        })
    }, []) // O useEffect é executado apenas uma vez, quando o componente é montado

    const handleDelete = (id) => {
        fetch(`http://localhost:8080/LojaApp/rest/produto/${id}`, {
            method: 'DELETE'
        }) .then(() => { // .then() é uma função que é executada após a execução do fetch
            window.location = "/produtos"
        }) .catch((error) => { // caso ocorra algum erro, o catch captura o erro e o exibe no console
            console.log(error)
        })
    }


    return (
        <div> 
        <h1>API-REST / PRODUTOS</h1>  
        
            <Link to="/incluir">Inserir Produto</Link>
            <table border={1}>
                <tr>
                    <th>Código</th>
                    <th>Título</th>
                    <th>Preço</th>
                    <th>Quantidade</th>
                    <th> Editar / Excluir </th>
                </tr>
                <tbody>
                    {produtos.map((produto, i) => 
                        <tr key={i}>
                            <td>{produto.codigo}</td>
                            <td>{produto.titulo}</td>
                            <td>{produto.preco}</td>
                            <td>{produto.quantidade}</td>
                            <td><Link to={`/editar/${produto.codigo}`}><Ed/></Link> | <Ex onClick={handleDelete.bind(this, produto.codigo)} style={{cursor:'pointer'}}/> </td>
                        </tr>
                    )}
                </tbody>
                <tfoot><tr>
                    <td colSpan={5}>Produtos do Servidor</td>
                    </tr></tfoot>
            </table>
        </div>
    )
}