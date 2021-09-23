
import groovy.json.*;
def listsOfMachine(Map config = [:]) {
  //GET
  echo '1'
  def connection = new URL("http://54.36.230.136:2000/api/machine/list").openConnection(); 
  echo '2'
  connection.setRequestMethod("GET");
  echo '3'
  connection.doOutput = false;
  echo '4'
  connection.connect();
  echo '5'
  //println(connection.content.text);
  def arr = connection.content.text;
  def parser = new JsonSlurperClassic();
  def json = parser.parseText(arr);
  return json;
}

def statusOfMachine(Map config = [:]) {
  // GET
	try {
  		def connection = new URL("http://54.36.230.136:2000/api/machine/status/${config.branch_name}").openConnection(); 
  		connection.setRequestMethod("GET");
  		connection.doOutput = false;
  		connection.connect();
  		println(connection.content.text);
		return coonection.content.text;
		
	} catch (Exception ex) {
		println("Catching the exception");
		println(ex.toString());
        	println(ex.getMessage());
	}
}

def createMachine(Map config = [:]) {
  //POST
	try {
		def post = new URL("http://54.36.230.136:2000/api/machine/create/${config.branch_name}?config=test-infra").openConnection();
	  def message = '{"message":"this is a message"}'
	  post.setRequestMethod("POST")
	  post.setDoOutput(true)
	  post.setRequestProperty("Content-Type", "application/json")
	  post.getOutputStream().write(message.getBytes("UTF-8"));
	  def postRC = post.getResponseCode();
// 	  println(postRC);
	  return postRC; 
	  if(postRC.equals(200)) {
	    println("Machine is being created.");
	  }  else {
	  	println("Machine cannot be created!")
	  }
	} catch (Exception ex) {
		println("Catching the exception");
		 println(ex.toString());
         println(ex.getMessage());
	}
}

def startMachine(Map config = [:]) {
  //POST
	echo "${config.branch_name}"
	try {
	  def post = new URL("http://54.36.230.136:2000/api/machine/start/${config.branch_name}").openConnection();
	  def message = '{"message":"this is a message"}'
    	  post.setRequestMethod("POST")
	  post.setDoOutput(true)
	  post.setRequestProperty("Content-Type", "application/json")
	  post.getOutputStream().write(message.getBytes("UTF-8"));
	  def postRC = post.getResponseCode();
// 	  println(postRC);
          return postRC;
	  if(postRC.equals(200)) {
	    println("Machine is Started.");
	  }  else {
	  	println("Machine is cannot be Started!")
	  }
	} catch (Exception ex) {
		println("Catching the exception");
		 println(ex.toString());
         println(ex.getMessage());
	}
}

def stopMachine(Map config = [:]) {
  //POST
	try {
	  def post = new URL("http://54.36.230.136:2000/api/machine/stop/${config.branch_name}").openConnection();
	  def message = '{"message":"this is a message"}'
	  post.setRequestMethod("POST")
	  post.setDoOutput(true)
	  post.setRequestProperty("Content-Type", "application/json")
	  post.getOutputStream().write(message.getBytes("UTF-8"));
	  def postRC = post.getResponseCode();
	  println(postRC);
          return postRC;
	  if(postRC.equals(200)) {
	    println("Machine is Stopped.");
	  }  else {
	  	println("Machine is cannot be Stopped!")
	  }
	} catch (Exception ex) {
		println("Catching the exception");
		 println(ex.toString());
         println(ex.getMessage());
	}
}

def updateMachine(Map config = [:]) {
  //POST
	try {
	  def post = new URL("http://54.36.230.136:2000/api/machine/update/${config.branch_name}").openConnection();
	  def message = '{"message":"this is a message"}'
    	  post.setRequestMethod("POST")
	  post.setDoOutput(true)
	  post.setRequestProperty("Content-Type", "application/json")
	  post.getOutputStream().write(message.getBytes("UTF-8"));
	  def postRC = post.getResponseCode();
	  println(postRC);
       	  return postRC;
	  if(postRC.equals(200)) {
	    println("Machine is Updated.");
	  }  else {
	  	println("Machine is cannot Updated!")
	  }
	} catch (Exception ex) {
		println("Catching the exception");
		 println(ex.toString());
         println(ex.getMessage());
	}
}
