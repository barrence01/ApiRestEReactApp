import { useEffect } from "react";
import { useState } from "react";
import { useParams, Link } from "react-router-dom";

export default function FormProduto() {

    let {id} = useParams()

    const [novo, setNovo] = useState({ // Chaves para indicar objeto
        codigo:id,
        titulo:"",
        preco:"",
        quantidade:""
    }) 



    let metodo = "POST" // utilizar o metodo POST por padrão a menos que seja uma alteração, que será tratado pelo if abaixo
    if(id){ //Se tiver um id utilizar o metodo put, pois é uma alteração e não uma inclusão
        metodo = "PUT"
    }



    const handleChange = (event) => {
        setNovo({...novo, [event.target.name]:event.target.value}) //name é o objeto json e o value é o valor que ele obterá
    }

    const handleSubmit = (event) => {
        event.preventDefault() //Evitar refresh da página

        fetch(`http://localhost:8080/LojaApp/rest/produto/${id ? id : ""}`, { //Tenário if(id) {id} else {""}
            method: metodo,
            headers:{
                "Content-Type":"application/json"
            },
            body: JSON.stringify(novo)
        }).then(() => {
            window.location = "/produtos"
        })
    }

    //Atualiza form
    useEffect(() => {
        if(id){
            fetch(`http://localhost:8080/LojaApp/rest/produto/${id}`)
            .then((resposta) => {
                return(resposta.json())
            }).then(data => {
                setNovo(data)
            })
        }
    },[id]) //Atualizar somente quando oid for alterado []


    return (
        <div>
            <h1>Formulário de Produtos</h1>
            <form onSubmit={handleSubmit}>
                <input type="text" name="titulo" value={novo.titulo} placeholder="Título" onChange={handleChange}/>
                <br/>
                <input type="number" name="preco" value={novo.preco} placeholder="Preço" onChange={handleChange} step="0.01"/>
                <br/>
                <input type="number" name="quantidade" value={novo.quantidade} placeholder="Quantidade" onChange={handleChange}/>
                <br/>
                <button>Enviar</button>
                <Link to="/produtos">Cancelar</Link>
            </form>
        </div>
    );
}