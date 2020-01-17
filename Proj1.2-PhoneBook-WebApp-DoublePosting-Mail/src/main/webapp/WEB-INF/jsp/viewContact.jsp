<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
  <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>  
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="black">
           
<form:form>
   <table border="12" align="center" bordercolor="red" bgcolor="yellow"  height="300">
        
       <thead align="center">
             <tr>
                <td colspan="5" align="center" bgcolor="black" height="40"><b><font color="white" size="6">PhoneBook Details </font></b></td>
             </tr>
              <tr>
           <td colspan="5" align="left" bgcolor="#9ACD32"> <a href="/" title="+Add New Contact">+Add New Contact</a></td>
         </tr>
           <tr style="color:blue; background-color:#9ACD32">
           <td>S.NO</td><td>Name</td><td>Email</td><td>Phno</td><td>Action</td>
           </tr>
       </thead>
       <tbody >
          <c:forEach items="${contactList}" var="c" varStatus="count">
                       <tr> 
                            <td><c:out value="${count.index+1}" /></td>
                          
                            <td><c:out value="${c.contactName}" /></td>
                        
                            <td><c:out value="${c.contactEmail}" /></td>
                         
                            <td><c:out value="${c.phNo}" /></td>
                            <td bgcolor="#9ACD32"> 
                            	<a href="editContact?cnctId=${c.contactId}" title="Edit">Edit</a>
                            	<a href="deleteContact?cnctId=${c.contactId}" title="Delete" onclick = "if ( !confirm('If You Want to Delete then Click OK Otherwise Click Cancel ?')) { return false; }">Delete</a>
                             </td>    
                      </tr>
                         
       </c:forEach>
       
       </tbody>
       
   </table> 
   <hr>

</form:form>

</body>
</html>