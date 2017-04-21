package ru.myee.ejb;

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
	
//	@EJB/*(lookup="test")in classter*/
	
	@Inject // +annotation named+can find by applcation
	TestService testService;
	
	@Inject
	@Named 
	double rnd;

    public RespService() {
    }	
    
    @PostConstruct
    public void init(){
    }
    
    @Override
    public String resp (String msg){
    	testService.test();
    	System.out.println(rnd);
    	return "re:"+msg;
    }

}
