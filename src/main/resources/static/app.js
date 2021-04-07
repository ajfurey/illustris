const express = require("express");
const path = require('path');
const mysql = require("mysql");
const dotenv = require('dotenv');


const app = express();

const db = mysql.createConnection({
host: 'localhost',
user: 'root', 
password: 'Ospigon@1970',
database: 'test1',

});

const publicDirectory = path.join(__dirname, './public');
app.use(express.static(publicDirectory));

app.use(express.urlencoded({ extended: false }));
app.use(express.json());


app.set('view engine', 'hbs');

db.connect( (error) => {
    if(error){
        console.log(error)
    }else {
     console.log("MySql Connected....")   
    }
})

app.use('/', require('./routes/pages'));

app.use('/auth', require('./routes/auth'));




app.listen(8001, () => {
console.log("Server started on port 8001");
})
