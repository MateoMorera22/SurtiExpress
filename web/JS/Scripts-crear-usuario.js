    $(document).ready(function() {
    $('.slider').slider({
        full_width: true,
        interval: 5000,
        transition: 800,
    });
});



$(document).ready(function() {

    var height = $(window).height();

    $('#panel').height(height);
});


$(document).ready(function() {

    var height = $(window).height();

    $('#banner').height(height);
});