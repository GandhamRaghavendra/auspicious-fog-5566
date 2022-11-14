package tms.Been;

public class BiderBeen {
private int BidId;
private int VendorId;
private String PId;
private int BidAmount;
private String Status;

public BiderBeen() {
	// TODO Auto-generated constructor stub
}

public BiderBeen(int bidId, int vendorId, String pId, int bidAmount, String status) {
	super();
	BidId = bidId;
	VendorId = vendorId;
	PId = pId;
	BidAmount = bidAmount;
	Status = status;
}

public int getBidId() {
	return BidId;
}

public void setBidId(int bidId) {
	BidId = bidId;
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
	return "Bid [BidId=" + BidId + ", VendorId=" + VendorId + ", PId=" + PId + ", BidAmount=" + BidAmount
			+ ", Status=" + Status + "]";
}



}
