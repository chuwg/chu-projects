create table course
(
    id bigint not null, /* 기본키 */
    name varchar(255) not null,
    author varchar(255) not null,
    primary key (id)
    /* 값이 null 이면 안되기 때문에 not null 을 넣어주었다. */
    /* 테이블을 정의할 때 항상 기본키를 정의하는게 좋다. */
    /* 이 테이블의 모든 행이 ID 필드 값으로 고유의 값을 가져야 한다는 뜻이다.
    이 id를 이용해서 특정 테이블에서 특정 열을 식별하게 된다.
    */
);