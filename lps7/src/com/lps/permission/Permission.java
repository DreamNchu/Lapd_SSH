package com.lps.permission;

public class Permission {

	public static final int USER = 1;
	
	public static final int ADMIN = 2;
	
	private int perssion;
	
	public Permission() {
		
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + perssion;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Permission other = (Permission) obj;
		if (perssion != other.perssion)
			return false;
		return true;
	}



	public Permission(int perssion) {
		super();
		this.perssion = perssion;
	}


	public int getPerssion() {
		return perssion;
	}

	public void setPerssion(int perssion) {
		this.perssion = perssion;
	}
	
	
	
}
