const express = require('express');
const app = express();
const bodyParser = require('body-parser');
app.use(bodyParser.urlencoded({ extended: true }));

app.listen(8080, function () {
    console.log("listening on 8080")
});

app.get('/', function (require, response) {
    response.sendFile(__dirname + '/index.html');
});

app.get('/write', function (require, response) {
    response.sendFile(__dirname + '/write.html');
});

app.post('/add', function (require, response) {
    response.send("전송 완료");
    console.log(require.body)
});