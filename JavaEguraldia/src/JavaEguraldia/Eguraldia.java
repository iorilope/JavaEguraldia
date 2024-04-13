/**
 * 
 */
package JavaEguraldia;

/**
 * 
 * @author Ioritz Lopetegi
 */
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty; 
public class Eguraldia {
	 public String cityName;
	 
	 //Homeko url-ak
	private static final String API_KEY = "2ee10d78e10cfd69d1da17c7560cdb06"; // Replace with your actual API key
	private static final String BASE_URL_HOME = "https://api.openweathermap.org/geo/1.0/";
	private static final String BASE_URL = "https://api.openweathermap.org/data/2.5/";
	
	
	
	
	
	//Bilaketa urlak
	
	 JsonNode latNode;
	 JsonNode lonNode;
	 OkHttpClient client;
	 String url;
	 Request request;
	 Response response;
	
	 String cityNameHome = "Tolosa,ES";
	 String hiria;
	

	
	
	public String getHiriaIzenaHome() throws IOException {
		  // Hardcoded city name not used (consider using a parameter)
		  ;  // Initialize cityName (optional)

		  try {
		    OkHttpClient client = new OkHttpClient();
		    String url = BASE_URL_HOME + "direct?q=" + cityNameHome + "&limit=0&appid=" + API_KEY;

		     request = new Request.Builder().url(url).build();

		     response = client.newCall(request).execute();

		    if (response.isSuccessful()) {
		      String jsonData = response.body().string();

		      // Use Jackson for JSON parsing
		      ObjectMapper mapper = new ObjectMapper();
		      try {
		        JsonNode rootNode = mapper.readTree(jsonData);

		        // Access the first element in the array
		        JsonNode firstCityNode = rootNode.get(0);  // Assuming the first element has the city name
		        
		         latNode = firstCityNode.path("lat");
		         lonNode = firstCityNode.path("lon");
		        
		        
		      //Ikusteko latitud longitud artzen duen  
		     System.out.println(lonNode.asText());
		     System.out.println(latNode.asText());

		        JsonNode nameNode = firstCityNode.path("name");
		        if (nameNode.isTextual()) {
		          return nameNode.asText();
		        
		        } else {
		          System.err.println("Error extracting city name from first element");
		          return null;
		        }

		      } catch (JsonProcessingException e) {
		        System.err.println("Error parsing JSON data: " + e.getMessage());
		        return null;
		      }
		    } else {
		      System.err.println("Error fetching location data: " + response.code());
		      return null;
		    }

		  } catch (IOException e) {
		    throw e;  // Re-throw IOException for proper handling (consider specific handling within the calling method)
		  }
		}
	
//	public void sortuurlgeoapi() {
//		
//		 client = new OkHttpClient();
//	     url = BASE_URL + "direct?q=" + hiria + "&limit=0&appid=" + API_KEY;
//		
//	}
	
