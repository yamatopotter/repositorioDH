import { useState, useEffect } from "react";
import api from "../../services/api";
import { Link } from "react-router-dom";
import "./styles.css";

const Home = () => {
   const [products, setProducts] = useState([]);
   const [formData, setFormData] = useState({
    name: "",
    description: "",
    price: "",
    manufacturer: "",
    image: ""
  });

  useEffect(() => {getProducts();}, [])

  async function getProducts(){
    try{
        const response = await api.get("/products");
        setProducts(response.data);
    }
    catch(error){
        alert(error);
    }
  }

  async function addProduct(){
    try{
        await api.post("/products", {
            name: formData.name,
            description: formData.description,
            price: formData.price,
            manufacturer: formData.manufacturer,
            image: formData.image
        });  
    
        getProducts();
        clearFormData();
    }
    catch(error){
        alert(error);
    }
  }

  async function updateProduct(){
    try{
        await api.put(`/products/${formData._id}`, {
            name: formData.name,
            price: formData.price,
            description: formData.description,
            manufacturer: formData.manufacturer,
            image: formData.image
        });   

        getProducts();
        clearFormData();
    }
    catch(error){
        alert(error);
    }
  }

  async function deleteProduct(id){
    try{
        await api.delete(`/products/${id}`);
        getProducts();
    }
    catch(error){
        alert(error);
    }
  }

  async function editProduct(id){
    try{
        const response = await api(`/products/${id}`);
        setFormData(response.data);
    }
    catch(error){
        alert(error)
    }
  }

  function clearFormData(){
    setFormData({name: "",
    description: "",
    price: "",
    manufacturer: "",
    image: ""});
  }

  return (
    <div className="container">
      <form>
        <h2>{(formData._id) ? formData.name : "Cadastrar Produto"}</h2>
        <input
          placeholder="Nome"
          value={formData.name}
          onChange={(event) =>
            setFormData({ ...formData, name: event.target.value })
          }
        />
        <input
          placeholder="Preço"
          value={formData.price}
          onChange={(event) =>
            setFormData({ ...formData, price: event.target.value })
          }
        />
        <input
          placeholder="Fabricante"
          value={formData.manufacturer}
          onChange={(event) =>
            setFormData({ ...formData, manufacturer: event.target.value })
          }
        />
        <input
          placeholder="Image"
          value={formData.image}
          onChange={(event) =>
            setFormData({ ...formData, image: event.target.value })
          }
        />
        <textarea
          placeholder="Descrição"
          value={formData.description}
          onChange={(event) =>
            setFormData({ ...formData, description: event.target.value })
          }
        />
        <button type="button" onClick={() => {(formData._id) ? updateProduct() : addProduct()}}>
          Salvar
        </button>

       
        <button type="button" onClick={() => {clearFormData}} style={(formData._id) ? {display: 'block'} : {display: 'none'} }>
          Cancelar Alteração
        </button>
      </form>

      <div className="products">
        <h1>Produtos</h1>

        <div className="row">
        {products.map((product) => {
            return (
                <div className="container-item" key={product._id}>
                    <Link to={`/details/${product._id}`} >
                        <h2>{product.name}</h2>
                        <img src={product.image} />
                        <p>
                        {product.price} €
                        </p>
                    </Link>

                    <button onClick={() => {deleteProduct(product._id)}}>Excluir Produto</button>
                    <button onClick={() => {editProduct(product._id)}}>Editar Produto</button>
                </div>
            );}
        )}
      </div>

      </div>
    </div>
  );
};

export default Home;