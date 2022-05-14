let pedidos;

let cargarPedidos=async()=>{
    let roles = sessionStorage["roles"];
    let res=await fetch("elPeroli/v1/owner/viewPedidos");
    console.log(res);
    if (res.ok) {
        pedidos= await res.json();
        console.log(pedidos);
    }
    if(true){

        let tabla = document.getElementById('pedidos');
        for(let i=0; i <pedidos.length; i++){
            console.log(1);
            let newRow = tabla.insertRow(tabla.length);
            let pedidoActual=json2array(pedidos[i]);
            for(let j=0; j<pedidoActual.length; j++){
                console.log(2);
                let cell = newRow.insertCell(j);
                cell.innerHTML = pedidoActual[j];
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