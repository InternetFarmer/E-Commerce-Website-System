$(function(){
	$("#updateButton").on("click",function(){
		//cache DOM
		var customer_id = $("#update_customer_id");
		var customer_age = $("#update_age");
		var customer_gender = $("#update_gender");
		var customer_income = $("#update_income");


		var address_id = $("#update_address_id");
		var city = $("#update_city");
		var street = $("#update_street");
		var state = $("#update_state");
		var zipCode = $("#update_zipcode");

		var address_object = {
			"address_id": address_id.val(),
			"city": city.val(),
			"street": street.val(),
			"state_": state.val(),
			"zipCode": zipCode.val()
		};

		var customer_object = {
			"customer_id": customer_id.val(),
			"gender": customer_gender.val(),
			"age": customer_age.val(),
			"income": customer_income.val()
		};

		$.ajax({
			type: "POST",
            url: "/eBusiness/rest/users/update/address",
            dataType: "json",
            contentType: "application/json",
            data: JSON.stringify(address_object),
            success: function(){
				location.reload();
            },
            error: function(){
				console.log(JSON.stringify(address_object));
            }
		});

		$.ajax({
			type: "POST",
            url: "/eBusiness/rest/users/update",
            dataType: "json",
            contentType: "application/json",
            data: JSON.stringify(customer_object),
            success: function(){
				location.reload();
            },
            error: function(){
				console.log(JSON.stringify(address_object));
            }
		});

	});
});