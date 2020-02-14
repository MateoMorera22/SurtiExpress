$(document).ready(function() {
  //variables
  var pass1 = $('[name=pass1]');
  var pass2 = $('[name=pass2]');
  var confirmacion = "Las contraseñas si coinciden";
  var longitud = "La contraseña debe estar formada entre 5-12 carácteres";
  var negacion = "No coinciden las contraseñas";
  var vacio = "La contraseña no puede estar vacía";
  //oculto por defecto el elemento span
  var span = $('<span></span>').insertAfter(pass2);
  span.hide();
  //función que comprueba las dos contraseñas
  function coincidePassword() {
      var valor1 = pass1.val();
      var valor2 = pass2.val();
      //muestro el span
      span.show().removeClass();
      //condiciones dentro de la función
      if (valor1 != valor2) {
          span.text(negacion).addClass('negacion');
      }
      if (valor1.length == 0 || valor1 == "") {
          span.text(vacio).addClass('negacion');
      }
      if (valor1.length < 6 || valor1.length > 10) {
          span.text(longitud).addClass('negacion');
      }
      if (valor1.length != 0 && valor1 == valor2) {
          span.text(confirmacion).removeClass("negacion").addClass('confirmacion');
      }
  }
  //ejecuto la función al soltar la tecla
  pass2.keyup(function() {
      coincidePassword();
  });
});


$(document).ready(function(){
    $('select').formSelect();
  });




function entrada() {
  var formulario = document.getElementById("formulario"),
      comodin = true;

  formulario.addEventListener("submit", function(event) {
      event.preventDefault();

      var elementos = this.elements;
      for (var i in elementos) {
        if (!elementos[i].value.length) {
          window.location.href = '/SurtiExpressV.2_3/faces/Index.xhtml' // aqui se pone la ruta del XHTML de inventario  :)
          comodin = false;
          break;
          }
      }

      if (comodin) {
          this.submit();
      }
  }, false);
}


