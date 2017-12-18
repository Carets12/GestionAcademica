/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/*jslint browser:true, devel:true, white:true, vars:true */
/*global $:false, intel:false */
// variables para el jslint

/**
 * Creamos el objeto profesor y todos sus métodos.
 */
$.prasi = {};
$.asipr = {};
// Configuración del HOST y URL del servicio
$.prasi.HOST = 'http://localhost:8080';
$.asipr.HOST = 'http://localhost:8080';
// $profesor.URL = '/GA-JPA/webresources/com.iesvdc.acceso.entidades.profesor';
$.prasi.URL = '/GestionAcademica/rest/prasi';
$.asipr.URL = '/GestionAcademica/rest/asipr';

$.asipr.panel_list = '#panel_li_asi_pr';
$.prasi.panel_list_2= '#panel_li_pr_asi';
$.prasi.panel_erro = '#panel_error';
$.asipr.panel_erro = '#panel_error';

$.prasi.ProfesorAsignaturaReadREST = function () {
    // con esta función jQuery hacemos la petición GET que hace el findAll()
    $.controller.doGet(
            this.HOST + this.URL,
            function (json) {
                $($.prasi.panel_list_2).empty();
                $($.prasi.panel_list_2).append('<h3>Listado de Profesores</h3>');
                var table = $('<table />').addClass('table table-stripped');

                table.append($('<thead />').append($('<tr />').append('<th>id</th>', '<th>nombre</th>', '<th>apellido</th>')));
                var tbody = $('<tbody />');
                for (var clave in json) {
                    tbody.append($('<tr />').append('<td>' + json[clave].id + '</td>',
                            '<td>' + json[clave].nombre + '</td>', '<td>' + json[clave].apellido + '</td>'));
                }
                table.append(tbody);

                $($.prasi.panel_list_2).append($('<div />').append(table));
                $('tr:odd').css('background', '#CCCCCC');
            });
};

$.asipr.AsignaturaProfesorReadREST = function () {
    // con esta función jQuery hacemos la petición GET que hace el findAll()
    $.controller.doGet(
            this.HOST + this.URL,
            function (json) {
                $($.asipr.panel_list).empty();
                $($.asipr.panel_list).append('<h3>Listado de Asignaturas</h3>');
                var table = $('<table />').addClass('table table-stripped');

                table.append($('<thead />').append($('<tr />').append('<th>nombre</th>', '<th>id</th>', '<th>curso</th>', '<th>ciclo</th>')));
                var tbody = $('<tbody />');
                for (var clave in json) {
                    tbody.append($('<tr />').append('<td>' + json[clave].nombre + '</td>',
                            '<td>' + json[clave].id + '</td>', '<td>' + json[clave].curso + '</td>', '<td>' + json[clave].ciclo + '</td>'));
                }
                table.append(tbody);

                $($.asipr.panel_list).append($('<div />').append(table));
                $('tr:odd').css('background', '#CCCCCC');
            });
};

/**
 Función para la gestión de errores y mensajes al usuario
 */
$.asipr.error = function (title, msg) {
    $($.asipr.panel_erro).empty();
    $($.asipr.panel_erro).append('<h3>' + title + '</h3>');
    $($.asipr.panel_erro).append('<p>' + msg + '</p>');

    // cargamos el panel con id r_profesor.
    $.controller.activate($.asipr.panel_erro);
};

$.prasi.error = function (title, msg) {
    $($.prasi.panel_erro).empty();
    $($.prasi.panel_erro).append('<h3>' + title + '</h3>');
    $($.prasi.panel_erro).append('<p>' + msg + '</p>');

    // cargamos el panel con id r_profesor.
    $.controller.activate($.prasi.panel_erro);
};