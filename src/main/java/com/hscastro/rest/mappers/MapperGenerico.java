package com.hscastro.rest.mappers;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;

public class MapperGenerico {

	private static ModelMapper mapper = new ModelMapper();
	
	public static <O, D> D parseObject(O origin, Class<D> destination) {
		return mapper.map(origin, destination);
	}
	
	public static <O, D> List<D> parseListObjects(List<O> origin, Class<D> destination) {
		List<D> destinationObects = new ArrayList<D>();
		for(O o : origin) {
			destinationObects.add(mapper.map(o, destination));
		}
		return destinationObects;
	}

}
