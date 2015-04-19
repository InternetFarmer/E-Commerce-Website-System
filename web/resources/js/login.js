/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(function() {
    //cache DOM
    var userNameInput = $("#username");
    var passwordInput = $("#password");

    $("#loginButton").on("click", function() {
        var user = {
            "customer_name": userNameInput.val(),
            "password": passwordInput.val()
        };

        console.log(JSON.stringify(user));
        $.ajax({
            type: "POST",
            url: "/eBusiness/user/check",
            dataType: "json",
            contentType: "application/json",
            data: JSON.stringify(user),
            success: function(message) {
                console.log(message);
                switch (message) {
                    case -1:
                        $("#message-box").show();
                        $("#message").html("username or password error");
                        break;
                    case 0:
                        $("#message-box").show();
                        $("#message").html("internal error");
                        break;
                    case 1:
                        window.location.href = '/eBusiness/user/login?customer=' + user.customer_name + "&password=" + user.password;
                        break;
                    default:
                        $("#message-box").show();
                        $("#message").html("something is wrong! lol");
                }
            },
            error: function() {
                $("#message-box").show();
                $("#message").html("Server needs help!!>.<");
            }
        });
    });

    $("#sign-up-button").on("click", function() {
        var username = $("#create_customer_name").val();
        var password = $("#create_customer_password").val();
        var confirm = $("#create_customer_password2").val();
        var gender = $("#gender").val();
        var age = $("#age").val();
        var income = $("#income").val();
        var city = $("#city").val();
        var state = $("#state").val();
        var street = $("#street").val();
        var zipCode = $("#zipcode").val();

        if (username === "" || password === "" || confirm === "" || gender === "" || age === "" || income === "" || city === "" || state === "" || zipCode === "") {
            alert("you should fill the whole form");
        } else {
            if (password !== confirm) {
                alert("re-enter password not correct");
            } else {
                var user = {
                    "customer_name": username,
                    "password": password,
                    "gender": gender,
                    "age": age,
                    "income": income,
                    "address": {
                        "city": city,
                        "state_": state,
                        "street": street,
                        "zipCode": zipCode
                    }
                };

                console.log(user);
                $.ajax({
                    type: "POST",
                    url: "/eBusiness/rest/users/register",
                    dataType: "json",
                    contentType: "application/json",
                    data: JSON.stringify(user),
                    success: function(message) {
                        $('#myModal').modal('hide');
                        $("#message-box").show();
                        $("#message").html("Register Success");
                    },
                    error: function() {
                        $("#message-box").show();
                        $("#message").html("Server needs help!!>.<");
                    }
                });
            }
        }
    });
});