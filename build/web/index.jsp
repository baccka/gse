

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
        <div class="container-fluid" style="margin-top:10px;">
            
            <div class="row">
                
                <div class="col-xs-2"><a href="<c:url value="/"/>"><h4>GSE</h4></a></div>
                
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
        <button class="btn btn-primary" type="button">
            Sign in
        </button>
       <a class="btn btn-default" href="cart">
            <span class="glyphicon glyphicon-shopping-cart"></span> 0
       </a>
    </div>
  </div>
            
            <div class="row" style="margin-top:20px;">
                <div class="col-xs-2">
                    
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
                                                <strong>€ 12.00</strong><small> at Tesco</small> 
                                            </p>
                                        </c:if>
                                    </div>
                                    <div class="thumbnail productActions">
                                        <hr>
                                        <div class="caption">
                                            <form class="form-inline pull-right addToCartForm" data-id="${product.id}">
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
<c:forEach var="shop" begin="0" items="${requestScope.shops}">
<p>
   <a href="<c:url value="/search?s="/>${shop.name}">${shop.name}</a>
</p>
</c:forEach>
                    
                </div>
  
</div>
        
        




</div>
    </body>
</html>

