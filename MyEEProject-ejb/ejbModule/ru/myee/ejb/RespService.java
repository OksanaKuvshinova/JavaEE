package ru.myee.ejb;

import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Session Bean implementation class RespService
 */

@Stateless(mappedName = "respBean")
@LocalBean
public class RespService implements IRespService {
	
//	@EJB/*(lookup="test"); use in cluster*/
	
	@Inject // + annotation @Named + can find by application
	TestService testService;
	
	@Inject
	@Named
	double rnd;
	
	int count=0;

    public RespService() {
    }	
    
    @PostConstruct
    public void init(){
    }
    @Override
    public int incrementAndGet(){
    	System.out.println ("----"+Thread.currentThread());
    	try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return ++count;
    }
    
    @Override
    public String resp (String msg){
    	testService.test();
    	System.out.println(rnd);
    	System.out.println ("--->"+testService.getClass().getName());
    	return "re:"+msg;
    }

}
