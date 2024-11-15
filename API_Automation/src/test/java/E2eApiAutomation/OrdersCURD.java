package E2eApiAutomation;

import org.testng.annotations.Test;

import Pojo.AddProduct;
import Pojo.CreateOrder;
import Pojo.Login;
import Pojo.LoginResponse;
import Pojo.orderDetails;
import Pojo.orders;
import RestAssuredFiles.PayLoad;
import groovyjarjarpicocli.CommandLine.Spec;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.hamcrest.Matchers.*;

public class OrdersCURD {

	@Test
	public void Orders() {
		
		Login login=new Login();
		login.setUserEmail("postman.91@gmail.com");
		login.setUserPassword("Tunga@6456");
		//login
		 RequestSpecification req = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com/").setContentType(ContentType.JSON).build();		 
		RequestSpecification reqSpec = given().spec(req).body(login);
		ResponseSpecification responseSpec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		
		 LoginResponse loginResponse = reqSpec.when().post("api/ecom/auth/login")
		.then().log().all().spec(responseSpec).extract().response().as(LoginResponse.class);
		 
		 loginResponse.getMessage();
		 String userId = loginResponse.getUserId();
		 String token=loginResponse.getToken().trim();
		
		 System.out.println(userId);
		 System.out.println(token);
		
		 CreateOrder cr=new CreateOrder();
		 
	 cr.setProductName("Madhu143");
	 cr.setProductAddedBy(userId);
	 cr.setProductCategory("StyleBaby");
	 cr.setProductSubCategory("shirts");
	cr.setProductDescription("Addias Originals");
	cr.setProductFor("women");
	cr.setProductImage(new File("C://Users//tunga//Downloads//sai_Pallavi.jpeg"));
	cr.setProductPrice(2000);
	
		 
		//Create Product
		 
	RequestSpecification AddProductReqSpec = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com/")
	.addHeader("authorization", token).build();
	RequestSpecification AddProductdetails = given().spec(AddProductReqSpec).
	  param("productName", "Madhu143").
		 param("productAddedBy", userId).
		 param("productCategory", "fashion").
		 param("productSubCategory", "shirts").
		 param("productPrice", "11500").
		 param("productDescription", "Addias Originals").
		 param("productFor", "women").header("Authorization",token).
		 multiPart("productImage", new File("C://Users//tunga//Downloads//sai_Pallavi.jpeg"));
	
	
		AddProduct productDetails = AddProductdetails.when().post("api/ecom/product/add-product").then().log().all().extract().response().as(AddProduct.class);
 
		
		String productId = productDetails.getProductId();
		System.out.println(productId);
		
		
		//placeOrders
		
		orderDetails orderDtls= new orderDetails();
		orderDtls.setCountry("India");
		orderDtls.setProductOrderedId(productId);
		
		List<orderDetails> orderDetailList= new ArrayList<orderDetails>();
		orderDetailList.add(orderDtls);
		orders order=new orders();
		order.setOrders(orderDetailList);
		
		
		RequestSpecification createOrderRequestSpec = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com/")
		.addHeader("Authorization", token).setContentType(ContentType.JSON).build();
		
		String response = given().log().all().spec(createOrderRequestSpec).body(order)
		.when().post("api/ecom/order/create-order").then().log().all().extract().response().asString();
		JsonPath js = ReUsableMethods.JsonPath(response);
		
		 String orderId = js.get("orders").toString();
		 System.out.println("order Id "+orderId);
		 
		 
		 //delete product
		 
		RequestSpecification deleteReqSpec = new RequestSpecBuilder().addHeader("Authorization", token).setBaseUri("https://rahulshettyacademy.com/")
		.setContentType(ContentType.JSON).build();
		
		String deleteResponse = given().spec(deleteReqSpec).pathParam("productId", productId).when().delete("api/ecom/product/delete-product/{productId}")
		.then().log().all().extract().response().asString();
		
		
		 
		
		
	}
}
