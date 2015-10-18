
public class Demo {

	public  void getHotels(String to) {
		// TODO Auto-generated method stub
System.out.println("in demo");
		YelpAPI yelpApi =new YelpAPI("pLuu3p_SZe7lzdKZVcUpzA","kWpC58_c7qbPje6seSBsXQxvroI","Z-waXeUkJrKgNgBugALL5ZlZfHTY8XZe","zlEZ795sVm2-iTMnm9Il1HBIQcI");
		String output= yelpApi.searchForBusinessesByLocation("hotel","Seattle");
		System.out.println(output);
	}

}
