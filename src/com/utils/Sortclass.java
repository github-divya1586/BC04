package com.utils;

import java.util.Comparator;

import com.model.RegisterModel;

public class Sortclass implements Comparator<RegisterModel>{

	@Override
	public int compare(RegisterModel o1, RegisterModel o2) {
		// TODO Auto-generated method stub
		return o1.getName().compareTo(o2.getName());
	}
	
}