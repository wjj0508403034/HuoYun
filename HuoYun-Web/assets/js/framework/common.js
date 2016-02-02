'use strict';

angular.module('huoyun.directives')
  .directive("headerbar", function(appConfig) {
    return {
      restrict: "A",
      replace: true,
      scope: true,
      templateUrl: "views/directives/headerbar.html",
      controller: function($scope, $element, $transclude, $log) {

      }
    };
  })
  .directive("footerbar", function(appConfig) {
    return {
      restrict: "A",
      replace: true,
      scope: true,
      templateUrl: "views/directives/footer.html",
      controller: function($scope, $element, $transclude, $log) {

      }
    };
  })
  .directive("sidebar", function(appConfig) {
    return {
      restrict: "A",
      replace: true,
      scope: true,
      templateUrl: "views/directives/sidebar.html",
      controller: function($scope, $element, $transclude, $log) {

      }
    };
  });