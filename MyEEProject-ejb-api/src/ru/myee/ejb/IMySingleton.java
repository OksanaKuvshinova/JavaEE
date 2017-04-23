package ru.myee.ejb;

import javax.ejb.Remote;

@Remote
public interface IMySingleton {

	String resp(String msg);

}
