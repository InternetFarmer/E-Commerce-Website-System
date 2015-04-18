$(function() {
    $("#history-table button").on("click", function() {
        var transaction_id = $(this).attr("data-id");
        $.ajax({
            type: "GET",
            url: "/eBusiness/rest/transaction/records/" + transaction_id,
            dataType: "json",
            contentType: "application/json",
            success: function(records) {
                console.log(records);
            },
            error: function() {
                console.log("111");
            }
        });
    });
});