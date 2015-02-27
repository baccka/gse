

<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


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
                 <div class="search-badge">${shopName} <span class="glyphicon glyphicon-remove" aria-hidden="true"></span></div>
               </c:if>
               <c:if test="${categoryQuery != null}">
                 <input type="hidden" name="c" value="${categoryQuery}" />
                 <div class="search-badge">${categoryQuery} <span class="glyphicon glyphicon-remove" aria-hidden="true"></span></div>
               </c:if>
             </div>
             </form>
           </div>

            <div class="col-xs-2 text-right">
                 <button class="btn btn-primary" type="button" data-toggle="modal" data-target ="#myModal">
                     Sign in
                 </button>
                <a class="btn btn-default" href="cart">
                     <span class="glyphicon glyphicon-shopping-cart"></span> 0
                </a>
             </div>
           </div>
        </div>
        </nav>
      
        <div class="container-fluid">
            
            <div class="row">
                <div class="col-xs-2">
                    <div class="panel panel-default">
                        <div class="panel-heading">
    <h3 class="panel-title">Categories</h3>
  </div>
  <div class="panel-body">                    
<c:forEach var="category" begin="0" items="${requestScope.categories}">
<p>
    <c:if test="${shopName != null}">
        <a href="<c:url value="/search?s="/>${shopName}&c=${category.name}">${category.name}</a>
    </c:if>
    <c:if test="${shopName == null}">
        <a href="<c:url value="/search?c="/>${category.name}">${category.name}</a>
    </c:if>
</p> 
</c:forEach>
  </div></div>  
                </div>
                
                <div class="col-xs-8">
                    <div class="row">
                        <c:forEach var="product" varStatus="status" begin="0" items="${requestScope.products}">
                            <div class="col-sm-6 col-md-4">
                                <div class="thumbnail productContainer" data-id="${product.id}">
                                    <img src="<c:url value="${product.mainImage}"/>" alt="" style="height: 200px; width: auto; display: block;">
                                    <div class="caption">
                                        <div class="center-block" style="height: 48px">
                                            <h4 class="text-center">${product.name}</h4>
                                        </div>
                                        
                                        <p class="productDescription">${product.description}</p>
                                        <c:if test="${productInstances != null}">
                                            <p style="display: inline;">
                                                <strong>€ ${productInstances[status.index].price}</strong><small> at ${shops[productInstances[status.index].productInstancePK.shopID].name}</small> 
                                            </p>
                                        </c:if>
                                    </div>
                                    <div class="thumbnail productActions">
                                        <hr>
                                        <div class="caption">
                                            <form class="form-inline pull-right addToCartForm" data-id="${product.id}" data-shopid="${productInstances[status.index].productInstancePK.shopID}">
                                                <select class="form-control input-sm">
                                                    <option>1</option>
                                                    <option>2</option>
                                                    <option>3</option>
                                                    <option>4</option>
                                                    <option>5</option>
                                                    <option>6</option>
                                                </select>
                                                <button type="submit" class="btn btn-danger btn-sm">Add to cart</button>
                                            </form>
                                            <div class="clearfix"></div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                    
                    
                </div>
                
                <div class="col-xs-2 text-right">
                    <div class="panel panel-default">
                        <div class="panel-heading">
    <h3 class="panel-title">Shops</h3>
  </div>
  <div class="panel-body">
<c:forEach var="shop" begin="0" items="${requestScope.shops}">
<p>
   <a href="<c:url value="/search?s="/>${shop.name}">${shop.name}</a>
</p>
</c:forEach>
  </div>
                    </div>
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

        <form id ="LoginDetails" role="form" action ="login.jsp" method ="POST">
            <div class="input-group">
              <label class="Email ">
              <span>Email: </span>
              <input id ="email" name ="email" type = "text"/>
              </label><br/>
              <label class ="Password">
                <span>Password: </span>
                <input id = "password" name ="pass" type = "password"/>
              </label><br/>

              <br><button class ="btn btn-primary" type ="submit" >Sign in</button>
              <button class="btn btn-secondary"  type = "submit" formaction="register.jsp" >Register
              </button>
        </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
      </div>
  </div>
    </body>
</html>

