<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
    <title>Movie Titles & Years</title>
    <style><%@include file="../css/style.css"%></style>
</head>
<body>
<hr>

    <h1> Chose A Movie From The List</h1>
    <form method="get" action="/get/">
        <select name="id">
            <option value="tt8503618">Hamilton</option>
            <option value="tt0102926">Silence of the lambs</option>
            <option value="tt1985981">Desi Boys</option>
            <option value="tt0212985">Hannibal</option>


        </select>
        <input type="submit" value="Submit">
    </form>
    <hr/>
    <div>

       <h2>Title</h2> <h3><%=request.getParameter("Title")%></h3>
       <h2>Year</h2> <h3><%=request.getParameter("Year")%></h3>

    </div>



    <h2>Search History</h2>
    <form  method="save" action="/save/">
    <table  class="w3-table-all">
        <tr class="w3-blue">
            <th>Title</th>
            <th>Year</th>
        </tr>


        <c:forEach  var = "movie" items = "${movielist}">
            <tr>
                <td>${movie.getTitle()}</td>
                <td>${movie.getYear()}</td>
            </tr>
        </c:forEach>
        <input type="submit" value="Load">


    </table>

</body>
</html>
