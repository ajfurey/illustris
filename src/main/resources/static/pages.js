const { response } = require('express');
const express = require('express');

const router = express.Router();

router.get('/', (require,response) =>{
    response.render('register');
});

router.get('/views/login.hbs', (require,response) =>{
    response.render('login');
});

router.get('/views/register.hbs', (require,response) =>{
    response.render('register');
});



module.exports = router;