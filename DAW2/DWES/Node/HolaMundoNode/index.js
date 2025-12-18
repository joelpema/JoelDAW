// Este programa imprime un mensaje en la consola
console.log("Hola Mundo desde Node.js de Joel Pereda Martinez");

import chalk from 'chalk';
import moment from 'moment';

 console.log(chalk.blue("Texto azul"));
 console.log(chalk.green("Texto verde"));
 console.log(chalk.red.bold("Texto rojo y en negrita"));

console.log("Fecha actual:", moment().format("YYYY-MM-DD HH:mm:ss"));