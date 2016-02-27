$(document).on("click", ".check-box-control", function() {
  $(this).toggleClass("checked");
});

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
  }
};
