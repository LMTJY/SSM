package test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import util.MyBatisUtil;
import dao.UserDao;
import entity.User;

public class UsetTest {

	private MyBatisUtil util = new MyBatisUtil();
	private SqlSession session;
	private UserDao userDao;
	@Before
	public void open() {
		session = util.getSqlSession();
		userDao = session.getMapper(UserDao.class);
	}
	
	@Test
	public void userTest(){
		List<User> list = userDao.queryAll();
		System.out.println(list);
	}
	
	@After
	public void close() {
		session.commit();
		session.close();
	}
}
