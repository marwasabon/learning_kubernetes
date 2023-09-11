(function ($) {

    "use strict";

    // handle toasts
    var toastElList = [].slice.call(document.querySelectorAll('.toast'));
    var toastList = toastElList.map(function (toastEl) {
        return new bootstrap.Toast(toastEl, { autohide: true });
    });

    setTimeout(function () {
        toastList.forEach(function (t) {
            t.show();
        })
    }, 200)



    //  default datatable options

    $.extend(true, $.fn.dataTable.defaults, {
        lengthMenu: [5, 10, 20, 50, 100],
        searching: true,
        ordering: false,
        autoWidth: true,
        smartWidth: true,
        processing: true, // for show progress bar
        serverSide: true, // for process server side
        filter: true,
        // fixedColumns:   {
        //     right: 1
        // },
        dom: '<"d-flex justify-content-between"lPf>r<"table-responsive"t> <"d-flex justify-content-between text-sm" ip>',
    });

    // handle table back button
    $('.btn-back').on('click', function () {
        window.history.back();
    })


})(jQuery);


// TODO: refactor to utils.js

function renderDateCell(data, type, row) {
    return data ? moment(data).format('YYYY-MM-DD') : '';
}



