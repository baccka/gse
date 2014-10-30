

<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>

<html>
    <head>
        
        <link href="<c:url value="/css/bootstrap.min.css" />" rel="stylesheet">
<script src="<c:url value="/js/bootstrap.min.js" />"></script>
        
    </head>
    <body>
        <div class="container-fluid" style="margin-top:10px;">
            
            <div class="row">
                
                <div class="col-xs-2"><h4>GSE</h4></div>
                
  <div class="col-xs-8">
    <div class="input-group">
      <input type="text" class="form-control">
      <span class="input-group-btn">
        <button class="btn btn-default" type="button">
            <span class="glyphicon glyphicon-search"></span>
        </button>
      </span>
    </div>
  </div>
                
   <div class="col-xs-2 text-right">
       <button type="button" class="btn btn-default">
  <span class="glyphicon glyphicon-shopping-cart"></span> 0
</button>
  </div>
</div>
            
            <div class="row">
                <div class="col-xs-2">
                            <p>
    Product categories:
</p> 
<c:forEach var="category" begin="0" items="${requestScope.categories}">
<p>
   ${category.name}&nbsp;&nbsp;
</p> 
</c:forEach>
                    
                </div>
                
                <div class="col-xs-8">
                    <div class="row">
                        <div class="col-sm-6 col-md-4"><p> Product A</p></div>
                        <div class="col-sm-4 col-md-4"><p> Product B</p></div>
                        <div class="col-sm-4 col-md-4"><p> Product C</p></div>
                    </div>
                    
                    
                </div>
                
                <div class="col-xs-2 text-right">
<c:forEach var="shop" begin="0" items="${requestScope.shops}">
<p>
   ${shop.name}
</p> 
</c:forEach>
                    
                </div>
  
</div>
        
        




</div>
    </body>
</html>

