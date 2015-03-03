// The javascript code for GSE

function removeURLParameter(url, parameter) {
    //prefer to use l.search if you have a location/link object
    var urlparts= url.split('?');   
    if (urlparts.length>=2) {

        var prefix= encodeURIComponent(parameter)+'=';
        var pars= urlparts[1].split(/[&;]/g);

        //reverse iteration as may be destructive
        for (var i= pars.length; i-- > 0;) {    
            //idiom for string.startsWith
            if (pars[i].lastIndexOf(prefix, 0) !== -1) {  
                pars.splice(i, 1);
            }
        }

        url= urlparts[0]+'?'+pars.join('&');
        return url;
    } else {
        return url;
    }
}

$(document).ready(function(){
    // Indent the search box text if there are any search badges present

    var badgeOffset = 3;
    var badges = $('.search-badge');
    $.each(badges, function() {
        $(this).css('left', badgeOffset); 
        badgeOffset += $(this).outerWidth() + 3; 
    });
    if (badges.length) {
        console.log("YES BADGE")
        $("#searchField").css("padding-left", badgeOffset + 3);
    }
    
    $(badges).find("a").click(function () {
       var param = $(this).attr("data-param");
       window.location = removeURLParameter(window.location + "", param);
    });
    
    $(".addToCartForm").click(function(e) { e.stopPropagation(); });
    $(".productContainer").click(function() {
        var id = $(this).attr("data-id");
        console.log("click: " + id);
        window.location = "product?p=" + id;
    })
    
    $(".productContainer").mouseenter(function(){
        $(this).find(".productActions").stop().slideDown();
    });
    $(".productContainer").mouseleave(function(){
        $(this).find(".productActions").stop().slideUp();
    });
    
    // This is a handler for the add to cart action.
    $(".addToCartForm").submit(function(event) {
        event.preventDefault();
        var id = $(this).attr("data-id");
        var shopId = $(this).attr("data-shopid");
        var count = $(this).find("select").val();
        $.post("addToCart", {id: id, shopId: shopId, count: count}, function( data ) {
            console.log(data);
            data = JSON.parse(data);
            if (data) {
                // Update the cart button
                $("#numItems").text(data.numItems);
            }
        }).fail(function(info) {
            console.log("Fail " + info.status);
            if (info.status == 401) {
                // Not logged in - show login screen
                $("#notLoggedInMessage").show();
                $("#loginErrorMessage").hide();
                $("#myModal").modal("show");
            }
        });
    });
    
    var action = 'login';
    $("#loginBtn").click(function () {
        action = 'login';
    });
    $("#registerBtn").click(function () {
        action = 'register';
    });
    
    $("#loginDetails").submit(function (event) {
       event.preventDefault();
       $("#loginErrorMessage").hide();
       $("#notLoggedInMessage").hide();
       var email = $(this).find("#inputEmail").val();
       var pass = $(this).find("#inputPassword").val();
       $.post(action, {email: email, pass: pass}, function( data ) {
            location.reload();
        }).fail(function(info, text) {
            $("#loginErrorMessage").show();
        });
    });
    
    // Allow the user to search by pressing the 'enter' key.
    $("#searchField").keypress(function(event) {
        if (event.which == 13) {
            event.preventDefault();
            $("#searchForm").submit();
        }
    });
});

