package pojo;

public class RolePojo {
	int roleId;
	String role;
	
	public RolePojo() {
	}

	public RolePojo(int roleId, String role) {
		super();

		this.roleId = roleId;
		this.role = role;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "RolePojo [roleId=" + roleId + ", role=" + role + "]";
	}
	
	
}
