package ie.cit.cloudapp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;


import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;


public class jdbcUserRepository {
	
		
		private JdbcTemplate jdbcTemplate;
		
		public jdbcUserRepository(DataSource dataSource) {
			this.jdbcTemplate = new JdbcTemplate(dataSource);
		}
		
		public void save(UserInfo userinfo){
			jdbcTemplate.update("insert into users (username, password,enabled) values (?, ?, 'true')",userinfo.getUsername(), userinfo.getPwd());
			jdbcTemplate.update("INSERT into authorities (username, authority) values (?,'ROLE_USER')", userinfo.getUsername());		
			jdbcTemplate.update("insert into USERDATA(username, email,home ) values (?,?,?)",userinfo.getUsername(),  userinfo.getEmail(), userinfo.getHome());

		}

	
		public List<UserInfo> getAll(){
			return jdbcTemplate.query("select id, username, email, home from USERDATA", new UserMapper());
		}
		
		public List<UserInfo> getUserData(String username){
			return jdbcTemplate.query("select id, username, email, home from USERDATA where username=?", new Object[]{username}, new UserMapper());
		}
		
		
		
		
		
	}
		class UserMapper implements RowMapper<UserInfo>{
			public UserInfo mapRow(ResultSet rs, int rowNum) throws SQLException{
				UserInfo userinfo = new UserInfo();
				userinfo.setEmail(rs.getString("email"));
				userinfo.setEmail(rs.getString("home"));
				userinfo.setUsername(rs.getString("username"));
				userinfo.setId(rs.getInt("id"));
				
				
				return userinfo;
				
			}
		}
		
		
