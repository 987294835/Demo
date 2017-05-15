package jike.book.test;

import java.io.IOException;
import java.io.Reader;

import jike.book.pojo.JikeUser;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;


public class testT {

	@Test
	public void test() {
		String resource = "jike/book/map/MybatisConfig.xml";
		Reader reader = null;
		SqlSession session;
		try {
			reader = Resources.getResourceAsReader(resource);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		session = sqlSessionFactory.openSession();
		JikeUser temp = session.selectOne("findById", 1);
		System.out.println("ÓÃ»§Ãû====>"+temp.getUsername());
		session.close();
	}
}
