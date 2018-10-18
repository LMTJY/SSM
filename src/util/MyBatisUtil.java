package util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtil {
	// 声明SqlSessionFactory对象
	private static SqlSessionFactory sqlSessionFactory = null;
	static {
		try {
			// 输入流读取mybatis-config.xml文件内容
			InputStream is = Resources
					.getResourceAsStream("mybatis-config.xml");
			// SqlSessionFactoryBuilder的build()方法获取sqlSessionFactory
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 自定义方法，用于获取SqlSession对象
	 * 
	 * @param isCommit
	 *            判断是否提交事务
	 * @return
	 */
	public static SqlSession getSqlSession() {
		return sqlSessionFactory.openSession();
	}
}
