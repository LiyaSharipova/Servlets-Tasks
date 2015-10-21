/**
 * Created by Baths on 19.10.2015.
 */
function formCheck()
{
    var email = document.regForm.email.value;
    var reg = /^((\w+(\-|\.)?)+)@((\w{2,}\.)+\w{2,6})$/;
    if (!reg.test(email)) {
        alert("Invalid Email");
        return false;
    }

    var pass = document.regForm.password.value;
    if (pass.length < 6) {
        alert("Password is too short");
        return false;
    }


    document.getElementById('symbols').innerHTML = s.length;
    var radio = document.getElementsByName("gender");
    if (!radio[0].checked && !radio[1].checked) {
        alert("Choose gender");
        return false;
    }
    return true;
}
function count (str) {
    document.getElementById('symbols').innerHTML=str.length;
}