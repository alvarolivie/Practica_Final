let info = ['','','','','','','','',''];

let rellenarFoto = (numArroz) => {
    var panel=document.getElementById("fotoydescripcion");
    if(numArroz==1){
        let diseño='<div class="row">\n' +
            '                <img src="resources/estrella.jpg" width="80%" height="80%">\n' +
            '            </div>\n' +
            '            <div class="row">\n' +
            '                <p class="lead text-muted">Este arroz fue un éxito desde el primer dia que lo hicimos con amigos. Es un arroz con secreto ibérico y morcilla con un poco de miel. Una mezcla rara que sorprende</p>\n' +
            '            </div>';
        panel.innerHTML=diseño;
    }
    if(numArroz==2){
        let diseño='<div class="row">\n' +
            '                <img src="resources/alamar.jpg" width="80%" height="80%">\n' +
            '            </div>\n' +
            '            <div class="row">\n' +
            '                <p class="lead text-muted">Siempre decimos que lo importante es el producto, en este arroz es necesario. Con estos arroces solemos bajar al puerto de pedreña donde vemos que han cogido ese dia y elegimos en el momento</p>\n' +
            '            </div>';
        panel.innerHTML=diseño;

    }
    if(numArroz==3){
        let diseño='<div class="row">\n' +
            '                <img src="resources/conejo.jpg" width="80%" height="80%">\n' +
            '            </div>\n' +
            '            <div class="row">\n' +
            '                <p class="lead text-muted">Este arroz es el mismo arroz que tomas un dia de primavera en el campo. LLeva verduras variadas y una pieza de carne como liebre o conejo. Un arroz un poco mas tradicional.</p>\n' +
            '            </div>';
        panel.innerHTML=diseño;

    }
}

let guardarDat = () => {
    let inputs = document.getElementsByTagName("input")
    info[6] = inputs.item(0).value;
    info[7] = inputs.item(1).value;
    info[8] = inputs.item(2).value;
    if (info[6]!= '' & info[7]!= '' & info[7]!= '') {
        return true;
    }
    else {
        return false;
    }

}

let mandarForm = async () => {
    if (guardarDat()) {
        fetch("elPeroli/v1/cliente/newPedido", {
            method: "POST",
            headers: {
                "content-Type": "application/json",
                "Accept": "application/json"
            },
            body: JSON.stringify({
                "email": info[7],
                "fullname": info[6],
                "tel": info[8],
                "personas": info[1],
                "arroz": info[0],
                "fecha": info[2],
                "momento": info[5],
                "ciudad": info[4],
                "dir1": info[3]
            })
        }).then(res => {
            if (res.ok) {
                alert("Todo correcto");
                pantallaFinal();
            } else {
                return res.text().then(text => {
                    throw new Error(text)
                })
            }
        })
            .catch(error => {
                alert("Por favor compruebe los datos");
            });
    }
    else {
        alert("Porfavor rellena todos los campos")
    }
}

let siguienteForm = () => {
    let inputs = document.getElementsByTagName("input")
    info[1] = inputs.item(0).value;
    info[2] = inputs.item(1).value;
    info[3] = inputs.item(2).value;
    info[4]=document.getElementById("Ciudad").value;
    if (inputs.item(3).checked) {
        info[5]="COMIDA";
    } else {
        info[5]= "CENA";
    }
    if ((info[1] != '') & (info[2] != '') & (info[3] != '')) {

        let form = document.getElementById("form");
        form.innerHTML = '<div class="row">' +
            ' <label type="nombre" class="form-label">Nombre:</label>' +
            ' <input type="text" class="form-control" id="nombre">' +
            '</div>' +
            '<br>' +
            '<br>' +

            '<div class="row">' +
            '<label type="email" class="form-label">Correo electronico:</label>' +
            ' <input type="text" class="form-control" id="email">' +
            '</div>' +
            ' <br>' +
            '<br>' +

            '<div class="row">' +
            '<label class="form-label">Numero de telefono:</label>' +
            '<input type="tel" class="form-control" id="telf">' +
            '</div>' +
            '<br>' +
            '<br>' +
            '<button type="button" class="btn btn-primary" onclick="cargarForm()">Atras</button>'+
            '<button type="button" class="btn btn-primary" onclick="mandarForm()">Enviar</button>';
        let nombre = document.getElementById("nombre");
        nombre.value = info[6];
        let email = document.getElementById("email");
        email.value = info[7];
        let tel =document.getElementById("telf");
        tel.value = info[8];
    }
    else {
            alert("Porfavor rellena todos los campos");
    }

}

let cargarForm = () => {
    guardarDat();
    sessionStorage["info"]=JSON.stringify(info);
    location.reload();
}

let cargarHTML = () => {
    let numArroz = location.search.substring(1);
    info[0]=numArroz;
    rellenarFoto(numArroz);
    let storage = sessionStorage["info"];
    if (storage){
        info = JSON.parse(storage);
        console.log(info);
        let numPersonas = document.getElementById("numPersonas");
        numPersonas.value = info[1];
        let fecha = document.getElementById("fecha");
        fecha.value = info[2];
        let dir =document.getElementById("Dir1");
        dir.value = info[3];
    }
}

let pantallaFinal = () => {
    let form = document.getElementById("form");
    form.innerHTML = '<div class="col-md-5 ">\n' +
        '                <h1 class="display-6 fw-bolder">Pedido solicitado con éxito</h1>\n' +
        '                <p class="lead fw-normal">Se contactara con usted cuanto antes</p>\n' +
        '                <a href="Pedido.html" class="btn btn-primary my-2">Volver a pedidos</a>\n' +
        '            </div>'
}