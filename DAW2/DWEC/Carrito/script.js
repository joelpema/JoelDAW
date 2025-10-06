import  Productos  from "./Productos.js";
import  {data}  from "./carrito.js";

const productos = [];

data.products.forEach((p) => {

const producto = new Productos(p.SKU, p.title, p.price);


productos.push(producto); 


});

console.log(productos);



const tbody = document.getElementById("tabla");

    data.products.forEach((producto) =>{

    const fila = document.createElement("tr");

    const tdSku = document.createElement("td");
    tdSku.innerHTML= producto.title + "<br>" + producto.SKU;

    const tdCantidad = document.createElement("td");

    const btn_resta = document.createElement("button");
    

    const inputObjetos = document.createElement("input");
    

    const btn_suma = document.createElement("button");

    btn_suma.textContent = "+";
    btn_resta.textContent = "-";

    btn_suma.classList.add("btn");
    btn_resta.classList.add("btn");

    const sumaPrecios = producto.price * valorActual;

    btn_suma.addEventListener("click", function () {

    let valorActual = Number(inputObjetos.value);

    valorActual++;

    inputObjetos.value = valorActual;


    });

    btn_resta.addEventListener("click", function () {

    let valorActual = Number(inputObjetos.value);

    valorActual--;

    inputObjetos.value = valorActual;

    });


    const tdUnidad = document.createElement("td");
    tdUnidad.textContent = producto.price;
    
    

    const tdTotal = document.createElement("td");
    tdTotal.value = sumaPrecios; 
    

    fila.appendChild(tdSku);
    fila.appendChild(tdCantidad);
    tdCantidad.append(btn_resta, inputObjetos, btn_suma);
    fila.appendChild(tdUnidad);
    fila.appendChild(tdTotal);
    tdTotal.append(sumaPrecios);
    tbody.appendChild(fila);
});


function click(){

}








