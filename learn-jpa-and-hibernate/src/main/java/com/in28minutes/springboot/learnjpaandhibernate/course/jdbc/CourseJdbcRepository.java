package com.in28minutes.springboot.learnjpaandhibernate.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CourseJdbcRepository {
	
	@Autowired
	private JdbcTemplate springJdbcTemlpate;
	
	private static String INSERT_QUERY = 
			"""
			insert into course(id, name, author)
			values(1, 'Learn AWS', 'in28minutes');

			""";

	public void insert() {
		springJdbcTemlpate.update(INSERT_QUERY);
	}

}