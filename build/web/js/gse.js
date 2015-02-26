// The javascript code for GSE

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
    
    $(".productContainer").click(function() {
        var id = $(this).attr("data-id");
        console.log("click: " + id);
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
        var count = $(this).find("select").val();
        $.post("addToCart", {id: id, count: count}, function( data ) {
            console.log(data);
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

