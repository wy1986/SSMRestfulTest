package com.wy.convertor;

import org.springframework.core.convert.converter.Converter;

public class ConvertStringToIntegerMyself implements Converter<String,Integer>{

	@Override
	public Integer convert(String input) {
		if(input.equals(""))
			return null;
		else
			return Integer.parseInt(input);
	}

}
