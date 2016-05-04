/*$(document).on("click", ".check-box-control", function() {
  $(this).toggleClass("checked");
});*/

var huoyun = {};

huoyun.services = {};

huoyun.services.userService = {
  checkPhoneExist : function(phone) {
    var url = "/api/user/checkPhoneExist?phone=" + phone;
    var dtd = $.Deferred();
    $.post(url, function(result) {
      dtd.resolve(result);
    });
    return dtd.promise();
  },

  checkEmailExist : function(email) {
    var url = "/api/user/checkEmailExist?email=" + email;
    var dtd = $.Deferred();
    $.post(url, function(result) {
      dtd.resolve(result);
    });
    return dtd.promise();
  },

  sendRegisterSmsCode : function(phone) {
    var url = "/api/user/sendRegisterSmsCode?phone=" + phone;
    var dtd = $.Deferred();
    $.post(url, function(result) {
      dtd.resolve(result);
    });
    return dtd.promise();
  },

  registerByPhone : function(phone, code, password) {
    var url = "/api/user/registerByPhone";
    var dtd = $.Deferred();

    $.ajax({
      type : "POST",
      url : url,
      data : JSON.stringify({
        phone : phone,
        code : code,
        password : password
      }),
      contentType : "application/json",
      dataType : 'json'
    }).done(function(result) {
      dtd.resolve(result);
    }).fail(function(ex) {
      dtd.reject(ex);
    });

    return dtd.promise();
  },

  registerByEmail : function(email, password, repeatPassword) {
    var url = "/api/user/registerByEmail";
    var dtd = $.Deferred();

    $.ajax({
      type : "POST",
      url : url,
      data : JSON.stringify({
        email : email,
        password : password,
        repeatPassword : repeatPassword
      }),
      contentType : "application/json",
      dataType : 'json'
    }).done(function(result) {
      dtd.resolve(result);
    }).fail(function(ex) {
      dtd.reject(ex);
    });
  }
};
