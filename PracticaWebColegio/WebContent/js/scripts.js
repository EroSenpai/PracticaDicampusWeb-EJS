(function () {
    'use strict';
    document.addEventListener('DOMContentLoaded', function () {
        /** getElementById **/
        /*
        var logo = document.getElementById('logo'),
            navegacion = document.getElementById('navegacion');
        navegacion.style.display = "none";
        */
        
        
        /** getElementsByClassName **/
        /*
        var navegacion = document.getElementsByClassName('navegacion'),
            contenido = document.getElementsByClassName('contenido'); 
        window.console.log(navegacion[1]);
        contenido[0].style.display = 'none';
        */
        
        
        /** getElementsByTagName **/
        /*
        var enlaces = document.getElementsByTagName('a'),
            enlacesSidebar = document.getElementById('sidebar').getElementsByTagName('a'),
            i;
        window.console.log(enlaces.length);
        for (i = 0; i < enlaces.length; i += 1) {
            enlaces[i].setAttribute('target', '_blank');
        }
        window.console.log(enlacesSidebar);
        for (i = 0; i < enlacesSidebar.length; i += i) {
            enlacesSidebar[i].setAttribute('href', 'http://www.google.com');
        }
        */
        
        
        /** querySelector **/
        /*
        var logo = document.querySelector('.logo'),
            encabezado = document.querySelectorAll('h2, footer p'),
            enlaces = document.querySelectorAll('a');
            
        window.console.log(logo);
        window.console.log(encabezado);
        window.console.log(enlaces);
        */
        
        
        /** querySelectorAll **/
        /*
        var enlace = document.querySelectorAll('a'),
            i;
        for (i = 0; i < enlace.length; i += 1) {
            window.console.log(enlace[i].innerText);
        }
        */
        
        
        /** Nodos **/
        /*
        var enlaces = document.querySelectorAll('#menu ul li a')[0];
        window.console.log(enlaces.nodeType);
        window.console.log(enlaces.nodeName);
        window.console.log(enlaces.attributes);
        window.console.log(enlaces.firstChild);
        window.console.log(enlaces.firstChild.nodeValue);
        enlaces.firstChild.nodeValue = "Home";
        */
        
        
        /** Creando Elementos **/
        /*
        var sidebar = document.querySelector('#sidebar'),
            nuevoElemento = document.createElement("H1"),
            nuevoTexto = document.createTextNode("Hola Mundo"),
            nuevoEnlace = document.createElement('A'),
            enlacesSidebar = document.querySelectorAll('#sidebar ul'),
            textoEnlace = document.createTextNode('Entrada 6'),
            nuevaLista = document.createElement('LI');
        
        nuevoElemento.appendChild(nuevoTexto);
        sidebar.appendChild(nuevoElemento);
        
        nuevoEnlace.setAttribute('href', 'http://www.google.com');
        nuevoEnlace.appendChild(textoEnlace);
        nuevaLista.appendChild(nuevoEnlace);
        enlacesSidebar[0].appendChild(nuevaLista);
        */
        
        
        /** Clonar Nodo **/
        /*
        var contenido = document.querySelectorAll('main'),
            nuevoContenido = contenido[0].cloneNode(true),
            sidebar = document.querySelector("aside");
        sidebar.insertBefore(nuevoContenido, sidebar.childNodes[5]);
        */
        
        
        /** Controlando insercion de InsertBefore **/
        /*
        var sidebar = document.querySelector('aside'),
            masVisitados = document.createElement('H2'),
            textoVisitados = document.createTextNode('Post Mas Visitados'),
            contenido = document.querySelectorAll('main h2'),
            nuevoElemento = document.createElement('LI'),
            i,
            nuevoTexto;
        masVisitados.appendChild(textoVisitados);
        sidebar.insertBefore(masVisitados, sidebar.childNodes[0]);
        for (i = 0; i < contenido.length; i += 1) {
            nuevoTexto = document.createTextNode(contenido[i].firstChild.nodeValue);
            nuevoElemento.appendChild(nuevoTexto);
            sidebar.insertBefore(nuevoElemento, sidebar.childNodes[1]);
        }
        */
        
        
        /** Eliminando Nodos **/
        /*
        var primerPost = document.querySelector('main article'),
            enlaces = document.querySelectorAll('#navegacion nav ul li a ')[10];
        window.console.log(primerPost);
        primerPost.parentNode.removeChild(primerPost);
        window.console.log(enlaces);
        enlaces.parentNode.removeChild(enlaces);
        */
        
        
        /** Reemplaznado Nodos **/
        /*
        var nuevoTitulo = document.createElement('H2'),
            nuevoTexto = document.createTextNode('Hola Mundo'),
            viejoNodo = document.querySelector('Main h2');
        nuevoTitulo.appendChild(nuevoTexto);
        viejoNodo.parentNode.replaceChild(nuevoTitulo, viejoNodo);
        */
    });
}());