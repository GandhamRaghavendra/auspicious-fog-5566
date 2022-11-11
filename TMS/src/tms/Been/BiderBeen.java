package tms.Been;

public class BiderBeen {
private int VendorId;
private String PId;
private int BidAmount;
private String Status="Waiting";

public BiderBeen() {
	// TODO Auto-generated constructor stub
}

public BiderBeen(int vendorId, String pId, int bidAmount) {
	super();
	VendorId = vendorId;
	PId = pId;
	BidAmount = bidAmount;
}

public int getVendorId() {
	return VendorId;
}

public void setVendorId(int vendorId) {
	VendorId = vendorId;
}

public String getPId() {
	return PId;
}

public void setPId(String pId) {
	PId = pId;
}

public int getBidAmount() {
	return BidAmount;
}

public void setBidAmount(int bidAmount) {
	BidAmount = bidAmount;
}

public String getStatus() {
	return Status;
}

public void setStatus(String status) {
	Status = status;
}

@Override
public String toString() {
	return "BiderBeen [VendorId=" + VendorId + ", PId=" + PId + ", BidAmount=" + BidAmount + ", Status=" + Status + "]";
}

}
