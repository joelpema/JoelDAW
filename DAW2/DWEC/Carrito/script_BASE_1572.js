import Productos from "./Productos.js";
import { data } from "./carrito.js";

const productos = [];

data.products.forEach((p) => {
    const producto = new Productos(p.SKU, p.title, p.price);
    productos.push(producto);
});
document.addEventListener("DOMContentLoaded", function () {

    fetch('http://localhost:8080/api/carrito')
        .then(response => {
            if (!response.ok) {
                throw new Error('Error al cargar el JSON');
            }
            return response.json();
        })
        .then(data => {
            


    console.log(productos);

    const tbody = document.getElementById("tabla");

    data.products.forEach((producto) => {
        const fila = document.createElement("tr");


        const tdSku = document.createElement("td");
        tdSku.innerHTML = producto.title + "<br>" + producto.SKU;


        const tdCantidad = document.createElement("td");

        const btn_resta = document.createElement("button");
        const inputObjetos = document.createElement("input");
        inputObjetos.classList.add('inputNumeros');
        const btn_suma = document.createElement("button");

        inputObjetos.readOnly = true;
        inputObjetos.value = 0;
        let valorActual = 0;

        btn_suma.textContent = "+";
        btn_resta.textContent = "-";
        btn_suma.classList.add("btn");
        btn_resta.classList.add("btn");

        btn_suma.addEventListener("click", function () {
            valorActual++;
            inputObjetos.value = valorActual;
            actualizarTotal();
            actualizarTablaTotal();
            calcularTotal();
        });

        btn_resta.addEventListener("click", function () {
            valorActual--;
            if (valorActual < 0) {
                valorActual = 0;
            }
            inputObjetos.value = valorActual;
            actualizarTotal();
            actualizarTablaTotal();
            calcularTotal();
        });


        const precio = Number(producto.price);

        const tdUnidad = document.createElement("td");
        tdUnidad.textContent = precio.toFixed(2) + data.currency;

        const tdTotal = document.createElement("td");
        tdTotal.textContent = "0.00 €";

        let total = 0;

        const actualizarTotal = () => {
            total = (valorActual * precio).toFixed(2) + data.currency;
            tdTotal.textContent = total;
        };



        fila.appendChild(tdSku);
        fila.appendChild(tdCantidad);
        tdCantidad.append(btn_resta, inputObjetos, btn_suma);
        fila.appendChild(tdUnidad);
        fila.appendChild(tdTotal);
        tbody.appendChild(fila);



        const tbody2 = document.getElementById("tablaTotal");
        const fila2 = document.createElement("tr");

        const actualizarTablaTotal = () => {
            
            const valorTotal = producto.title + " " +  total + " " + valorActual;
            ifhoneTabla.textContent = valorTotal;
            
        }

        const ifhoneTabla = document.createElement("td");



        const cargadorTabla = document.createElement("td");
        const fundaTabla = document.createElement("td");


        fila2.appendChild(ifhoneTabla);
        fila2.appendChild(cargadorTabla);
        fila2.appendChild(fundaTabla);

        tbody2.appendChild(fila2);




    });

    console.log("Datos cargados:", data);

                // Ejemplo: mostrar los productos en pantalla
                const lista = document.getElementById('lista-productos');

                data.productos.forEach(producto => {
                    const item = document.createElement('li');
                    item.textContent = `${producto.nombre} - ${producto.precio} €`;
                    lista.appendChild(item);
                });
            })
            .catch(error => console.error(error));



});

