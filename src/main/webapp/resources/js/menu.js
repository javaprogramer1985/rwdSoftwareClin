$(document).ready(main);
var contador = 1;
function main() {
    $(".menu_bar").click(
            function () {
                if (contador === 1){
                    alert("OK1");
                    $("sidebar").animate({
                        left:'0'
                    });
                }else{
                    alert("OK2");
                     $("sidebar").animate({
                        left:'-100%'
                    });
                }
            }
    );
}
;