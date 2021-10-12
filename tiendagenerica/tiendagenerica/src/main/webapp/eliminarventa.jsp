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
<title>Eliminar venta</title>
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
			<a class="navbar-brand links" href="listausuarios.jsp"> <i
				class="fas fa-users"></i> Usuarios
			</a> <a class="navbar-brand links" href="listaclientes.jsp"> <i
				class="fas fa-address-book"></i> Clientes
			</a> <a class="navbar-brand links" href="listaproveedores.jsp"> <i
				class="fas fa-truck"></i> Proveedores
			</a> <a class="navbar-brand links" href="listaproductos.jsp"> <i
				class="fas fa-apple-alt"></i> Productos
			</a> <a class="navbar-brand links" href="listaventas.jsp"> <i
				class="fas fa-money-check-alt"></i> Ventas
			</a> <a class="navbar-brand links" href="listareportes.jsp"> <i
				class="fas fa-clipboard-list"></i> Reportes
			</a>
		</div>
	</nav>

	<div style="padding-left: 5px">
		<h1>
			<i class="fas fa-skull-crossbones"></i> Datos de la venta a eliminar
		</h1>
		<div class="container">


			<div id="error" class="alert alert-danger visually-hidden"
				role="alert">Error al eliminar la vebta, verifique que 
				exista el codigo de la venta digitado</div>

			<div id="correcto" class="alert alert-success visually-hidden"
				role="alert">Venta eliminada con exito</div>

			<form id="form1">
			
				<div class="input-group mb-3">
					<span class="input-group-text" id="basic-addon1">codigo de venta</span> <input
						type="text" class="form-control"
						placeholder="Inserte codigo de venta aqui..."
						aria-describedby="basic-addon1" required id="codigo_venta">
				</div>

			</form>

			<button type="button" class="btn btn-danger" onclick="eliminar()">
				<i class="fas fa-skull-crossbones"></i> Eliminar venta
			</button>
			
			<br>
			<br>
			<br>
			<h1>
				<i class="fas fa-cogs"></i> Operaciones
			</h1>
			<div class="container">
				<div class="row">
					<button type="button" class="btn btn-success"
						onclick="window.location.href='<%=request.getContextPath()%>/insertarventa.jsp'">
						<i class="fas fa-plus-circle"></i> Agregar venta
					</button>
					<button type="button" class="btn btn-danger"
						onclick="window.location.href='<%=request.getContextPath()%>/eliminarventa.jsp'">
						<i class="fas fa-trash"></i> Eliminar venta
					</button>
					<button type="button" class="btn btn-warning"
						onclick="window.location.href='<%=request.getContextPath()%>/actualizarventa.jsp'">
						<i class="fas fa-pen-alt"></i> Actualizar venta
					</button>
					<button type="button" class="btn btn-primary"
						onclick="window.location.href='<%=request.getContextPath()%>/buscarventa.jsp'">
						<i class="fas fa-search"></i> Buscar una venta
					</button>
					<button type="button" class="btn btn-primary"
						onclick="window.location.href='<%=request.getContextPath()%>/listaventas.jsp'">
						<i class="fas fa-search"></i> Listar todos las ventas
					</button>
				</div>
			</div>
		</div>

	</div>
	<nav class="navbar fixed-bottom navbar-dark bg-dark">
		<div class="row justify-content-between">
			<div class="col-4">
				<a class="navbar-brand links" href="#"><i class="fas fa-code"></i>
					Dise�ado y programado por Sergio Lozano - Alba Jer�nimo - Diana Lucero - Sergio Llanos - Mhartim Mhesak <i
					class="fas fa-code-branch"></i></a>
			</div>
		</div>
	</nav>
	<script>
		function eliminar() {
			
			var getUrl = window.location;
			var baseUrl = getUrl.protocol + "//" + getUrl.host + "/" + getUrl.pathname.split('/')[1];

			
			var y = document.getElementById("codigo_venta").value;
			var req = new XMLHttpRequest();
			var coincidencia = false;
			req.open('GET', baseUrl+'/listarventas', false);
			req.send(null);
			var ventas = null;
			if (req.status == 200)
				ventas = JSON.parse(req.responseText);
			console.log(JSON.parse(req.responseText));

			for (i = 0; i < ventas.length; i++) {
				
				console.log(ventas[i].codigo_venta);
				if (ventas[i].codigo_venta == y) {
					console.log(ventas[i].codigo_venta + " " + y);
					coincidencia = true
					break;
				}
			}
			console.log(coincidencia);

			if (coincidencia != false) {
				var codigo=document.getElementById("codigo_venta").value;
				
				var xhr = new XMLHttpRequest();
				xhr.open("DELETE", "http://localhost:8080/eliminarventa?code="+codigo);
				
				var element = document.getElementById("error");
				element.classList.add("visually-hidden");
				
				var element2 = document.getElementById("correcto");
				element2.classList.remove("visually-hidden");

				document.getElementById("codigo_venta").value = "";
				xhr.send();

			} else {
				var element = document.getElementById("error");
				element.classList.remove("visually-hidden");
				
				var element2 = document.getElementById("correcto");
				element2.classList.add("visually-hidden");
				
				document.getElementById("codigo_venta").value = "";;
			}
		}
	</script>

</body>
</html>