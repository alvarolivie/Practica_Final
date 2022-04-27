let infoJson;
let info = [];

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

let mandarForm = async () => {
    let inputs = document.getElementsByTagName("input")
    info.push(inputs.item(0).value, inputs.item(1).value,inputs.item(2).value);

    fetch("elPeroli/v1/cliente/newPedido", {
        method: "POST",
        headers: {
            "content-Type": "application/json",
            "Accept" : "application/json"
        },
        body: JSON.stringify({
            "email": info[6],
            "fullname": info[7],
            "tel": info[8],
            "personas": info[1],
            "arroz": info[0],
            "fecha": info[2],
            "momento": info[5],
            "ciudad": info[4],
            "dir1": info[3]
        })
    }).then(res => {
        if(res.ok) {
            alert("Todo correcto");
        }
        else {
            return res.text().then(text => { throw new Error(text) })
        }
    })
        .catch(error => {
            alert("Por favor compruebe los datos");
        });
}

let siguienteForm = () => {
    let inputs = document.getElementsByTagName("input")
    info.push(inputs.item(0).value, inputs.item(1).value,inputs.item(2).value);
    info.push(document.getElementById("Ciudad").value)
    if (inputs.item(3).checked){
        info.push("COMIDA")
    } else{
        info.push("CENA")
    }
    console.log(info)
    let form = document.getElementById("form");
    form.innerHTML= '<div class="row">'+
       ' <label type="nombre" class="form-label">Nombre:</label>'+
       ' <input type="text" class="form-control" id="nombre">'+
        '</div>'+
        '<br>'+
        '<br>'+

            '<div class="row">'+
                '<label type="email" class="form-label">Correo electronico:</label>'+
               ' <input type="text" class="form-control" id="email">'+
            '</div>'+
           ' <br>'+
                '<br>'+

                    '<div class="row">'+
                        '<label type="tel" class="form-label">Numero de telefono:</label>'+
                        '<input type="tel" class="form-control" id="telf">'+
                    '</div>'+
                    '<br>'+
                        '<br>'+

                            '<button type="button" class="btn btn-primary" onclick="mandarForm()">Enviar</button>';

                            }


let selectPedido = () => {
    let numArroz = location.search.substring(1);
    info.push(numArroz);
    rellenarFoto(numArroz);
}