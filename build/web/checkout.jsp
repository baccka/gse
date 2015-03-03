

<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="en_IE"/>


<!DOCTYPE html>

<html>
    <head>
        
    <link href="<c:url value="/css/bootstrap.min.css" />" rel="stylesheet">
    <link href="<c:url value="/css/gse.css" />" rel="stylesheet">
    <script src="<c:url value="/js/jquery-2.1.1.min.js" />"></script>
    <script src="<c:url value="/js/bootstrap.min.js" />"></script>
    <script src="<c:url value="/js/gse.js" />"></script>
        
    </head>
    <body>
        <nav style="background-color: #f5f5f5;border-bottom-color: #ddd;border-bottom-style: solid;border-bottom-width: 1px;margin-bottom:20px;">
        <div class="container-fluid">
                                <div class="row" style="padding-top:10px;padding-bottom:10px;">

                         <div class="col-xs-2"><a href="<c:url value="/"/>"><h4 style="color:#333;margin: 0 !important;line-height:34px;">GSE</h4></a></div>

           <div class="col-xs-8">  
             <form id="searchForm" role="form" action="search" method="get">
             <div class="input-group">
               <input id="searchField" type="text" class="form-control" name="q" placeholder="What will you buy today?" value="${requestScope.searchQuery}">
               <span class="input-group-btn">
                 <button class="btn btn-default" type="submit">
                     <span class="glyphicon glyphicon-search"></span>
                 </button>
               </span>
               <c:if test="${shopName != null}">
                 <input type="hidden" name="s" value="${shopName}" />
                 <div class="search-badge">${shopName} <a data-param="s"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></a></div>
               </c:if>
               <c:if test="${categoryQuery != null}">
                 <input type="hidden" name="c" value="${categoryQuery}" />
                 <div class="search-badge">${categoryQuery} <a data-param="c"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></a></div>
               </c:if>
             </div>
             </form>
           </div>

            <div class="col-xs-2 text-right">
                <c:choose> 
                <c:when test="${customer == null}">
                 <button class="btn btn-primary" type="button" data-toggle="modal" data-target ="#myModal">
                     Sign in
                 </button>
                </c:when>
                <c:otherwise>
                <span class="dropdown">
                    <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-expanded="true">
                      <span class="glyphicon glyphicon-user" aria-hidden="true"></span>
                      <span class="caret"></span>
                    </button>
                    <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
                      <li role="presentation"><a role="menuitem" tabindex="-1" href="logout">Logout</a></li>
                    </ul>
                 </span>
                </c:otherwise>
                </c:choose>
                <a class="btn btn-default" href="cart">
                     <span class="glyphicon glyphicon-shopping-cart"></span>
                     <span id="numItems"><c:choose> 
                         <c:when test="${cart == null}"> 0</c:when>
                         <c:otherwise> ${cart.numItems}</c:otherwise>
                     </c:choose></span>
                </a>
             </div>
           </div>
        </div>
        </nav>
      
        <div class="container-fluid">
            
            <div class="row">
                <div class="col-xs-2">
                     
                </div>
                
                <div class="col-xs-8">
                    <table class="table">
      <thead>
        <tr>
          <th>Product</th>
          <th>Shop</th>
          <th>Quantity</th>
          <th>Price</th>
          
        </tr>
      </thead>
      <tbody>
        <c:forEach var="line" varStatus="status" begin="0" items="${cartLines}">
             <tr>
                <td><img src="<c:url value="${line.FKProductID.mainImage}"/>" alt="" style="height: 48px; width: auto;">
                 ${line.FKProductID.name}</td>
                <td>${line.FKShopID.name}</td>
                <td>${line.quantity}</td>
                <td><fmt:formatNumber value="${productInstances[status.index].price}" type="currency"/></td>
            </tr>
        </c:forEach>
      </tbody>
    </table>
                        <p> Total: <strong><fmt:formatNumber value="${cartTotal}" type="currency"/></strong></p>
                    
                    <form class="form-horizontal" role="form" action="order" method="post">
  <div class="form-group form-group-sm">
      <h4 class="col-sm-offset-2 col-sm-10">Deliver to</h4>
  </div>
  <div class="form-group form-group-sm">
    <label class="col-sm-2 control-label" for="formGroupInputSmall">Street 1</label>
    <div class="col-sm-4">
      <input class="form-control" type="text" id="formGroupInputSmall" placeholder="">
    </div>
  </div>
   <div class="form-group form-group-sm">
    <label class="col-sm-2 control-label" for="formGroupInputSmall">Street 2</label>
    <div class="col-sm-4">
      <input class="form-control" type="text" id="formGroupInputSmall" placeholder="">
    </div>
  </div>
  <div class="form-group form-group-sm">
    <label class="col-sm-2 control-label" for="formGroupInputSmall">City</label>
    <div class="col-sm-4">
      <input class="form-control" type="text" id="formGroupInputSmall" placeholder="">
    </div>
  </div>
  <div class="form-group form-group-sm">
    <p class="col-sm-offset-2 col-sm-4">
        Ireland
    </p>
  </div>
                        
    <div class="form-group form-group-sm">
      <h4 class="col-sm-offset-2 col-sm-10">Payment Details</h4>
  </div>
  <div class="form-group form-group-sm">
    <label class="col-sm-2 control-label" for="formGroupInputSmall">CC Number</label>
    <div class="col-sm-4">
      <input class="form-control" type="text" id="formGroupInputSmall" placeholder="">
    </div>
  </div>
   <div class="form-group form-group-sm">
    <label class="col-sm-2 control-label" for="formGroupInputSmall">Valid until</label>
    <div class="col-sm-4">
      <input class="form-control" type="text" id="formGroupInputSmall" placeholder="">
    </div>
  </div>
  <div class="form-group form-group-sm">
    <label class="col-sm-2 control-label" for="formGroupInputSmall">CCV</label>
    <div class="col-sm-4">
      <input class="form-control" type="text" id="formGroupInputSmall" placeholder="">
    </div>
  </div>
   <div class="form-group form-group-sm">
       <div class="col-sm-offset-2 col-sm-10">
           <button type="submit" class="btn btn-primary" >Place order</button>
       </div>
  </div>
