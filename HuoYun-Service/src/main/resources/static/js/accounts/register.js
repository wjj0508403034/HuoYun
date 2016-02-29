var registerController = function() {

  this.phoneRegisterValidForm = {
    phone : false,
    code : false,
    password : false,
    agreement : true
  };

  this.checkPhoneExist = function(phone) {
    $.when(huoyun.services.userService.checkPhoneExist(phone)).done(
        function(res) {
          if (res) {
            this.disabledSendSMSBtn();
            this.addErrorForInputContainer(".phone-input-container",
                "手机号码已经被注册。");
            this.phoneRegisterValidForm.phone = false;
          } else {
            this.phoneRegisterValidForm.phone = true;
            this.enableSendSMSBtn();
          }
          updateSubmitStateForPhoneRegisterForm();
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
          startCountDown();
        });
  };

  this.registerByPhone = function(phone, code, password) {
    $.when(huoyun.services.userService.registerByPhone(phone, code, password))
        .done(function() {
          window.location.href = "/login.html";
        }).fail(function(ex) {
          console.log(ex);
        });
  },

  this.enableSendSMSBtn = function() {
    $(".send-sms-btn").removeClass("disabled");
  };

  this.disabledSendSMSBtn = function() {
    $(".send-sms-btn").addClass("disabled");
  };

  this.counter = undefined;

  this.startCountDown = function() {
    disabledSendSMSBtn();
    $(".count-down").removeClass("hidden");
    var index = 60;
    this.counter = setInterval(function() {
      if (index > 0) {
        index = index - 1;
        $(".count-down").text("(" + index + ")");
      } else {
        stopCountDown();
      }
    }, 1000);
  };

  this.stopCountDown = function() {
    $(".count-down").addClass("hidden");
    if (this.counter) {
      clearInterval(this.counter);
    }
    enableSendSMSBtn();
  };

  this.addErrorForInputContainer = function(inputContainerClass, errorMessage) {
    $(inputContainerClass).addClass("error");
    $(inputContainerClass + " .error-message").text(errorMessage);
  };

  this.clearErrorForInputContainer = function(inputContainerClass) {
    $(inputContainerClass).removeClass("error");
    $(inputContainerClass + " .error-message").text("");
  };

  this.updateSubmitStateForPhoneRegisterForm = function() {
    if (phoneRegisterValidForm.phone && phoneRegisterValidForm.code
        && phoneRegisterValidForm.password && phoneRegisterValidForm.agreement) {
      $(".phone-register-submit-btn").removeClass("disabled");
    } else {
      $(".phone-register-submit-btn").addClass("disabled");
    }
  };

  return {
    checkEmail : function(email) {
      checkEmailExist(email);
    },

    checkPhone : function(phone) {
      if (/^1[2-8][0-9]{9}$/.test(phone)) {
        clearErrorForInputContainer(".phone-input-container");
        checkPhoneExist(phone);
      } else {
        if (phone) {
          addErrorForInputContainer(".phone-input-container", "手机号码格式不正确。");
        } else {
          addErrorForInputContainer(".phone-input-container", "请输入手机号码。");
        }
        disabledSendSMSBtn();
        phoneRegisterValidForm.phone = false;
        updateSubmitStateForPhoneRegisterForm();
      }
    },

    checkSmsCode : function(code) {
      if (code) {
        phoneRegisterValidForm.code = true;
      } else {
        phoneRegisterValidForm.code = false;
      }
      updateSubmitStateForPhoneRegisterForm();
    },

    checkPasswordOnPhoneForm : function(password) {
      if (password) {
        phoneRegisterValidForm.password = true;
      } else {
        phoneRegisterValidForm.password = false;
      }
      updateSubmitStateForPhoneRegisterForm();
    },

    sendRegisterSmsCode : function(phone) {
      if (!$(".send-sms-btn").hasClass("disabled")) {
        sendRegisterSmsCode(phone);
      }
    },

    agreementClicked : function($checkBox, media) {
      $checkBox.toggleClass("checked");
      var isChecked = $checkBox.hasClass("checked");
      if (media === 'phone') {
        phoneRegisterValidForm.agreement = isChecked;
        updateSubmitStateForPhoneRegisterForm();
      }
    },

    switchTab : function(index) {
      $(".tab").attr("index", index);
      if (index === 1) {
        $(".tab-0").addClass("hidden");
        $(".tab-1").removeClass("hidden");
      } else {
        $(".tab-1").addClass("hidden");
        $(".tab-0").removeClass("hidden");
      }
    },

    registerByPhone : function(phone, code, password) {
      registerByPhone(phone, code, password);
    }
  }
};

var register = registerController();