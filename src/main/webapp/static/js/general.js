function format(state) {
    if (!state.id) return state.text; // optgroup
    return state.text;
}

function limpiar_autocomplite(name){
	$("select[name='"+name+"']").empty();
	$("select[name='"+name+"']").append("<option value=''></option>");
	$("#"+name).select2({
        placeholder: '<i class="fa fa-map-marker"></i>&nbsp;Seleccione...',
        allowClear: true,
        formatResult: format,
        formatSelection: format,
        escapeMarkup: function(m) {
            return m;
        }
    });
}

function permanecerMenu(){
	var sessionGu = true;
	$('.page-sidebar-menu li a').each(
			function(index) {
				if (this.href.trim() == window.location) {
					localStorage.setItem("hrefId", this.id);
					$(this).parent().addClass("start active");
					$(this).parent().parent().addClass("in");
					$(this).parent().parent().parent().toggleClass("active open");
					sessionGu = false;
				}
			});
	if (sessionGu) {
		var idHref = localStorage.getItem("hrefId");
		if (idHref != null) {
			$("#" + idHref).parent().addClass("start active");
			$("#" + idHref).parent().parent().addClass("in");
			$("#" + idHref).parent().parent().parent().toggleClass("active open");
		}
	}
}

//inicializar una tabla pasandole su ID, el ID del boton exportar a XML.
// parametros obligatorio: tableID, buttonID, showPagin, showSearch

function initDGAjax( tableID, configColumnDefs, columns,  urlAjax)
{
	initDGAjax( tableID, configColumnDefs, columns,  urlAjax , true , true)
}

function initDGAjax( tableID, configColumnDefs, columns,  urlAjax, swPaging, wsSearching) {

	var grillaObject = $( tableID ).DataTable({
		lengthMenu: [[15, 25, 50, -1], [15, 25, 50, "Todos"]],
		paging: swPaging == null ? true : swPaging,
		searching: wsSearching,
		processing: true,
		language : {
			info : "Registros: _START_ - _END_ de _TOTAL_ registros",
			emptyTable : 'No hay registros disponibles',
			lengthMenu : "Registros por p&aacute;gina  _MENU_",
			infoEmpty : "Registros: 0 - 0 de 0 registros",
			sInfoFiltered : "(filtrado de un total de _MAX_ registros)",
			sZeroRecords : "No se encontraron resultados",
			paginate : {
				first : "Primero",
				last : "&Uacute;ltimo",
				next : "Siguiente",
				previous : "Anterior"
			},
			search : "Buscar: "
		},
		ajax: {
            url: urlAjax,
             		
        },						
        columnDefs: configColumnDefs,
        aoColumns: columns
	
	});	
	
	return grillaObject;
}

function estadoInputError( divID, data, estadoRestore ) {		
	estadoInputErrorDiv( divID, data, estadoRestore );
}

function estadoInputErrorDiv( divID, data, estadoRestore ) {
	
	var msgError     = data.msg;
	var campoError   = data.dataJson.campoError;		
	
	// [CMIC] 19/03/2015
	var titulo = data.dataJson.titulo;
	var tipo = data.dataJson.tipo;
	
	// sino viene con campo poco se puede hacer
	if ( campoError == null ) return;
			
	// si el campo es un error general, mostrarlo como popup
	if ( campoError == 'general' ) {
		var titulo = titulo == null ? 'Mensaje' : titulo;
		showMensaje( titulo , msgError );
		return;
	}			
	
	var selInput = $( divID + ' input[name=' + campoError + ']' );
	var selSelec = $( divID + ' select[name=' + campoError + ']' );
	var selTextA = $( divID + ' textarea[name=' + campoError + ']' );
	
	if ( selInput.length ) {			
		if ( !$( divID + ' input[name=' + campoError + ']' ).hasClass('date-picker') ){
			selInput.focus();	
		}			
		
		if ( $( divID + ' input[name=' + campoError + ']' ).hasClass('date-picker') || $( divID + ' input[name=' + campoError + ']' ).hasClass('clas_email') ){
			selInput.parent().parent().find('span:last').html(msgError);
			selInput.parent().parent().find('p:last').html(msgError);
		}else{
			selInput.parent().find('span:last').html(msgError);
			
		}
																					
		selInput.closest('.form-group').addClass('has-error1');

		if ( !$( divID + ' input[name=' + campoError + ']' ).hasClass('date-picker') ){
			selInput.select();
			selInput.focus();			
		}			
	}
	
	if ( selSelec.length ) {
		
		selSelec.focus();
		selSelec.next().html( msgError );
		selSelec.closest('.form-group').addClass('has-error1');
		selSelec.focus();
	}
	
	if ( selTextA.length ) {
		
		selTextA.focus();
		selTextA.next().html( msgError );
		selTextA.closest('.form-group').addClass('has-error1');
		selTextA.focus();
	}

	// FIXME: con el estadoRestore reestablecer la estructura de datos
}

function estadoInputInicial(divID) {
	$(".help-block1").html("");
	$(divID + ' :input').closest('.form-group').removeClass('has-error1');
	$(divID + ' select').closest('.form-group').removeClass('has-error1');
	$(divID + ' textarea').closest('.form-group').removeClass('has-error1');
	return null;
}