</form>
                    
                    
                </div>
                
                <div class="col-xs-2 text-right">
                    
                </div>
  
</div>
        
        




</div>
    <div class ="modal" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">Sign in</h4>
      </div>
      <div class="modal-body">
        <form class="form-horizontal" id="loginDetails" role="form" action="login" method="POST">
            <div class="form-group" id="notLoggedInMessage" style="display:none;">
                <div class="col-sm-offset-2 col-sm-8">
                    <p class="text-danger">
                        <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
                        You need to be logged in before adding items to cart.</p>
            </div></div>
            <div class="form-group" id="loginErrorMessage" style="display:none;">
                <div class="col-sm-offset-2 col-sm-8">
                    <p class="text-danger">
                        <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
                        <strong>Error: </strong>Invalid username or password!</p>
                </div></div>
              <div class="form-group">
    <label for="inputEmail" class="col-sm-2 control-label">Email</label>
    <div class="col-sm-8">
      <input type="email" class="form-control" id="inputEmail" name ="email" placeholder="Email">
    </div>
  </div>
            <div class="form-group">
    <label for="inputPassword" class="col-sm-2 control-label">Password</label>
    <div class="col-sm-8">
      <input type="password" class="form-control" id="inputPassword" name ="pass" placeholder="Password">
    </div>
  </div>
            <div class="form-group">
    <div class="col-sm-offset-2 col-sm-8">
      <button class="btn btn-primary" type="submit" id="loginBtn">Sign in</button>
      <button class="btn btn-default"  type="submit" id="registerBtn">Register</button>
    </div>
  </div>
        </form>
    </div>
  </div>
      </div>
  </div>
    </body>
</html>

