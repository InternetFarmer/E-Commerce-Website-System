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
                        alert("username or password error");
                        break;
                    case 0:
                        alert("internal error");
                        break;
                    case 1:
                        window.location.href = '/eBusiness/user/login?customer='+user.customer_name+"&password="+user.password;
                        break;
                    default:
                        alert("something is wrong! lol");
                }
            },
            error: function() {
                alert("loading error");
            }
        });
    });
});