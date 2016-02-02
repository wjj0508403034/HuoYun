'use strict';

$.ajaxSetup({
  xhrFields: {
    withCredentials: true
  }
});

var huoyun = angular.module('huoyun', [
  'pascalprecht.translate', 'ui.router', 'ui.bootstrap'
]);

huoyun
  .constant('appConfig', {
    serviceUrl: "http://localhost:8080/api/"
  })
  .config(function($httpProvider) {
    $httpProvider.defaults.useXDomain = true;
    $httpProvider.defaults.headers.common['X-Requested-By'] = 'HuoYun';
    delete $httpProvider.defaults.headers.common['X-Requested-With'];
  })
  .config(function($translateProvider, appConfig) {
    $translateProvider.useStaticFilesLoader({
      prefix: 'locales/',
      suffix: '.json'
    });
    $translateProvider.preferredLanguage('zh-CN');
  }).config(function($stateProvider, $urlRouterProvider) {
    $stateProvider
      .state("home", {
        url: "/home",
        templateUrl: "views/overview/overview.html"
      })
      .state("profile", {
        url: "/profile",
        templateUrl: "views/overview/profile.html"
      });
  }).config(function($urlRouterProvider) {
    $urlRouterProvider
      .when('', '/home')
      .when('/', '/home');
  });

huoyun.controller('huoyun.controllers.mainController', ['$scope', 'userService',
  function($scope, userService) {
    userService.login("1@1.com", "1234");
  }
]);

huoyun.factory('leaveService', ["appConfig", function(appConfig) {

  return {
    getLeaveRecords: function(pageIndex) {
      var url = appConfig.serviceUrl + "leave/getLeaveRecords";
      var dtd = $.Deferred();
      $.get(url, function(result) {
        dtd.resolve(result);
      });
      return dtd.promise();
    },

    getLeaveTypes: function() {
      var url = appConfig.serviceUrl + "leave/getLeaveTypes";
      var dtd = $.Deferred();
      $.get(url, function(result) {
        dtd.resolve(result);
      });
      return dtd.promise();
    },

    create: function(data) {
      var url = appConfig.serviceUrl + "leave/create";
      var dtd = $.Deferred();
      $.post(url, JSON.stringify(data), function(result) {
        dtd.resolve(result);
      });
      return dtd.promise();
    }
  };
}]);

huoyun.factory('approveService', ["appConfig", function(appConfig) {

  return {
    getApprover: function() {
      var url = appConfig.serviceUrl + "approve/getApprover";
      var dtd = $.Deferred();
      $.get(url, function(result) {
        dtd.resolve(result);
      });
      return dtd.promise();
    }
  };
}]);

huoyun.factory('userService', ['appConfig', function(appConfig) {
  return {
    login: function(user, password) {
      var data = {
        email: user,
        password: password
      };

      var url = appConfig.serviceUrl + "user/login";
      var dtd = $.Deferred();
      $.ajax({
        type: "POST",
        url: url,
        data: JSON.stringify(data),
        contentType: "application/json",
        dataType: "json"
      }).done(function(result) {
        dtd.resolve(result);
      });
      return dtd.promise();
    }
  };
}]);

huoyun.factory('employeeService', ['appConfig', function(appConfig) {
  return {
    getProfile: function() {
      var url = appConfig.serviceUrl + "employee/my";
      var dtd = $.Deferred();
      $.get(url, function(result) {
        dtd.resolve(result);
      });
      return dtd.promise();
    },

    update: function(id, employee) {
      var url = appConfig.serviceUrl + "employee/" + id;
      var dtd = $.Deferred();
      $.ajax({
        type: "PATCH",
        url: url,
        data: JSON.stringify(employee),
        contentType: "application/json",
        dataType: "json"
      }).done(function(result) {
        dtd.resolve(result);
      });
      return dtd.promise();
    }
  };
}]);