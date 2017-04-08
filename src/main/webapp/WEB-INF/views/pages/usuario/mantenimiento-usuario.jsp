<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<br />
<div class="row">
	<div class="col-md-12">
		<div class="widget">
			<header class="widget-header">
				<h4 class="widget-title">Buscar Usuario</h4>
			</header><!-- .widget-header -->
			<hr class="widget-separator">
			<div class="widget-body">
				<form id="register-form" name="register-form" method="post" role="form">
					<input type="hidden"  name="${_csrf.parameterName}" value="${_csrf.token}"/>
					<div class="row">
						<div class="col-md-4">
							<div class="form-group">
								<label class="control-label">Nombres: </label>
								<input type="text" class="form-control" id="txtNombre">
							</div>
						</div>
						<div class="col-md-4">
							<div class="form-group">
								<label class="control-label">Apellidos: </label>
								<input type="text" class="form-control" id="txtApellidos">
							</div>
						</div>
						<div class="col-md-4">
							<div class="form-group">
								<label class="control-label">DNI: </label>
								<input type="text" class="form-control" id="txtDNI">
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-md-2">
							<button type="button" class="btn rounded mw-md btn-primary">Consultar</button>
						</div>
						<div class="col-md-2">
							<button type="button" class="btn rounded mw-md btn-primary">Nuevo</button>
						</div>
					</div>
					<div class="row">
						<div class="col-md-12">
							<div class="widget">
								<header class="widget-header">
									<h4 class="widget-title">Listado de Usuarios</h4>
								</header><!-- .widget-header -->
							<hr class="widget-separator">
								<div class="widget-body">
									<div class="table-responsive">
										<table id="default-datatable" data-plugin="DataTable" class="table table-striped">
											<thead>
											<tr>
												<th class="text-center">Nombre</th>
												<th class="text-center">Posición</th>
												<th class="text-center">Oficina</th>
												<th class="text-center">Edad</th>
												<th class="text-center">Fecha de inicio</th>
												<th class="text-center">Salario</th>
												<th class="text-center">Editar</th>
											</tr>
										</thead>
										<tbody>											
										</tbody>
										</table>
									</div>
								</div>
							</div>
						</div>
					</div>
				</form>
			</div><!-- .widget-body -->
		</div><!-- .widget -->
	</div><!-- END column -->
</div><!-- .row -->