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
          window.location.href = 'https://materializecss.com/buttons.html' // aqui se pone la ruta del XHTML de inventario  :)
          comodin = false;
          break;
          }
      }

      if (comodin) {
          this.submit();
      }
  }, false);
}

 $('.datepicker').datepicker({ 
            firstDay: true, 
            format: 'yyyy/mm/dd',
            i18n: {
                months: ["Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"],
                monthsShort: ["Ene", "Feb", "Mar", "Abr", "May", "Jun", "Jul", "Ago", "Set", "Oct", "Nov", "Dic"],
                weekdays: ["Domingo","Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado"],
                weekdaysShort: ["Dom","Lun", "Mar", "Mie", "Jue", "Vie", "Sab"],
                weekdaysAbbrev: ["D","L", "M", "M", "J", "V", "S"]
            }
        });


