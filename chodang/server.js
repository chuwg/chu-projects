const express = require('express');
const app = express();
const bodyParser = require('body-parser');
app.use(bodyParser.urlencoded({ extended: true }));

const MongoClient = require('mongodb').MongoClient;
var db;
// db 변수 필요 -> 간단하게 사용하기 위해서 db변수에 저장해놓을 예정.
MongoClient.connect('mongodb+srv://chuwg:Wndndrl8956!@chuwg.whutf7y.mongodb.net/?retryWrites=true&w=majority', function (에러, client) {
    // 연결 확인 용으로 출력
    if (에러) return console.log(에러)

    db = client.db('Chodang'); // Chodang 이라는 database(폴더) 연결

    db.collection('post').insertOne({ 이름: 'chuwg', 나이: '37' }, function (에러, 결과) {
        console.log('저장완료');
    });


    app.listen(8080, function () {
        console.log("listening on 8080")
    });

});


app.get('/', function (require, response) {
    response.sendFile(__dirname + '/index.html');
});

app.get('/write', function (require, response) {
    response.sendFile(__dirname + '/write.html');
});

app.post('/add', function (require, response) {
    response.send("전송 완료");
    console.log(require.body.inputName);
    console.log(require.body.selectOption);
    console.log(require.body.writeInputPassword);
    console.log(require.body.writeCheckBox);


    db.collection('post').insertOne({ 주문자: require.body.inputName, 수량: require.body.selectOption, 패스워드: require.body.writeInputPassword, 주문동의: require.body.writeCheckBox }, function (에러, 결과) {

    });


});