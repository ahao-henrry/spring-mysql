function submitRequest(){
    var inner = "";
    var requestUrl = null;
    inner = $("#jsonText").val();
    var jsoninner = {};
    try{
        jsoninner = JSON.parse(inner);
    }
    catch (err){
        var errResult = {};
        var errResultJson = "";
        errResult.code = 400;
        errResult.message = "json格式错误";
        errResult.detail = err.toString();
        errResultJson = JSON.stringify(errResult);
        $("#resulthttpDetail").text(errResultJson);
        return;
    }
    requestUrl = $("#interfaceUrl_inp").val();
    post_async(jsoninner, requestUrl, resultData, null);
}

function resultData(data){
    var strData = JSON.stringify(data);
    $("#resulthttpDetail").text(strData);
}

function post_async(params, url, callback) {
    $.ajax({
        type: 'POST',
        async: true,
        data: JSON.stringify(params),
        dataType: "json",
        contentType: "application/json",
        url: url,
        success: function (data) {
            if (callback){
                callback(data);
            }
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            if(window.console) console.error(XMLHttpRequest);
            if(window.console) console.error(textStatus);
            if(window.console) console.error(errorThrown);
            var data = {
                error:"ajax error"
            }
            if (callback){
                callback(data);
            }
        }
    });
}

function post_sync(params, url) {
    var returnData = null;
    $.ajax({
        type: 'POST',
        async: false,
        data: JSON.stringify(params),
        dataType: "json",
        contentType: "application/json",
        url: url,												
        success: function (data) {
            returnData = data;
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            if(window.console) console.error(XMLHttpRequest);
            if(window.console) console.error(textStatus);
            if(window.console) console.error(errorThrown);
            var data = {
                error:"ajax error"
            }
            if (data && callback)
                callback(data);
        }
    });
    return returnData;
}