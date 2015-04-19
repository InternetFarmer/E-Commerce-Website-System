$(function() {
    cart();

    $(".addbutton").on("click", function() {
        var product_id = $(this).attr("data-id");
        var amount_box = $("#amount_box_" + product_id);

        var amount = amount_box.val();
        amount++;
        amount_box.attr("value", amount);
        total_amount();
    });

    $('.minusbutton').on("click", function() {
        var product_id = $(this).attr("data-id");
        var amount_box = $("#amount_box_" + product_id);

        var amount = amount_box.val();
        if(amount > 1){
            amount--;
        }
        amount_box.attr("value", amount);
        total_amount();
    });

    $(".delcolumn button").on("click",function(){
        removeProduct($(this).attr("data-id"));
    });

    $("#checkout-button").on("click",function(){
        var cart = JSON.parse(sessionStorage.getItem("bag"));
        var recordList = [];
        $.each(cart,function(index,product){
            var amount_box = $("#amount_box_"+product.product_id);
            var record = {
                "product_id": product.product_id,
                "amount": amount_box.val(),
                "price": product.price
            };
            recordList.push(record);
        });
        console.log(recordList);
        $.ajax({
            type: "PUT",
            url: "/eBusiness/rest/transaction/checkout",
            dataType: "json",
            contentType: "application/json",
            data: JSON.stringify(recordList),
            success: function(transaction) {
                console.log(transaction);
                sessionStorage.setItem("bag", "");
                $("#shoppingbagarea tr").remove();
            },
            error: function() {
                console.log("fail");
            }
        });
    });
});

function cart() {
    var bag = JSON.parse(sessionStorage.getItem("bag"));
    var tbady = document.getElementById("shoppingbagarea");
    if (bag !== null) {
        for (var i = 0; i < bag.length; i++) {
            var p = bag[i];
            tbady.insertAdjacentHTML("beforeend", "<tr id='product_" + p.product_id + "'><td>" + p.product_id + "</td><td>" + p.product_name + "</td><td>" + p.price + "</td><td>" + p.category.category_name + "</td><td>" +
                "<input type='button' value='-' class='minusbutton' data-id='" + p.product_id + "'/>" +
                "<input id='amount_box_" + p.product_id + "' type='text' value='1' size='1px'/>" +
                "<input type='button' class='addbutton' value='+' data-id='" + p.product_id + "'/>" +
                "</td><td class='delcolumn'><button type='button' class='deletebutton btn btn-primary btn-sm' data-id='" + p.product_id + "'>" +
                "<span class='glyphicon glyphicon-remove'></span></button></td></tr>");
        }
    }
    total_amount();
}

function removeProduct(id) {
    var bag = JSON.parse(sessionStorage.getItem("bag"));
    for (var i = 0; i < bag.length; i++) {
        var p = bag[i];
        if (p.product_id == id) {
            bag.splice(i, 1);
            $("#product_" + id).remove();
        }
    }
    sessionStorage.setItem("bag", JSON.stringify(bag));
    total_amount();
}

function total_amount() {
    var cart = JSON.parse(sessionStorage.getItem("bag"));
    var totalDisplay = $("#totle_money");
    
    var total = 0;
    for (var i = 0; i < cart.length; i++) {
        var product = cart[i];
        var amount = $("#amount_box_" + product.product_id).val();
        total += product.price * amount;
    }
    totalDisplay.attr("value",total);
}