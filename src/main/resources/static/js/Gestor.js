let pedidos;
let info = [];

let cargarPedidos=async()=>{
    //let roles = sessionStorage["roles"];
    let roles = [1,2,3];
    let res=await fetch("elPeroli/v1/owner/viewPedidos");
    console.log(res);
    if (res.ok) {
        pedidos= await res.json();
        console.log(pedidos);
    }
    if(roles.length==1){

        let tabla = document.getElementById('pedidos');
        for(let i=0; i <pedidos.length; i++){

            let newRow = tabla.insertRow(tabla.length);
            let pedidoActual=json2array(pedidos[i]);
            for(let j=0; j<pedidoActual.length; j++){

                let cell = newRow.insertCell(j);
                cell.innerHTML = pedidoActual[j];
            }
        }
    }else if(roles.length==2){

        let tabla = document.getElementById('pedidos');
        for(let i=0; i <pedidos.length; i++){

            let newRow = tabla.insertRow(tabla.length);
            let pedidoActual=json2array(pedidos[i]);
            for(let j=0; j<pedidoActual.length; j++){
                let cell = newRow.insertCell(j);
                if(j==11){
                    if(pedidoActual[j]=="ACEPTADA"){
                        cell.innerHTML= '<input type="radio" id="aceptado'+pedidoActual[0]+'" name="pedido'+pedidoActual[0]+'" value="1" checked>' + '<input type="radio" id="rechazado'+pedidoActual[0]+'" name="pedido'+pedidoActual[0]+'" value="2">';
                    }else if(pedidoActual[j]=="RECHAZADA"){
                        cell.innerHTML= '<input type="radio" id="aceptado'+pedidoActual[0]+'" name="pedido'+pedidoActual[0]+'" value="1">' + '<input type="radio" id="rechazado'+pedidoActual[0]+'" name="pedido'+pedidoActual[0]+'" value="2" checked>'
                    }else if(pedidoActual[j]=="PENDIENTE"){
                        cell.innerHTML= '<input type="radio" id="aceptado'+pedidoActual[0]+'" name="pedido'+pedidoActual[0]+'" value="1">' + '<input type="radio" id="rechazado'+pedidoActual[0]+'" name="pedido'+pedidoActual[0]+'" value="2">'
                    }

                }else{
                    cell.innerHTML = pedidoActual[j];
                }

            }
        }
    }else if(roles.length==3){

        let tabla = document.getElementById('pedidos');
        for(let i=0; i <pedidos.length; i++){

            let newRow = tabla.insertRow(tabla.length);
            let pedidoActual=json2array(pedidos[i]);
            for(let j=0; j<pedidoActual.length; j++){
                let cell = newRow.insertCell(j);
                if(j==11){
                    if(pedidoActual[j]=="ACEPTADA"){
                        cell.innerHTML= '<input type="radio" id="aceptado'+pedidoActual[0]+'" name="pedido'+pedidoActual[0]+'" value="1" checked>' + '<input type="radio" id="rechazado'+pedidoActual[0]+'" name="pedido'+pedidoActual[0]+'" value="2">';
                    }else if(pedidoActual[j]=="RECHAZADA"){
                        cell.innerHTML= '<input type="radio" id="aceptado'+pedidoActual[0]+'" name="pedido'+pedidoActual[0]+'" value="1">' + '<input type="radio" id="rechazado'+pedidoActual[0]+'" name="pedido'+pedidoActual[0]+'" value="2" checked>'
                    }else if(pedidoActual[j]=="PENDIENTE"){
                        cell.innerHTML= '<input type="radio" id="aceptado'+pedidoActual[0]+'" name="pedido'+pedidoActual[0]+'" value="1">' + '<input type="radio" id="rechazado'+pedidoActual[0]+'" name="pedido'+pedidoActual[0]+'" value="2">'
                    }

                }else if(j==10){
                    cell.innerHTML = '<input type="number" id="numPersonas' + pedidoActual[0] + '" name="numPersonas" value="'+pedidoActual[j]+'"><button type="button" class="btn btn-secondary" id="actualizarnumPersonas' + pedidoActual[0] + '" name="actualizarnumPersonas">Actualizar</button>';
                }else if(j==4){
                cell.innerHTML = '<input type="text" id="precio' + pedidoActual[0] + '" name="precio" value="'+pedidoActual[j]+'"><button type="button" class="btn btn-secondary" id="actualizarprecio' + pedidoActual[0] + '" name="actualizarprecio">Actualizar</button>';
            }else{
                    cell.innerHTML = pedidoActual[j];
                }

            }
        }
    }

}

let json2array=(json)=>{
    let result = [];
    let keys = Object.keys(json);
    keys.forEach(function(key){
        result.push(json[key]);
    });
    return result;
}




let buscaTabla=()=>{
    let table = document.getElementById("pedidos");
    let texto = document.getElementById('buscar').value.toLowerCase();
    let r = 0;
    let row= table.rows[r];
    console.log(row);
    while (row != null) {
        if (row.innerText.toLowerCase().indexOf(texto) !== -1){
            row.style.display = null;}
        else{
            row.style.display = 'none';}
        row=table.rows[r++];
    }
}

let guardarDat = () =>  {


    if (document.getElementById('arroz1').checked) {
        info[0]=1;
    } else if (document.getElementById('arroz2').checked) {
        info[0]= 2;
    }else if (document.getElementById('arroz3').checked) {
        info[0]= 3;
    }
    info[1]= document.getElementById('numPersonas').value;
    info[2]= document.getElementById('fecha').value;
    info[3] = document.getElementById("Ciudad").value;
    info[4] = document.getElementById('Dir1').value;
    if (document.getElementById('comida').checked) {
        info[5]="COMIDA";
    } else {
        info[5]= "CENA";
    }
    info[6] = document.getElementById('email').value;
    info[7] = document.getElementById('nombre').value;
    info[8] = document.getElementById('telf').value
    console.log(info);
    if(!info.includes('')) {
        return true;
    }
    else {
        return false;
    }

}

let mandarForm = async () => {
    if (guardarDat()) {
        fetch("elPeroli/v1/owner/newPedido", {
            method: "POST",
            headers: {
                "content-Type": "application/json",
                "Accept": "application/json"
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
            if (res.ok) {
                alert("Todo correcto");

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