function huboErrorJson(data) {
	// si no viene data
	if (data == null) {
		bootbox.alert('Respuesta JSON no seteada');
		return true;
	}
	// si no viene estado
	if (data.estado == null) {
		bootbox.alert('Atributo estado de respuesta JSON no seteado');
		return true;
	}
	// si viene error de aplicacion
	if (data.estado != 'ok') {
		return true;
	}
	return false;
}

function handleError(data) {
	var msg = data;
	if (data == null) {
		msg = 'No se obtuvo respuesta del servidor.';
	}
	alert(msg + ' ');
}

function huboErrorValidacionJson(data) {
	return data != null && data.estado == 'errorValidacion';
}

function handleErrorJson( data  ) {
	
	// si no viene data
	if ( data == null ) {
		bootbox.alert('Respuesta JSON no seteada');
		return true;
	}
	
	// si no viene estado
	if ( data.estado == null ) {
		bootbox.alert('Atributo estado de respuesta JSON no seteado');
		return true;
	}
	
	// si viene error de aplicacion
    if ( data.estado != 'ok' ) {
    	bootbox.alert(' ' + data.msg);
        return true;
    }

	return false;
}

function validateForm(form, campos, mensajes, funcionValido){
	$("#"+form).validate({
		errorElement: 'span', //default input error message container
        errorClass: 'help-block', // default input error message class
        focusInvalid: false, // do not focus the last invalid input
        ignore: "",
		rules: campos,
		messages: mensajes,
        highlight: function(element, errorClass, validClass ) { // hightlight error inputs
        	$('.help-block1').html('');
        	$('.form-group').removeClass('has-error1');
            $(element).closest('.form-group').addClass('has-error'); // set error class to the control group
        },
        success: function(label) {
            label.closest('.form-group').removeClass('has-error');
        },
        errorPlacement: function(error, element) {
        	if ( element[0].type === "checkbox" ) {
        		error.insertAfter($(element[0]).closest('.form-control'));
			} else {
				error.insertAfter(element);
			}
        },
        submitHandler: function(form) {
        	funcionValido();
        }
	});
}

function eventDownload() {
	Metronic.blockUI({
        boxed: true
    });
}

function endDownload(){
	Metronic.unblockUI();
}

function validation(data, estadoInicial, divInicial){
	if ( huboErrorJson( data ) ) {
		var validacion=false;
		if(data.dataJson!=null)
			for (var i=0; i<data.dataJson.length; i++) {
				if ( huboErrorValidacionJson(data.dataJson[i]) ) {
	                estadoInputError( divInicial, data.dataJson[i], estadoInicial );
	                validacion=true;
	            }
			}
		if(validacion){
			endDownload();
			return false;
		}
        handleErrorJson( data );
        endDownload();
        return false;
    }
	return true
}

function extraValidator(){
	jQuery.validator.addMethod("isTime", function(value, element, param) {
		if(param){
			var valor = $.trim(value);			
			var time = valor.split(":");
			
			var hours = parseInt( time[0] );
			var minute = parseInt( time[1] );
			
			return hours <= 23 && minute <= 59;
		}else{
			return true;
		}
	}, "Please enter a valid time.");
}

function obtenerBloqueados(form) {
	var array = new Array();
	$.each($('#' + form + ' select'), function() {
		if (this.disabled) {
			array.push(this.id);
		}
	});

	$.each($('#' + form + ' input'), function() {
		if (this.disabled) {
			array.push(this.id);
		}
	});

	$.each($('#' + form + ' textarea'), function() {
		if (this.disabled) {
			array.push(this.id);
		}
	});
	return array;
}

function inhabilitar(arreglo) {
	$.each(arreglo, function() {
		$('#' + this).prop('disabled', $('#' + this).attr('disabled') ? false : true);
	});
}

function showConfirmation( titulo, mensaje, functionSI, funcionNO) {
	bootbox.dialog({
        message: mensaje,
        title: titulo,
        buttons: {
          success: {
            label: "Si",
            className: "red",
            callback: functionSI
          },
          danger: {
            label: "No",
            className: "white",
            callback: funcionNO
          }
        }
    });
}

function initFecha() {
	// CONFIGURAMOS EL JQUERY UI DATAPICKER ESPAÑOL																						
	$(".div-date-picker").each( function( key, value ) {
										
		var elements = $(value).children();
							
		var label = elements[0]; // LABEL
		var input = elements[1]; // INPUT
		var span  = elements[2]; // SPAN
		
		
		
		var div = $('<div/>', {
		    'class' : 'input-group',
		});
					
		$(input).toggleClass('date-picker');
		$(input).attr('id', input.name);
		$(input).attr('data-date-format', 'dd/mm/yyyy');
		
		var labelDate = $("<label/>", {
			'for': input.id,
		    'class' : 'input-group-addon btn',
		}).append( $('<span/>' , {
			'class' : 'glyphicon glyphicon-calendar'
		}));
		
		div.append( input );
		div.append( labelDate );
		
		var textLabel = $(label).html();
								
		$(value).html('');
		$(value).append('<label class="control-label">' + textLabel + '</label>');
		$(value).append(div)
		$(value).append(span)
		
	});
		
	$(".date-picker").inputmask("d/m/y", {
        "placeholder": "dd/mm/yyyy"
    });
	$(".date-picker").datepicker();
}