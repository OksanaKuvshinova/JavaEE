package ru.myee.ejb;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class EntryPoint {
	
	public static void main (String [] args) throws NamingException{
		Context  ctx = new InitialContext ();
		IRespService respBean = (IRespService)ctx.lookup("respBean");
		String result = respBean.resp("Hello!");
		System.out.println(result);
		
	}
}
