function function_add() {
    var number1 = parseInt(document.getElementById("number1").value);
    var number2 = parseInt(document.getElementById("number2").value);
    result = number1 + number2;
    document.getElementById("result").innerHTML = "Result Addtion: " + result;
}
function function_sub() {
    var number1 = parseInt(document.getElementById("number1").value);
    var number2 = parseInt(document.getElementById("number2").value);
    result = number1 - number2;
    document.getElementById("result").innerHTML = "Result Subtraction: " + result;
}
function function_mul() {
    var number1 = parseInt(document.getElementById("number1").value);
    var number2 = parseInt(document.getElementById("number2").value);
    result = number1 * number2;
    document.getElementById("result").innerHTML = "Result Multiplication: " + result;
}
function function_div() {
    var number1 = parseInt(document.getElementById("number1").value);
    var number2 = parseInt(document.getElementById("number2").value);
    result = number1 / number2;
    document.getElementById("result").innerHTML = "Result Division: " + result;
}