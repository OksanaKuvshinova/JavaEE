package ru.myee.ejb;

import java.io.Serializable;

import javax.ejb.LocalBean;
import javax.ejb.PostActivate;
import javax.ejb.Remove;
import javax.ejb.Stateful;

/**
 * Session Bean implementation class StateBean
 */
@Stateful(mappedName = "StateBean")
@LocalBean
public class StateBean implements Serializable, IStateBean {

	int count =0;
	
	public int incrementAndGet(){
		return ++count;
	}
	
	@PostActivate
	@Remove
	public void remove(){
		
	}

}
