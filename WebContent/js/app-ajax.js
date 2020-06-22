function ajaxCall(){
    var userName = jQuery("#userName").val();
    alert(userName);

    jQuery.ajax({
        url : "contact", 
        method: "POST", 
        type : "JSON", 
        data : "userName="+userName,// query parameters 1st 
        success : function(response){
            $('#ajaxGetUserServletResponse').text(response);
        }
    });


}