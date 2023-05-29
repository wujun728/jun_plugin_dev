package com.jfinal.plugin.activerecord.model.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseBlog<M extends BaseBlog<M>> extends Model<M> implements IBean {

	/**
	 * id注释
	 */
	public void setId(java.lang.Integer id) {
		set("id", id);
	}
	
	/**
	 * id注释
	 */
	public java.lang.Integer getId() {
		return getInt("id");
	}

	/**
	 * title注释
	 */
	public void setTitle(java.lang.String title) {
		set("title", title);
	}
	
	/**
	 * title注释
	 */
	public java.lang.String getTitle() {
		return getStr("title");
	}

	/**
	 * content注释
	 */
	public void setContent(java.lang.String content) {
		set("content", content);
	}
	
	/**
	 * content注释
	 */
	public java.lang.String getContent() {
		return getStr("content");
	}

}
