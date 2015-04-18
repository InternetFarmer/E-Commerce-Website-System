$(function() {
    $("#displayProductArea button").on("click", function() {
        var product_id = $(this).attr("data-id");
        console.log(product_id);
        $.ajax({
            type: "GET",
            url: "/eBusiness/rest/products/" + product_id,
            success: function(product) {
                console.log(product);
                var bagsession = sessionStorage.getItem("bag");
                if (bagsession === null | bagsession == "") {
                    sessionStorage.setItem("bag", "[" + JSON.stringify(product) + "]");
                    alert("Add to Bag Success!");
                } else {
                    var bag = JSON.parse(bagsession);
                    for (var i = 0; i < bag.length; i++) {
                        if (bag[i].product_id == product.product_id) {
                            alert("You already have this product in your bag");
                            return;
                        }
                    }
                    bag.push(product);
                    alert("Add to Bag Success!");
                    sessionStorage.setItem("bag", JSON.stringify(bag));
                }
            },
            error: function() {
                console.log("fail to load product");
            }
        });
    });
});