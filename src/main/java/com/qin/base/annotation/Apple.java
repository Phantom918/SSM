package com.qin.base.annotation;

import com.qin.base.annotation.FruitColor.Color;

public class Apple {

	@FruitName(value="HongFuShi Apple")
	private String fruitName;
	
	@FruitColor(fruitColor=Color.RED)
	private String fruitColor;
	
	@FruitProvider(id=1, user="Tom", address="San Francisco")
	private FruitProvider provider;
	
}
