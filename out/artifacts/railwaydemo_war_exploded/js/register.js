function check() {
    var a1 = document.getElementById("a1").value;
    var p1 = document.getElementById("p1").value;
    var p2 = document.getElementById("p2").value;
    var n1 = document.getElementById("n1").value;
    if (!isNum(a1)) {
        alert("Account must be 10 digits");
        return false;
    }
    if (!isNL(p1)) {
        alert("Password must be 6-16 digits or letters");
        return false;
    }
    if (!isNL(p2)) {
        alert("Password must be 6-16 digits or letters");
        return false;
    }
    if (!ischina(n1) && !isEn(n1)) {
        alert("Wrong naming format");
        return false;
    }
    if(p1!=p2){
        alert("The two passwords are inconsistent");
        return false;
    }

}

function isNum(str) {
    var x = /^\d{10}$/;
    return x.test(str);
}

function isNL(str) {
    var x = /^[0-9a-zA-Z]{6,16}$/;
    return x.test(str)
}

function ischina(str) {
    var x = /^[\u4E00-\u9FA5]{2,4}$/;
    return x.test(str);
}

function isEn(str) {
    var x = /^[a-zA-Z]{3,10}$/;
    return x.test(str);
}