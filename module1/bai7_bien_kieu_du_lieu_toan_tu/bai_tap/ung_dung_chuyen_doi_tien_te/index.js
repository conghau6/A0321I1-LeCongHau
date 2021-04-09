function myFunction() {
    var amount = document.getElementById('amount').value;
    var country = document.getElementById("country").value;
    var currency = document.getElementById("currency").value;
    var result = amount;
    if(country=="VietNam" && currency=="USD"){
        result = amount / 23092;
        currency = "USD";
    }
    if(country=="USA" && currency=="VND"){
        result = amount * 23092;
        currency = "VND";
    }
    document.getElementById("text").innerHTML = "Result: " + result.toFixed(2) + " " + currency;
}