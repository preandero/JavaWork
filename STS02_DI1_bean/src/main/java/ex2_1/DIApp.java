package ex2_1;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class DIApp {

	public static void main(String[] args) {

		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationContext.xml");



		OperatorBean operator = null;

		operator = (OperatorBean) ctx.getBean("op");

		int value = operator.doOperate();
		System.out.println("더하기 결과:" + value);

		operator = (OperatorBean) ctx.getBean("opm");
		int value2 = operator.doOperate();

		System.out.println("빼기 결과: " +value2);


	}

}
