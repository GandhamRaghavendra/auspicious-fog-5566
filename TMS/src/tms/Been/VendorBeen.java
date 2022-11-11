package tms.Been;

public class VendorBeen {
private String name;
private String mail;
private int pass;
private String cname;
private String add;

public VendorBeen() {
	// TODO Auto-generated constructor stub
}

public VendorBeen(String name, String mail, int pass, String cname, String add) {
	super();
	this.name = name;
	this.mail = mail;
	this.pass = pass;
	this.cname = cname;
	this.add = add;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getMail() {
	return mail;
}

public void setMail(String mail) {
	this.mail = mail;
}

public int getPass() {
	return pass;
}

public void setPass(int pass) {
	this.pass = pass;
}

public String getCname() {
	return cname;
}

public void setCname(String cname) {
	this.cname = cname;
}

public String getAdd() {
	return add;
}

public void setAdd(String add) {
	this.add = add;
}

@Override
public String toString() {
	return "VendorBeen [name=" + name + ", mail=" + mail + ", pass=" + pass + ", cname=" + cname + ", add=" + add + "]";
}
}
