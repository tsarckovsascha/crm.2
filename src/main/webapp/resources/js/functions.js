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

    debugger;
    document.getElementById("deleteStudentHidden").value = ids;
    document.getElementById('deleteStudentForm').submit();
    debugger;
}
function deleteDiscipline() {
    var checkedCheckboxs = document.querySelectorAll('input[name=idDiscipline]:checked')
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
function studentProgress() {
    var checkedCheckboxs = document.querySelectorAll('input[name=idStudent]:checked')
    if (checkedCheckboxs.length != 1 ) {
        alert("Выберете одного студента")
        return;
    }
    // "1 2 5 7" - string
    debugger;
    var id = checkedCheckboxs[0].value

    document.getElementById("studentProgressHidden").value = id;
    document.getElementById('studentProgressForm').submit();
}
function deletNews() {
    var checkedCheckboxs = document.querySelectorAll('input[name=idNews]:checked')
    if (checkedCheckboxs.length == 0) {
        alert("Выберете Хотябы одно объявление!!!")
        return;
    }
    // "1 2 5 7" - string
    debugger;
    var idn = ""
    for (var i = 0; i < checkedCheckboxs.length; i++) {
        idn = idn + checkedCheckboxs[i].value + ",";
    }
    idn = idn.substring(0, idn.length - 1);


    debugger;
    document.getElementById("deletNewsHidden").value = idn;
    document.getElementById('deletNewsForm').submit();
    debugger;
}
function term_disciplin() {
    var checkedCheckboxs = document.querySelectorAll('input[name=id]:checked')
    // "1 2 5 7" - string
    debugger;
    var id = checkedCheckboxs[0].value

    document.getElementById("term_disciplinHidden").value = id;
    document.getElementById('term_disciplinForm').submit();
}