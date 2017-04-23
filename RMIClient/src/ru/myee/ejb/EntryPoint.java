package ru.myee.ejb;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class EntryPoint {
	
	public static void main (String [] args) throws NamingException{
		Context  ctx = new InitialContext ();
		
		//		stateless(ctx);
		
		IMySingleton singleton = (IMySingleton)ctx.lookup("singleton");
		singleton.resp("ok");
	}

	private static void stateless(Context ctx) throws NamingException {
		IRespService respBean = (IRespService)ctx.lookup("respBean");
		
		//System.out.println(respBean.getClass().getName());//class proxy for req-resp
		
		String result = respBean.resp("Hello");
		System.out.println(result);
		
		for(int i=0; i<100; i++){
			new Thread (()-> {
			int res = respBean.incrementAndGet();
			System.out.println(res);
			}).start();
		}
	}
}
