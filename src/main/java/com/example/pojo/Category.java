package com.example.pojo;

import java.io.Serializable;
import java.util.List;

public class Category implements Serializable {

	private int categoryId;

	private String categoryName;
	private List<SubCategory> subCategoryId;

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public List<SubCategory> getSubCategoryId() {
		return subCategoryId;
	}

	public void setSubCategoryId(List<SubCategory> subCategoryId) {
		this.subCategoryId = subCategoryId;
	}

	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", categoryName=" + categoryName + "]";
	}

}
