/**
 * Created by Andrew on 12/22/14.
 */
var success = getQueryVariable("msgSent");

if (success === 'suc') {
    $('#contactSuccess').modal('show');
}
else if (success === 'err') {
    $('#contactError').modal('show');
}

function getQueryVariable(variable) {
    var query = window.location.search.substring(1);
    var vars = query.split("&");
    for (var i = 0; i < vars.length; i++) {
        var pair = vars[i].split("=");
        if (pair[0] == variable) {
            return pair[1];
        }
    }
}