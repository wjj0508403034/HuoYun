$(document).on("click", ".tab li", function() {
  var index = $(this).index();
  $(this).parents(".tab").attr("index", index);
  if (index === 1) {
    $(".tab-0").addClass("hidden");
    $(".tab-1").removeClass("hidden");
  } else {
    $(".tab-1").addClass("hidden");
    $(".tab-0").removeClass("hidden");
  }
});

var registerController = function() {

  this.checkPhoneExist = function(phone) {
    $.when(huoyun.services.userService.checkPhoneExist(phone)).done(
        function(res) {
          if (res) {
            this.disabledSendSMSBtn();
            alert("手机号码已经被注册。");
          } else {
            this.enableSendSMSBtn();
          }
        }.bind(this));
  }

  this.checkEmailExist = function(email) {
    $.when(huoyun.services.userService.checkEmailExist(email)).done(
        function(res) {
          if (res) {
            alert("该邮箱已经被注册。");
          }
        });
  };

  this.sendRegisterSmsCode = function(phone) {
    $.when(huoyun.services.userService.sendRegisterSmsCode(phone)).done(
        function() {

        });
  };

  this.enableSendSMSBtn = function() {
    $(".send-sms-btn").removeClass("disabled");
  };

  this.disabledSendSMSBtn = function() {
    $(".send-sms-btn").addClass("disabled");
  };

  return {
    checkEmail : function(email) {
      checkEmailExist(email);
    },

    checkPhone : function(phone) {
      if (/^1[2-8][0-9]{9}$/.test(phone)) {
        checkPhoneExist(phone);
      } else {
        disabledSendSMSBtn();
      }
    },

    sendRegisterSmsCode : function(phone) {
      if (!$(".send-sms-btn").hasClass("disabled")) {
        sendRegisterSmsCode(phone);
      }
    }
  }
};

var register = registerController();