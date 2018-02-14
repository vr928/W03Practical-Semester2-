public class StockItem { 

  

    private String InvoiceNo; 

    private String StockCode; 

    private String Description; 

    private int Quantity; 

    private String InvoiceDate; 

    private double UnitPrice; 

    private String CustomerID; 

    private String Country; 

  

    public StockItem(String invoiceNo, String stockCode, String description, 

                     int quantity, String invoiceDate, double unitPrice, String customerID, String country) { 

        InvoiceNo = invoiceNo; 

        StockCode = stockCode; 

        Description = description; 

        Quantity = quantity; 

        InvoiceDate = invoiceDate; 

        UnitPrice = unitPrice; 

        CustomerID = customerID; 

        Country = country; 

    }



	public String getInvoiceNo() {
		return InvoiceNo;
	}



	public void setInvoiceNo(String invoiceNo) {
		InvoiceNo = invoiceNo;
	}



	public String getStockCode() {
		return StockCode;
	}



	public void setStockCode(String stockCode) {
		StockCode = stockCode;
	}



	public String getDescription() {
		return Description;
	}



	public void setDescription(String description) {
		Description = description;
	}



	public int getQuantity() {
		return Quantity;
	}



	public void setQuantity(int quantity) {
		Quantity = quantity;
	}



	public String getInvoiceDate() {
		return InvoiceDate;
	}



	public void setInvoiceDate(String invoiceDate) {
		InvoiceDate = invoiceDate;
	}



	public double getUnitPrice() {
		return UnitPrice;
	}



	public void setUnitPrice(double unitPrice) {
		UnitPrice = unitPrice;
	}



	public String getCustomerID() {
		return CustomerID;
	}



	public void setCustomerID(String customerID) {
		CustomerID = customerID;
	}



	public String getCountry() {
		return Country;
	}



	public void setCountry(String country) {
		Country = country;
	} 

  

   
    
}