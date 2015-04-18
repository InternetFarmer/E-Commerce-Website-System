$(function() {
    showBag();
});

function showBag() {
    var bag = JSON.parse(sessionStorage.getItem("bag"));
    var tbady = document.getElementById("shoppingbagarea");
    if (bag !== null) {
        for (var i = 0; i < bag.length; i++) {
            var p = bag[i];
            tbady.insertAdjacentHTML("beforeend", "<tr id='product_" + p.product_id + "'><td>" + p.product_id + "</td><td>" + p.product_name + "</td><td>" + p.price + "</td><td>" + p.category.category_name + "</td><td>" +
                "<input type='button' value='-' onclick='modifyAmount(\"del\", " + p.product_id + ")'/>" +
                "<input id='amount_box_" + p.product_id + "' type='text' value='1' size='1px'/>" +
                "<input type='button' value='+' onclick='modifyAmount(\"add\", " + p.product_id + ")'/>" +
                "</td><td><button type='button' class='btn btn-primary btn-sm' onclick='removeProduct(" + p.product_id + ")'>" +
                "<span class='glyphicon glyphicon-remove'></span></button></td></tr>");
        }
    }
    calculateTotalMoney();
}

function removeProduct(id) {
    var bag = JSON.parse(sessionStorage.getItem("bag"));
    for (var i = 0; i < bag.length; i++) {
        var p = bag[i];
        if (p.product_id == id) {
            bag.splice(i, 1);
            var pr = $("#product_" + id);
            pr.parentNode.removeChild(pr);
        }
    }
    sessionStorage.setItem("bag", JSON.stringify(bag));
    calculateTotalMoney();
}

function calculateTotalMoney() {
    var bag = JSON.parse(sessionStorage.getItem("bag"));
    var total = 0;
    //alert(1);
    for (var i = 0; i < bag.length; i++) {
        var p = bag[i];
        var amount = $("#amount_box_" + bag[i].product_id).value;
        //alert(amount);
        total += p.price * amount;
    }
    var totalDisplay = $("#totle_money");
    totalDisplay.value = total;
}

//add or minus the amount of products in shopping bag
function modifyAmount(str, id) {
    var amount = null;
    var amount_box_id = "amount_box_" + id;
    if (str == "add") {
        var t = $("#"+amount_box_id);
        var amount = parseInt(t.value);
        t.value = amount + 1;
        calculateTotalMoney();
    }
    if (str == "del") {
        var t = $("#"+amount_box_id);
        var amount = parseInt(t.value);
        if (amount > 1)
            t.value = amount - 1;
        calculateTotalMoney();
    }
}