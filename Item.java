class Item {
  String name ;
  int satisfaction ;
  int price ;
  String type ;

  public Item(String name, int price, int satisfaction) {
	this.name = name ;
	this.satisfaction = satisfaction;
    this.price = price ;
    this.type = "NULL" ;
  }
  public Item(String name, int price, int satisfaction, String type) {
		this.name = name ;
		this.satisfaction = satisfaction;
	    this.price = price;
	    this.type = type ;
  }

public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getSatisfaction() {
	return satisfaction;
}
public void setSatisfaction(int satisfaction) {
	this.satisfaction = satisfaction;
}
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}

}
