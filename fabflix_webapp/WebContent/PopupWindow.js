function leave()
{
	$('#Popup').hide();
	$('#MovieInformations').html("");
}

function enter()
{
	$('#Popup').hide();
	movieid = $(this).attr('id');
	$.get('PopupServlet', {movieid: movieid}, function(responseText) {
		
        $('#MovieInformations').html(responseText);
        $('#Popup').fadeIn();
    });
	
	var position = $(this).offset();
    var height = $(this).height();
    
    $('#Popup').css({
    	'position': 'absolute',
        top: position.top + height + 'px',
        left: position.left + 'px'
    });
}

function main()
{
	$('#Popup').remove();
	
	var window = $(
			'<div id="Popup">' +
				'<div id="MovieInformations"></div>' +
			'</div>');
	
	$('body').append(window);
	$('#Popup').hide();
	
	var movieid;

	$('#Popup').mouseleave(leave);
	
	$('.enter').mouseenter(enter);
}

$(document).ready(main);