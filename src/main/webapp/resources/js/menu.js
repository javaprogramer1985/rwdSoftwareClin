$(document).ready(main);
var contador = 1;
function main() {
    $('.menu_bar').click(
            function () {
                if (contador === 1){
                    $('sidebar').animate({
                        left:'0'
                    });
                }else{
                     $('sidebar').animate({
                        left:'-100%'
                    });
                }
            }
    );
}
;