package tms.Been;

public class ProjectBeen {
private String Id;
private String Name;
private String Type;
private int BasePrice;
private String Desc;
private String Location;
private String DeadLine;

public ProjectBeen() {
	// TODO Auto-generated constructor stub
}

public ProjectBeen(String id, String name, String type, int basePrice, String desc, String location, String deadLine) {
	super();
	Id = id;
	Name = name;
	Type = type;
	BasePrice = basePrice;
	Desc = desc;
	Location = location;
	DeadLine = deadLine;
}

public String getId() {
	return Id;
}

public void setId(String id) {
	Id = id;
}

public String getName() {
	return Name;
}

public void setName(String name) {
	Name = name;
}

public String getType() {
	return Type;
}

public void setType(String type) {
	Type = type;
}

public int getBasePrice() {
	return BasePrice;
}

public void setBasePrice(int basePrice) {
	BasePrice = basePrice;
}

public String getDesc() {
	return Desc;
}

public void setDesc(String desc) {
	Desc = desc;
}

public String getLocation() {
	return Location;
}

public void setLocation(String location) {
	Location = location;
}

public String getDeadLine() {
	return DeadLine;
}

public void setDeadLine(String deadLine) {
	DeadLine = deadLine;
}

@Override
public String toString() {
	return "Project [Id=" + Id + ", Name=" + Name + ", Type=" + Type + ", BasePrice=" + BasePrice + ", Desc=" + Desc
			+ ", Location=" + Location + ", DeadLine=" + DeadLine + "]";
}

}
