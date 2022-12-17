function daletStudent() {
    var checkedCheckboxs = document.querySelectorAll('input[name=idStudent]:checked')
    if (checkedCheckboxs.length == 0) {
        alert("Выберете Хотябы одного студента!!!")
        return;
    }
    // "1 2 5 7" - string
    debugger;
    var ids = ""
    for (var i = 0; i < checkedCheckboxs.length; i++) {
        ids = ids + checkedCheckboxs[i].value + ",";
    }
    ids = ids.substring(0, ids.length - 1);


    document.getElementById("deleteStudentHidden").value = ids;
    document.getElementById('deleteStudentForm').submit();
}
function deleteDiscipline() {
    var checkedCheckboxs = document.querySelectorAll('input[name=idsDiscipline]:checked')
    if (checkedCheckboxs.length == 0) {
        alert("Выберете не менее одной дисциплины!!!")
        return;
    }
    // "1 2 5 7" - string
    debugger;
    var ids = ""
    for (var i = 0; i < checkedCheckboxs.length; i++) {
        ids = ids + checkedCheckboxs[i].value + ",";
    }
    ids = ids.substring(0, ids.length - 1);


    document.getElementById("deleteDisciplineHidden").value = ids;
    document.getElementById('deleteDisciplineForm').submit();
}