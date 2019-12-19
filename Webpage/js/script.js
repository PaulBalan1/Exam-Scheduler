$("#schedule").on("click", function(){
    $("#studentList").slideToggle(10);
});
var document, XMLHttpRequest;

function readXML() {
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            showData(this);
        }
    };
    xhttp.open("GET", "xml/examList.xml", true);
    xhttp.send();
}

function showData(xml) {
    var i;
    var xmlDoc = xml.responseXML;
    var table = "<tr><th>Name</th><th>Date</th><th>Course</th><th>Type</th><th>Classroom</th><th>Group</th><th>Examiner</th><th>Co-Examiner</th></tr>";
    var x = xmlDoc.getElementsByTagName("exams");
    for (i = 0; i<x.length; i++){
        table += "<tr><td>" +
        x[i].getElementsByTagName("name")[0].childNodes[0].nodeValue + 
        "</td><td>" + 
        x[i].getElementsByTagName("day")[0].childNodes[0].nodeValue +
            "/" +
        x[i].getElementsByTagName("month")[0].childNodes[0].nodeValue +
            "/" +
        x[i].getElementsByTagName("year")[0].childNodes[0].nodeValue +
        "</td><td>" +
        x[i].getElementsByTagName("name")[2].childNodes[0].nodeValue +
        "</td><td>" +
        x[i].getElementsByTagName("type")[0].childNodes[0].nodeValue + 
        "</td><td>" +
        x[i].getElementsByTagName("name")[4].childNodes[0].nodeValue+
        "</td><td><button>" +
        x[i].getElementsByTagName("groupName")[0].childNodes[0].nodeValue + 
        "</td></button><td>" +
        x[i].getElementsByTagName("name")[1].childNodes[0].nodeValue +
        "</td><td>" +
        x[i].getElementsByTagName("coExaminer")[0].childNodes[0].nodeValue +
        "</td></tr>";
    }
    document.getElementById("schedule").innerHTML = table;
}

function readXML1() {
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            showData1(this);
        }
    };
    xhttp.open("GET", "xml/testTakerList.xml", true);
    xhttp.send();
}

function showData1(xml) {
    var i;
    var xmlDoc = xml.responseXML;
    var table = "<tr><th>Name</th><th>StudyNumber</th><th>Group Name</th></tr>";
    var x = xmlDoc.getElementsByTagName("testTakers");
    for (i = 0; i < x.length; i++){
        table += "<tr><td>" +
        x[i].getElementsByTagName("name")[0].childNodes[0].nodeValue +
        "</td><td>" +
        x[i].getElementsByTagName("studyNumber")[0].childNodes[0].nodeValue +
        "</td><td>" +
        x[i].getElementsByTagName("groupName")[0].childNodes[0].nodeValue+
        "</td></tr>";
    }
    document.getElementById("studentList").innerHTML = table;
}

readXML(); 
readXML1();



