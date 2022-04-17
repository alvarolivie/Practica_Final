

function selectPedido(){
    let numArroz;
    console.log(num);
    numArroz=num;
    console.log(numArroz);
    window.location.assign("./Pedido2.html");
    window.addEventListener('load',function() {
        console.log(numArroz);
        var panel=document.getElementById("fotoydescripcion");
        if(numArroz==1){
            let diseño='<div class="row">\n' +
                '                <img src="resources/estrella.jpg" width="80%" height="80%">\n' +
                '            </div>\n' +
                '            <div class="row">\n' +
                '                <p class="lead text-muted">Descripcion del arroz aqui ..............................</p>\n' +
                '            </div>';
            panel.innerHTML=diseño;
        }
        if(numArroz==2){
            let diseño='<div class="row">\n' +
                '                <img src="resources/alamar.jpg" width="80%" height="80%">\n' +
                '            </div>\n' +
                '            <div class="row">\n' +
                '                <p class="lead text-muted">Descripcion del arroz aqui ..............................</p>\n' +
                '            </div>';
            panel.innerHTML=diseño;

        }
        if(numArroz==3){
            let diseño='<div class="row">\n' +
                '                <img src="resources/conejo.jpg" width="80%" height="80%">\n' +
                '            </div>\n' +
                '            <div class="row">\n' +
                '                <p class="lead text-muted">Descripcion del arroz aqui ..............................</p>\n' +
                '            </div>';
            panel.innerHTML=diseño;

        }
    }, true);


}