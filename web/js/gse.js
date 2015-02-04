// The javascript code for GSE

$(document).ready(function(){
    // Indent the search box text if there are any search badges present
    var badge = $(".search-badge");
    if (badge.length) {
        console.log("YES BADGE")
        $("#searchField").css("padding-left", badge.outerWidth() + 6);
    }
    
    // Allow the user to search by pressing the 'enter' key.
    $("#searchField").keypress(function(event) {
        if (event.which == 13) {
            event.preventDefault();
            $("#searchForm").submit();
        }
    });
});

