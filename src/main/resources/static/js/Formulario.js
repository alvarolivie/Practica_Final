let rellenarFoto = (numArroz) => {
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
}

let mandarForm = () => {

}


let selectPedido = () => {
    let numArroz = location.search.substring(1);
    rellenarFoto(numArroz);
}