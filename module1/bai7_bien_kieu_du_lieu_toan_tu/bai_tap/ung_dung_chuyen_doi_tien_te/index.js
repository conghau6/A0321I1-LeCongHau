function myFunction() {
    var amount = document.getElementById('amount').value;
    var from_currency = document.getElementById("from_currency").value;
    var to_currency = document.getElementById("to_currency").value;
    var result = amount;
    if(from_currency=="VND" && to_currency=="USD"){
        result = amount / 23092;
    }
    if(from_currency=="USD" && to_currency=="VND"){
        result = amount * 23092;
    }
    document.getElementById("text").innerHTML = "Result: " + result.toFixed(2) + " " + to_currency;
}