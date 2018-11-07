$(document).ready(main);
var contador = 1;
function main() {
    $('.button').click(
            function () {
                if (contador === 1){
                    $(".sidebar").animate({
                        left:'0'
                    });
                    $(".menu_bar").animate({
                       marginLeft:'90%'
                    });
                    $("button span i").removeClass('fa-arrow-right');
                    $("button span i").addClass('fa-arrow-left');
                    
                    contador = 2;
                }else{
                     $(".sidebar").animate({
                        left:'-100%'
                    });
                    $(".menu_bar").animate({
                        marginLeft: '0'
                    });
                    $("button span i").addClass('fa-arrow-right');                    
                    $("button span i").removeClass('fa-arrow-left');
                    
                    contador = 1;
                }
            }
    );
}
;