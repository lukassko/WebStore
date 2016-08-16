package com.app.store.utility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionFailedException;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.Converter;

import com.app.store.entity.Category;
import com.app.store.service.StoreService;

public class CategoryConverter implements Converter<String, Category> {

	@Autowired
	private StoreService storeService;
	
	public Category convert(String categoryIdStr) {
		int categoryId = -1;
		try{
			categoryId = Integer.parseInt(categoryIdStr);
		} catch (NumberFormatException e) {
			throw new ConversionFailedException(TypeDescriptor.valueOf(String.class), TypeDescriptor.valueOf(Category.class), categoryIdStr, null);
		}

		Category category = this.storeService.findCategoryById(categoryId);
		return category;
	}
}
