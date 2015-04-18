$(function() {
    $("#history-table button").on("click", function() {
        var transaction_id = $(this).attr("data-id");
        $.ajax({
            type: "POST",
            url: "/eBusiness/rest/users/update/address",
            dataType: "json",
            contentType: "application/json",
            data: JSON.stringify(address_object),
            success: function() {
                location.reload();
            },
            error: function() {
                console.log(JSON.stringify(address_object));
            }
        });
    });
});