/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/*jslint browser:true, devel:true, white:true, vars:true */
/*global $:false, intel:false */
// variables para el jslint

/**
 * Creamos el objeto alumno y todos sus métodos.
 */
$.alupr = {};
$.pralu = {};
// Configuración del HOST y URL del servicio
$.aluasi.HOST = 'http://localhost:8080';
// $.alumno.URL = '/GA-JPA/webresources/com.iesvdc.acceso.entidades.alumno';
$.aluasi.URL = '/GestionAcademica/rest/alupr';
$.asialu.URL = '/GestionAcademica/rest/pralu';

$.asipr.panel_list = '#panel_li_asi_pr';
$.prasi.panel_list_2= '#panel_li_pr_asi';
$.aluasi.panel_erro = '#panel_error';
$.asialu.panel_erro = '#panel_error';

$.prasi.ProfesorAsignaturaReadREST = function () {
    // con esta función jQuery hacemos la petición GET que hace el findAll()
    $.controller.doGet(
            this.HOST + this.URL,
            function (json) {
                $($.prasi.panel_list).empty();
                $($.prasi.panel_list).append('<h3>Listado de Profesores</h3>');
                var table = $('<table />').addClass('table table-stripped');

                table.append($('<thead />').append($('<tr />').append('<th>id</th>', '<th>nombre</th>', '<th>id</th>', '<th>curso</th>', '<th>ciclo</th>')));
                var tbody = $('<tbody />');
                for (var clave in json) {
                    tbody.append($('<tr />').append('<td>' + json[clave].nombre + '</td>',
                            '<td>' + json[clave].id + '</td>', '<td>' + json[clave].curso + '</td>', '<td>' + json[clave].ciclo + '</td>'));
                }
                table.append(tbody);

                $($.prasi.panel_list).append($('<div />').append(table));
                $('tr:odd').css('background', '#CCCCCC');
            });
};

$.asipr.AsignaturaProfesorReadREST = function () {
    // con esta función jQuery hacemos la petición GET que hace el findAll()
    $.controller.doGet(
            this.HOST + this.URL,
            function (json) {
                $($.asipr.panel_list_2).empty();
                $($.asipr.panel_list_2).append('<h3>Listado de Asignaturas</h3>');
                var table = $('<table />').addClass('table table-stripped');

                table.append($('<thead />').append($('<tr />').append('<th>id</th>', '<th>nombre</th>', '<th>apellido</th>')));
                var tbody = $('<tbody />');
                for (var clave in json) {
                    tbody.append($('<tr />').append('<td>' + json[clave].id + '</td>',
                            '<td>' + json[clave].nombre + '</td>', '<td>' + json[clave].apellido + '</td>'));
                }
                table.append(tbody);

                $($.asipr.panel_list_2).append($('<div />').append(table));
                $('tr:odd').css('background', '#CCCCCC');
            });
};





/**
 Función para la gestión de errores y mensajes al usuario
 */
$.aluasi.error = function (title, msg) {
    $($.aluasi.panel_erro).empty();
    $($.aluasi.panel_erro).append('<h3>' + title + '</h3>');
    $($.aluasi.panel_erro).append('<p>' + msg + '</p>');

    // cargamos el panel con id r_profesor.
    $.controller.activate($.aluasi.panel_erro);
};