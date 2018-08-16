<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
body {
	background-color:  #24df02 ;
}

h1 {
	color: blue;
}

h1 {
	background-color:  #f1df02 ;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sell Product</title>
</head>
<body>
<% request.getRequestDispatcher("link.html").include(request, response);
%>
<br><br>
<form action="ProfileFarmer">
<!-- <%= "Add your products" %> --><br><br>
Item:    <select name="Item">
			<option value="Wheat">Wheat</option>
			<option value="Paddy">Paddy</option>
			<option value="Corn">Corn</option>
			<option value="Chilly">Chilly</option>

		</select><br><br>
Quantity:<input type="text" id="quant" name="quant" >Kg<br><br>
Price:<input type="text" id="rate" name="rate" >/kg<br><br>
<input type="submit" value="Add Product">
</form>
</body>
</html>