$(document).ready(function () {
    $('.sidenav').sidenav();
});

document.addEventListener('DOMContentLoaded', function () {
    var elems = document.querySelectorAll('.fixed-action-btn');
    var instances = M.FloatingActionButton.init(elems, {
        direction: 'left'
    });
});

$(document).ready(function () {
    $('#pedidos').DataTable();
});


$(document).ready(function () {
    $('.tooltipped').tooltip();
});


$(document).ready(function () {
    $('.modal').modal();
});

$('.dropdown-trigger').dropdown();

$(document).ready(function () {
    $('select').formSelect();
});

$(document).ready(function () {
    $('.tooltipped').tooltip();
});


$(document).ready(function () {
    $('.modal').modal();
});

$('.dropdown-trigger').dropdown();

$(document).ready(function () {
    $('select').formSelect();
});

function entrada() {
    var formulario = document.getElementById("formulario"),
            comodin = true;

    formulario.addEventListener("submit", function (event) {
        event.preventDefault();

        var elementos = this.elements;
        for (var i in elementos) {
            if (!elementos[i].value.length) {
                Swal.fire(
                        'Producto editado exitosamente',
                        '',
                        'success'
                        )

            }
        }

        if (comodin) {
            this.submit();
        }
    }, false);
}



