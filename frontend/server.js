const http = require('http');
const fileSystem = require('fs');
const express = require('express')
const app = express()


const serverPort = 8080;
const hostUrl = "http://localhost";

app.use(express.static(__dirname + "/site"));

app.listen(serverPort, function () {

});


function readHtmlFile(req, res, filePath){
fileSystem.readFile(filePath, function(error, fileContent){
    if(error){
        res.writeHead(500, {'Content-Type': 'text/plain'});
        res.end('Error');
    }
    else{
        res.writeHead(200, {'Content-Type': 'text/html'});
        res.write(fileContent);
        res.end();
    }
});
}

app.get('/', (req, res) => {
    res.redirect(hostUrl + ":" + serverPort + "/main-page");
});

app.get('/main-page', (req, res) => {
    readHtmlFile(req, res, 'site/guest/index.html');
});

app.get('/guest/signup', (req, res) => {
    readHtmlFile(req, res, 'site/guest/signup/sign-up.html');
});

app.get('/guest/signin', (req, res) => {
    readHtmlFile(req, res, 'site/guest/signin/sign-in.html');
});

app.get('/user', (req, res) => {
    readHtmlFile(req, res, 'site/user/index.html');
});

app.get('/user/personal', (req, res) => {
    readHtmlFile(req, res, 'site/user/personal.html');
});

app.get('/user/personal-change', (req, res) => {
    readHtmlFile(req, res, 'site/user/personal-change.html');
});

console.log('Listening at: localhost:8080');
