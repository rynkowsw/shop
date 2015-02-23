package pl.cudlax;

import java.util.Arrays;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TestConnection {
	
	public static void main(String[] args) {
		
		SessionFactory sf = getSessionFactory();
		Session s = sf.openSession();
		System.out.println(s.isConnected());
		System.out.println(s);
		SQLQuery query = s.createSQLQuery("select * from USERS");
		List resutl = query.list();
		for(int i = 0;i < resutl.size();i++)
		{
			System.out.println(Arrays.toString((Object[])resutl.get(i)));
		}
		
		System.out.println(resutl.size());
		
		s.close();
		System.out.println("done");
	}
	
	public static SessionFactory getSessionFactory() {
		Configuration configuration = new Configuration().configure("hibernate/hibernate.cfg.xml");
		SessionFactory sf = configuration.buildSessionFactory();
		return sf;
	}
}
