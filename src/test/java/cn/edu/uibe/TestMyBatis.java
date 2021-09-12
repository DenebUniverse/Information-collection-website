package cn.edu.uibe;

import java.io.IOException;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


public class TestMyBatis {

	public static void main(String[] args) {
		System.out.println(java.time.LocalDateTime.now());
		
//		SqlSessionFactoryBuilder factoryBuilder = new SqlSessionFactoryBuilder();
//		try {
//			SqlSessionFactory factory = factoryBuilder.build(Resources.getResourceAsStream("mybatis-config-standalone.xml"));
//			SqlSession session = factory.openSession();
//			MemberMapper mapper = session.getMapper(MemberMapper.class);
//			Member m = mapper.selectByPrimaryKey(1L); 
//			System.out.println(m.getId()+" "+m.getName()+" "+m.getPhone()+" "+m.getCredits());
//			
//			m.setCredits(m.getCredits()+500);
//			mapper.updateByPrimaryKey(m);
//			session.commit();
//			m = mapper.selectByPrimaryKey(1L); 
//			System.out.println(m.getId()+" "+m.getName()+" "+m.getPhone()+" "+m.getCredits());
//			
//			Member member = new Member();
//			member.setName("张三");
//			member.setPhone("12312345672");
//			member.setCredits(1200.0);
//			mapper.insert(member);
//			session.commit();
//			
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		

	}

}
