//window.addEventListener('DOMContentLoaded', event => {
//    // Simple-DataTables
//    // https://github.com/fiduswriter/Simple-DataTables/wiki
//
//    const datatablesSimple = document.getElementById('datatablesSimple');
//    if (datatablesSimple) {
//        new simpleDatatables.DataTable(datatablesSimple);
//    }
//});


var employeeSet = $("#eiEmployee").val();
employeeSet = employeeSet.split(";")

var dataSet = []

for (var i = 0; i < employeeSet.length - 1; i++) {
    var localEmployee = employeeSet[i].slice(1, -1)
    dataSet.push(localEmployee.split(","))
}

console.log(dataSet)

$("index.html").ready(function() {
    $('#datatablesSimple').DataTable( {
        data: dataSet,
        ordering: true,
        columns: [
            { title: "Name" },
            { title: "Age" },
            { title: "Office Location" },
            { title: "Position" },
            { title: "Salary" },
            { title: "Start Date" }
        ]
    } );
} );
