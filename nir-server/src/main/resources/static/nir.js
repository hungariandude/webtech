$(document).ready(function() {
    $("#purchaseButton").click(function() {
        $.soap({
            url : 'http://localhost:8080/ws/',
            method : 'newPurchaseRequest',
            namespaceURL : 'http://spring.io/guides/gs-producing-web-service',

            data : {
                purchase : {
                    customerId : $("#customersSelect").val(),
                    productId : $("#productsSelect").val(),
                    quantity : $("#quantityInput").val()
                }
            },

            success : function(soapResponse) {
                var xmlStr = soapResponse.toString();
                var xmlDoc = $.parseXML(xmlStr);
                $xml = $(xmlDoc);
                var errorStr = $xml.find("error").text();
                if (errorStr) {
                    alert(errorStr);
                } else {
                    location.reload();
                }
            },
            error : function(soapResponse) {
                // show error
                alert("Hiba történt a szerverrel való kommunikáció közben!");
            }
        });
    });

    $.getJSON("products", function(json) {
        $("#productsTbody").jPut({
            jsonData : json,
            name : "productsTbody_template",
        });
        $("#productsSelect").jPut({
            jsonData : json,
            name : "productsSelect_template",
        });
    });
    $.getJSON("customers", function(json) {
        $("#customersSelect").jPut({
            jsonData : json,
            name : "customersSelect_template",
        });
    });
    $.getJSON("sales", function(json) {
        $("#salesTbody").jPut({
            jsonData : json,
            name : "salesTbody_template",
        });
        $(".needsDateFormatting").html(function() {
            return new Date(parseInt($(this).html())).toLocaleString();
        })
    });
});
