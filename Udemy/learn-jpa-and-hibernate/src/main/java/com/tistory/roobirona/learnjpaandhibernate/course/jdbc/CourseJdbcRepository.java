package com.tistory.roobirona.learnjpaandhibernate.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CourseJdbcRepository {
    @Autowired
    private JdbcTemplate springJdbcTemplate;
    private static String INSERT_QUERY =
            """
                    insert into course (id, name, author)
                    values (2, 'Learn AWS2', 'in28minutes2');
            """;
    // """ 는 텍스트 블록. 원하는 타입을 넣을 수 있다.
    // 텍스트 블록의 장점은 쿼리 형식을 그대로 유지할 수 있다.
    public void insert() {
        springJdbcTemplate.update(INSERT_QUERY);
    }
}
