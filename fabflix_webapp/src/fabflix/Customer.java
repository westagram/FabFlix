package fabflix;

public class Customer {
	private int id;
	private String firstName;
	private String lastName;
	private String ccid;
	private String address;
	private String email;
	private String password;
	
	public Customer(int id, String firstName, String lastName, String ccid, String address, String email,
			String password) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.ccid = ccid;
		this.address = address;
		this.email = email;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCcid() {
		return ccid;
	}

	public void setCcid(String ccid) {
		this.ccid = ccid;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", ccid=" + ccid
				+ ", address=" + address + ", email=" + email + ", password=" + password + "]";
	}
	
}
