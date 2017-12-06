package com.lps.action.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class TestGson {
	
	/*var yearChartData = {
			labels  : ['9.00', '10.00', '11.00', '12.00', '13.00', '14.00', '15.00','16.00', '17.00', '18.00', '19.00', '20.00','21.00','22.00','23.00','24.00'],
			    datasets: [
			        {
			            label               : ' 点钟',
			            fillColor           : '#3c8dbc',
			            strokeColor         : '#f56954',
			            pointColor          : '#3c8dbc',
			            pointStrokeColor    : '#f56954',
			            pointHighlightFill  : '#3c8dbc',
			            pointHighlightStroke: 'rgba(220,220,220,1)',
			            data                : [60, 50, 80, 80, 60, 90,20 ,100, 70, 30, 80, 102, 50,40,50,70]
			        }
			    ]
			}*/
	
	public class Data{
		List<Integer> labels = null;
		Map<String, Object> datasets;
		
	}
	
	public class User {
	    //省略其它
	    public String name;
	    public int age;
//	    @SerializedName("email_address")
	    public String emailAddress;
	    public Collection<Integer> ints;
	}

	@Test
	public void test() {
//		Gson gson = new Gson();
//		String jsonString = "{\"name\":\"怪盗kidou\",\"age\":24}";
//		User user = gson.fromJson(jsonString, User.class);
//		System.out.println(user.age);
		
		
//		Data d = new Data();
/*		d.labels = new ArrayList<>();
		d.labels.add(1);
		d.labels.add(2);
		d.labels.add(3);
		d.labels.add(4);
		d.datasets = new TreeMap<>();
		d.datasets.put("label", "点钟");
		d.datasets.put("fillColor", "#3c8dbc");
		d.datasets.put("data", d.labels);
		
		Gson gson = new Gson();
		System.out.println(gson.toJson(d));*/
/*		Gson gson = new Gson();
		User u = new User();
		u.age = 1;
		u.emailAddress = "ddd";
		u.name = "ffds";
		System.out.println(gson.toJson(u));*/
		
//		int i = gson.fromJson("100", int.class);              //100
//		double d = gson.fromJson("\"99.99\"", double.class);  //99.99
//		boolean b = gson.fromJson("true", boolean.class);     // true
//		String str = gson.fromJson("String", String.class);   // String
		
		/*User u = new User();
		u.age = 1;
		
		Gson gson = new Gson();
		Collection<Integer> ints = new ArrayList<>();
		u.ints = ints;
		ints.add(2);
		ints.add(3);
		ints.add(4);
		ints.add(5);

		// Serialization
		String json = gson.toJson(u);  // ==> json is [1,2,3,4,5]
		System.out.println(json);*/
		
		List<Object> list = new ArrayList<>();
		list.add(null);
		list.add(1);
		list.add(null);
		list.add("hhh");
		for (Object object : list) {
			System.out.println(object);
		}

	}

}
