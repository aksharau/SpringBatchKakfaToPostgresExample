package com.example.sprbatch.dao;


import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.example.sprbatch.model.CycleInstance;

@Repository
public class CycleInstanceDao extends JdbcDaoSupport {

	
	@Autowired
	DataSource dataSource;

	@PostConstruct
	private void initialize() {
		setDataSource(dataSource);
	}

	public void insert(final List<? extends CycleInstance> cycleinstances) {
		String sql = "INSERT INTO cycle " + "(code, year) VALUES (?, ?)";
		getJdbcTemplate().batchUpdate(sql, new BatchPreparedStatementSetter() {
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				CycleInstance cycle = cycleinstances.get(i);
				ps.setInt(1, cycle.getCycleCodeTc());
				ps.setInt(2, cycle.getYearTc());
			}

			public int getBatchSize() {
				// TODO Auto-generated method stub
				return cycleinstances.size();
			}

			
		});

	}
}
