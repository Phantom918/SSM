package com.qin.base.annotation;

import com.qin.base.annotation.impl.FruitAnnotationImpl;

public class UseFruitAnnotation {

	public static void main(String[] args) {
		FruitAnnotationImpl.getFruitInfo(Apple.class);
	}
	
}
