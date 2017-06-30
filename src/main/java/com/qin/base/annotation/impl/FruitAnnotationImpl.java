package com.qin.base.annotation.impl;

import java.lang.reflect.Field;

import com.qin.base.annotation.FruitColor;
import com.qin.base.annotation.FruitName;
import com.qin.base.annotation.FruitProvider;

public class FruitAnnotationImpl {

	public static void getFruitInfo(Class<?> clazz) {
		
		try {
			Class<?> cls = Class.forName(clazz.getName());
			Field[] fields = cls.getDeclaredFields();
			for (Field field : fields) {
				if (field.isAnnotationPresent(FruitName.class)) {
					FruitName fruitName = field.getAnnotation(FruitName.class);
					System.out.println("Fruit name:"+fruitName.value());
				}
				if(field.isAnnotationPresent(FruitColor.class)) {
					FruitColor fruitColor = field.getAnnotation(FruitColor.class);
					System.out.println("Fruit color:"+fruitColor.fruitColor());
				}
				if (field.isAnnotationPresent(FruitProvider.class)) {
					FruitProvider fruitProvider = field.getAnnotation(FruitProvider.class);
					System.out.println("FriutProvider --> id:" + fruitProvider.id() + " user:" + fruitProvider.user() + " address:" + fruitProvider.address());
				}
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
}
