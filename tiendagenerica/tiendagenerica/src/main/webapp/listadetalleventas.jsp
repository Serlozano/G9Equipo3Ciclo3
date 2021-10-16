<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>


<!-- paquete de caracteres -->
<meta charset="utf-8">
<!-- Tama�o de la pantalla -->
<meta name="viewport" content="width=device-width">
<!-- titulo de la pesta�a -->
<title>Lista de Detalle Ventas</title>
<!-- bootstrap-->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">

<!-- font awesome -->
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.15.4/css/all.css"
	integrity="sha384-DyZ88mC6Up2uqS4h/KRgHuoeGwBcD4Ng9SiP4dIRy0EXTlnuz47vAwmeGwVChigm"
	crossorigin="anonymous">

<!-- Cargando mi hoja de estilo -->
<link href="style.css" rel="stylesheet" type="text/css" />


<script>
	
	function loaddetalleventas() {
		
		var getUrl = window.location;
		var baseUrl = getUrl.protocol + "//" + getUrl.host + "/" + getUrl.pathname.split('/')[1];

		
		var xmlhttp = new XMLHttpRequest();
		xmlhttp.open("GET", baseUrl+'/listardetalleventas', true);
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
				var detalleventas = JSON.parse(xmlhttp.responseText);
				var tbltop = "<table class='table table-dark table-striped'><tr><th>Codigo de la venta</th><th>Cantidad Producto</th><th>Codigo Producto</th><th>Codigo Venta</th><th>Valor Total</th><th>Valor Venta</th><th>Valor Iva</th></tr>";
				var main = "";
				for (i = 0; i < detalleventas.length; i++) {
					main += "<tr><td>" + detalleventas[i].codigo_detalle_venta
							+ "</td><td>" + detalleventas[i].cantidad_producto
							+ "</td><td>" + detalleventas[i].codigo_producto
							+ "</td><td>" + detalleventas[i].codigo_venta
							+ "</td><td>" + detalleventas[i].valor_total
							+ "</td><td>" + detalleventas[i].valor_venta
							+ "</td><td>" + detalleventas[i].valoriva + "</td></tr>";
				}
				var tblbottom = "</table>";
				var tbl = tbltop + main + tblbottom;
				document.getElementById("detalleventasinfo").innerHTML = tbl;
			}
		};
		xmlhttp.send();
	}
	window.onload = function() {
		loaddetalleventas();
	}
</script>

</head>


<body>
	<!-- Navbar-->
	<nav class="navbar navbar-dark bg-dark">
		<div class="container-fluid">
			<a class="navbar-brand links" href="index.html"><i
				class="fas fa-fish"></i>Tiendas ADI</a>
		</div>
	</nav>

	<!-- Navbar modulos-->
	<nav class="navbar navbar-dark bg-primary">
		<div class="container">
			<a class="navbar-brand links" href="listausuarios.jsp">
			<i class="fas fa-users"></i> Usuarios</a> 
			<a class="navbar-brand links" href="listaclientes.jsp">
			<i class="fas fa-address-book"></i> Clientes</a>
			<a class="navbar-brand links" href="listaproveedores.jsp">
			<i class="fas fa-truck"></i> Proveedores</a>
			<a class="navbar-brand links" href="listaproductos.jsp">
			<i class="fas fa-apple-alt"></i> Productos</a>
			<a class="navbar-brand links" href="listaventas.jsp">
			<i class="fas fa-money-check-alt"></i> Ventas</a>
			<a class="navbar-brand links" href="listareportes.jsp">
			<i class="fas fa-clipboard-list"></i> Reportes</a>
		</div>
	</nav>
	
	
	<!-- contenido  -->
	
	<div style="padding-left: 5px;">
	
		<h1><i class="fas fa-list-ol"></i> Tabla de Detalle Ventas</h1>
			<div class="container">
				<div class="row">
					<!--  Aqui es donde se autogenera la tabla basado en el script -->
					<div class="col align-self-center" id="detalleventasinfo">
					
					</div>
	
				</div>
			</div>
	
		<h1><i class="fas fa-cogs"></i> Operaciones</h1>
			<div class="container">
				<div class="row">
				<button type="button" class="btn btn-primary"
						onclick="window.location.href='<%=request.getContextPath()%>/listadousuarios.jsp'">
						<i class="fas fa-search"></i> Listado de usuarios
					</button>
					<button type="button" class="btn btn-primary"
						onclick="window.location.href='<%=request.getContextPath()%>/listadoclientes.jsp'">
						<i class="fas fa-search"></i> Listado de clientes 
					</button>
					<button type="button" class="btn btn-primary"
						onclick="window.location.href='<%=request.getContextPath()%>/listadetalleventas.jsp'">
						<i class="fas fa-search"></i> Listado de detalle ventas
					</button>
				</div>
			</div>
	</div>
	<br><br>

	<nav class="navbar fixed-bottom navbar-dark bg-dark">
		<div class="row justify-content-between">
			<div class="col-4">
				<a class="navbar-brand links" href="#"><i class="fas fa-code"></i>
					Dise�ado y programado por Sergio Lozano - Alba Jer�nimo - Diana Lucero - Sergio Llanos - Mhartim Mhesak <i
					class="fas fa-code-branch"></i></a>
			</div>
		</div>
	</nav>


</body>
</html>