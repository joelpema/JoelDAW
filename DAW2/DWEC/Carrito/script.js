import  Productos  from "./Productos.js";
import  {data}  from "./carrito.js";

const productos = [];

data.products.forEach((p) => {

const producto = new Productos(p.SKU, p.title, p.price);


productos.push(producto); 


});

console.log(productos);



const tbody = document.getElementById("tabla");



    productos.forEach((products) =>{
    const fila = document.createElement("tr");

    const tdSku = document.createElement("td");
    tdSku.textContent = productos.SKU;

    const tdProducto = document.createElement("td");
    tdProducto.textContent = productos.title;

    const tdPrecio = document.createElement("td");
    tdPrecio.textContent = productos.price;

    fila.appendChild(tdSku);
    fila.appendChild(tdProducto);
    fila.appendChild(tdPrecio);
    tbody.appendChild(fila);

});









