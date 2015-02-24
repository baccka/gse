// The javascript code for GSE

$(document).ready(function(){
    // Indent the search box text if there are any search badges present

    var badgeOffset = 3;
    var badges = $('.search-badge');
    $.each(badges, function() {
        $(this).css('left', badgeOffset); 
        badgeOffset += $(this).outerWidth()+3; 
    });
    if (badges.length) {
        console.log("YES BADGE")
        $("#searchField").css("padding-left", badgeOffset);
    }
    
    
    // Allow the user to search by pressing the 'enter' key.
    $("#searchField").keypress(function(event) {
        if (event.which == 13) {
            event.preventDefault();
            $("#searchForm").submit();
        }
    });
});

