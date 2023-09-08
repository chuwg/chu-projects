const express = require('express');
const app = express();
const bodyParser = require('body-parser');
app.use(bodyParser.urlencoded({ extended: true }));

const MongoClient = require('mongodb').MongoClient;
app.set('view engine', 'ejs');

var db;
// db 변수 필요 -> 간단하게 사용하기 위해서 db변수에 저장해놓을 예정.
MongoClient.connect('mongodb+srv://chuwg:Wndndrl8956!@chuwg.whutf7y.mongodb.net/?retryWrites=true&w=majority', function (에러, client) {
    // 연결 확인 용으로 출력
    if (에러) return console.log(에러)

    db = client.db('Chodang'); // Chodang 이라는 database(폴더) 연결

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

// 글 작성 기능

app.post('/add', function (require, response) {
    response.send("전송 완료");
    db.collection('counter').findOne({ name: '게시물수량' }, function (error, result) {
        console.log(result.totalPost)
        var totalPostCounter = result.totalPost;

        db.collection('post').insertOne({ _id: totalPostCounter + 1, 주문자: require.body.inputName, 수량: require.body.selectOption, 패스워드: require.body.writeInputPassword, 주문동의: require.body.writeCheckBox }, function (error, result) {
            db.collection('counter').updateOne({ name: '게시물수량' }, { $inc: { totalPost: 1 } }, function (error, result) {
                if (error) {
                    return console.log('게시물 수량 에러남');
                }

            })
            // operator 연산자 $set -> 바꿀 값 $inc -> 기준값에 더해줄 값
            if (error) {
                return console.log('add 오류났음');
            }

        });
    });
    // post 라는 컬렉션에서 인설트원하면 내가 원하는 코드 하나를 넣을 수 있음.
});

//글 번호 달기


// 글 보기 기능

app.get('/list', function (require, response) {
    db.collection('post').find().toArray(function (error, result) {
        console.log(result);
        response.render('list.ejs', { posts: result });
    });


});

app.delete('/delete', function (require, response) {
    console.log(require.body)
    require.body._id = parseInt(require.body._id);
    db.collection('post').deleteOne(require.body, function (error, result) {
        console.log('삭제 완료');
        response.status(200).send({ message: '성공했습니다!' });
    })
})
