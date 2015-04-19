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

    $("#search-button").on("click", function() {
        //cache DOM
        var input_id = $("#product_id");
        var input_name = $("#product_name");
        var input_category = $("#product_category");
        var input_upper = $("#price_from");
        var input_down = $("#price_to");
        var display_area = $("#displayProductArea");

        //get value
        var product_id = input_id.val();
        var product_name = input_name.val();
        var product_category = input_category.val();
        var price_range_down = input_upper.val();
        var price_range_upper = input_down.val();

        console.log(product_category);
        //send request
        $.ajax({
            type: "GET",
            url: "/eBusiness/rest/products/search?product_id=" + product_id + "&product_name=" + product_name + "&product_category=" + product_category + "&price_from=" + price_range_down + "&price_to=" + price_range_upper,
            success: function(products) {
                console.log(products);
                display_area.html("");
                $.each(products, function(index, product) {
                    display_area.append("<tr id='product-" + product.product_id + "'><td>" + product.product_id + "</td><td>" + product.product_name + "</td><td>" + product.price + "</td><td>" + product.category.category_name + "</td><td>" + product.price + "</td><td><button id='button' class='btn btn-primary btn-sm' data-id='" + product.product_id + "'><span class='glyphicon glyphicon-plus'></span>Add to Bag</button></td></tr>");
                });
            },
            error: function() {
                console.log("error");
            }
        });
    });
});