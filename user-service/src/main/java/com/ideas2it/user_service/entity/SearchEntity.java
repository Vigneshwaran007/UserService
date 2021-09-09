package com.ideas2it.user_service.entity;

/**
 * SearchEntity which represent entity for search data.
 * 
 * @author Vigneshwaran N
 */

public class SearchEntity {
	String userName;
	String roleName;

	public SearchEntity() {
		super();
	}

	public SearchEntity(String userName, String roleName) {
		super();
		this.userName = userName;
		this.roleName = roleName;
	}

	public SearchEntity(SearchBuilder searchBuilder) {
		this.roleName = searchBuilder.roleName;
		this.userName = searchBuilder.userName;
	}

	public String getUserName() {
		return userName;
	}

	public String getRoleName() {
		return roleName;
	}

	public static class SearchBuilder {
		String userName;
		String roleName;

		public SearchBuilder userName(String userName) {
			this.userName = userName;
			return this;
		}

		public SearchBuilder roleName(String roleName) {
			this.roleName = roleName;
			return this;
		}
		
		public SearchEntity build() {
			return new SearchEntity(this);
		}
	}
}
