package com.progs.start;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.api.exp.config.SpringORMConfig;

public class TestConfig {

		public static void main(String[] args) {
			
			ApplicationContext context =new AnnotationConfigApplicationContext(SpringORMConfig.class);
			DataSource ds = (DataSource)context.getBean("ds");
			SessionFactory sfactory  = (SessionFactory)context.getBean("sfactory");
			System.out.println(ds.hashCode());
			System.out.println(sfactory.hashCode());
		}
}
