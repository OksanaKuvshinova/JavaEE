package ru.myee.ejb;

import javax.ejb.Remote;

@Remote
public interface IRespService {
	String resp (String msg);

}