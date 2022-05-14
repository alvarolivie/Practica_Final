let pedidos;

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