	public void lortulatlon() throws IOException{
		
		 OkHttpClient client = new OkHttpClient();
		    String url = BASE_URL_HOME + "direct?q=" + hiria + "&limit=0&appid=" + API_KEY;

		     request = new Request.Builder().url(url).build();

		     response = client.newCall(request).execute();

		    if (response.isSuccessful()) {
		      String jsonData = response.body().string();

		      // Use Jackson for JSON parsing
		      ObjectMapper mapper = new ObjectMapper();
		      try {
		        JsonNode rootNode = mapper.readTree(jsonData);

		        // Access the first element in the array
		        JsonNode firstCityNode = rootNode.get(0);  // Assuming the first element has the city name

		         latNode = firstCityNode.path("lat");
		         lonNode = firstCityNode.path("lon");
		      }
		         catch (JsonProcessingException e) {
				        System.err.println("Error parsing JSON data: " + e.getMessage());
		         }
		    }
				      
		
	}
	public String getHiriaIzena( String hiria) throws IOException {
		  // Hardcoded city name not used (consider using a parameter)
		   // Initialize cityName (optional)

		  try {
		    OkHttpClient client = new OkHttpClient();
		    String url = BASE_URL_HOME + "direct?q=" + hiria + "&limit=0&appid=" + API_KEY;

		    Request request = new Request.Builder().url(url).build();

		    Response response = client.newCall(request).execute();

		    if (response.isSuccessful()) {
		      String jsonData = response.body().string();

		      // Use Jackson for JSON parsing
		      ObjectMapper mapper = new ObjectMapper();
		      try {
		        JsonNode rootNode = mapper.readTree(jsonData);

		        // Access the first element in the array
		        JsonNode firstCityNode = rootNode.get(0);  // Assuming the first element has the city name

		        JsonNode nameNode = firstCityNode.path("name");
		        if (nameNode.isTextual()) {
		          return nameNode.asText();
		        } else {
		          System.err.println("Error extracting city name from first element");
		          return null;
		        }

		      } catch (JsonProcessingException e) {
		        System.err.println("Error parsing JSON data: " + e.getMessage());
		        return null;
		      }
		    } else {
		      System.err.println("Error fetching location data: " + response.code());
		      return null;
		    }

		  } catch (IOException e) {
		    throw e;  // Re-throw IOException for proper handling (consider specific handling within the calling method)
		  }
		}
	public String getTemperaturaHome() throws IOException {
		
		
		
		try {
			
			
			
			//lortulatlon();
			
			 OkHttpClient client = new OkHttpClient();
			 String url = BASE_URL + "forecast?q=" + cityNameHome + "&mode=json&units=metric&appid=" + API_KEY;
			
			 Request request = new Request.Builder().url(url).build();

			 Response response = client.newCall(request).execute();
			    if (response.isSuccessful()) {
				      String jsonData = response.body().string();

				      // Use Jackson for JSON parsing
				      ObjectMapper mapper = new ObjectMapper();
				      try {
				        JsonNode rootNode = mapper.readTree(jsonData);

				     // Assuming you want the temperature for the first time slot (index 0)
				        JsonNode listNode = rootNode.path("list");

				     // Get the first element (index 0) from the "list" array
				     JsonNode firstTimeSlotNode = listNode.get(0);

				     // Access the "main" node within the first element
				     JsonNode mainNode = firstTimeSlotNode.path("main");

				     // Extract the temperature value from the "temp" node
				     JsonNode tempNode = mainNode.path("temp");

				     // Check if the node is textual (assuming temperature is a number)
				     if (tempNode.isDouble()) {
				       // Get the temperature as a double
				    	 System.out.println("Temperature: " + tempNode.asText());
				       return  tempNode.asText();
				      
				     } else {
				       System.err.println("Error: Temperature node is not textual");
				     }

				      } catch (JsonProcessingException e) {
				        System.err.println("Error parsing JSON data: " + e.getMessage());
				     
				      }
				    } else {
				      System.err.println("Error fetching location data: " + response.code());
				      return null;
				    
				    }
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
		
		
		
		
		
		
	}
	
	
	  
	  
	/* ObjectMapper om = new ObjectMapper();
	Root root = om.readValue(myJsonString, Root.class); */
	public class Clouds{
	    @JsonProperty("all") 
	    public int getAll() { 
			 return this.all; } 
	    public void setAll(int all) { 
			 this.all = all; } 
	    int all;
	}

	public class Coord{
	    @JsonProperty("lat") 
	    public double getLat() { 
			 return this.lat; } 
	    public void setLat(double lat) { 
			 this.lat = lat; } 
	    double lat;
	    @JsonProperty("lon") 
	    public double getLon() { 
			 return this.lon; } 
	    public void setLon(double lon) { 
			 this.lon = lon; } 
	    double lon;
	}

	public class List{
	    @JsonProperty("id") 
	    public int getId() { 
			 return this.id; } 
	    public void setId(int id) { 
			 this.id = id; } 
	    int id;
	    @JsonProperty("name") 
	    public String getName() { 
			 return this.name; } 
	    public void setName(String name) { 
			 this.name = name; } 
	    String name;
	    @JsonProperty("coord") 
	    public Coord getCoord() { 
			 return this.coord; } 
	    public void setCoord(Coord coord) { 
			 this.coord = coord; } 
	    Coord coord;
	    @JsonProperty("main") 
	    public Main2 getMain() { 
			 return this.main; } 
	    public void setMain(Main2 main) { 
			 this.main = main; } 
	    Main2 main;
	    @JsonProperty("dt") 
	    public int getDt() { 
			 return this.dt; } 
	    public void setDt(int dt) { 
			 this.dt = dt; } 
	    int dt;
	    @JsonProperty("wind") 
	    public Wind getWind() { 
			 return this.wind; } 
	    public void setWind(Wind wind) { 
			 this.wind = wind; } 
	    Wind wind;
	    @JsonProperty("sys") 
	    public Sys getSys() { 
			 return this.sys; } 
	    public void setSys(Sys sys) { 
			 this.sys = sys; } 
	    Sys sys;
	    @JsonProperty("rain") 
	    public Object getRain() { 
			 return this.rain; } 
	    public void setRain(Object rain) { 
			 this.rain = rain; } 
	    Object rain;
	    @JsonProperty("snow") 
	    public Object getSnow() { 
			 return this.snow; } 
	    public void setSnow(Object snow) { 
			 this.snow = snow; } 
	    Object snow;
	    @JsonProperty("clouds") 
	    public Clouds getClouds() { 
			 return this.clouds; } 
	    public void setClouds(Clouds clouds) { 
			 this.clouds = clouds; } 
	    Clouds clouds;
	    @JsonProperty("weather") 
	    public ArrayList<Weather> getWeather() { 
			 return this.weather; } 
	    public void setWeather(ArrayList<Weather> weather) { 
			 this.weather = weather; } 
	    ArrayList<Weather> weather;
	}

	public class Main2{
	    @JsonProperty("temp") 
	    public double getTemp() { 
			 return this.temp; } 
	    public void setTemp(double temp) { 
			 this.temp = temp; } 
	    double temp;
	    @JsonProperty("feels_like") 
	    public double getFeels_like() { 
			 return this.feels_like; } 
	    public void setFeels_like(double feels_like) { 
			 this.feels_like = feels_like; } 
	    double feels_like;
	    @JsonProperty("temp_min") 
	    public double getTemp_min() { 
			 return this.temp_min; } 
	    public void setTemp_min(double temp_min) { 
			 this.temp_min = temp_min; } 
	    double temp_min;
	    @JsonProperty("temp_max") 
	    public double getTemp_max() { 
			 return this.temp_max; } 
	    public void setTemp_max(double temp_max) { 
			 this.temp_max = temp_max; } 
	    double temp_max;
	    @JsonProperty("pressure") 
	    public int getPressure() { 
			 return this.pressure; } 
	    public void setPressure(int pressure) { 
			 this.pressure = pressure; } 
	    int pressure;
	    @JsonProperty("humidity") 
	    public int getHumidity() { 
			 return this.humidity; } 
	    public void setHumidity(int humidity) { 
			 this.humidity = humidity; } 
	    int humidity;
	}

	public class Root{
	    @JsonProperty("message") 
	    public String getMessage() { 
			 return this.message; } 
	    public void setMessage(String message) { 
			 this.message = message; } 
	    String message;
	    @JsonProperty("cod") 
	    public String getCod() { 
			 return this.cod; } 
	    public void setCod(String cod) { 
			 this.cod = cod; } 
	    String cod;
	    @JsonProperty("count") 
	    public int getCount() { 
			 return this.count; } 
	    public void setCount(int count) { 
			 this.count = count; } 
	    int count;
	    @JsonProperty("list") 
	    public ArrayList<List> getList() { 
			 return this.list; } 
	    public void setList(ArrayList<List> list) { 
			 this.list = list; } 
	    ArrayList<List> list;
	}

	public class Sys{
	    @JsonProperty("country") 
	    public String getCountry() { 
			 return this.country; } 
	    public void setCountry(String country) { 
			 this.country = country; } 
	    String country;
	}

	public class Weather{
	    @JsonProperty("id") 
	    public int getId() { 
			 return this.id; } 
	    public void setId(int id) { 
			 this.id = id; } 
	    int id;
	    @JsonProperty("main") 
	    public String getMain() { 
			 return this.main; } 
	    public void setMain(String main) { 
			 this.main = main; } 
	    String main;
	    @JsonProperty("description") 
	    public String getDescription() { 
			 return this.description; } 
	    public void setDescription(String description) { 
			 this.description = description; } 
	    String description;
	    @JsonProperty("icon") 
	    public String getIcon() { 
			 return this.icon; } 
	    public void setIcon(String icon) { 
			 this.icon = icon; } 
	    String icon;
	}

	public class Wind{
	    @JsonProperty("speed") 
	    public double getSpeed() { 
			 return this.speed; } 
	    public void setSpeed(double speed) { 
			 this.speed = speed; } 
	    double speed;
	    @JsonProperty("deg") 
	    public int getDeg() { 
			 return this.deg; } 
	    public void setDeg(int deg) { 
			 this.deg = deg; } 
	    int deg;
	}

	



}
