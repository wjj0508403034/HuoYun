'use strict';

huoyun.controller('huoyun.controllers.UserProfileController', ['$scope', 'employeeService',
  function($scope, employeeService) {

    init();

    function init() {
      $.when(employeeService.getProfile())
        .done(function(data) {
          $scope.data = data;
          $scope.$apply();
        });
    }
  }
]);

huoyun.controller('huoyun.controllers.userProfileEditController', ['$scope', '$uibModalInstance',
  function($scope, dialog) {

    $scope.open = function($event) {
      $scope.isBirthdayPickerOpen = true;
    };

    function init() {
      $.when(employeeService.getProfile())
        .done(function(data) {
          $scope.data = data;
          $scope.$apply();
        });
    }
  }
]);

huoyun.controller('huoyun.controllers.LeaveHistoryController', ['$scope', '$uibModal', 'leaveService', 'userService',
  function($scope, $uibModal, leaveService, userService) {

    $scope.onPageChanged = function() {
      load($scope.page.number + 1);
    };

    $scope.create = function() {
      var dialog = $uibModal.open({
        animation: true,
        templateUrl: 'views/overview/create.html',
        controller: 'huoyun.controllers.LeaveCreateController',
        size: 'lg'
      });

      dialog.result.then(function() {

      }, function() {

      });
    };

    load(0);

    function load(pageIndex) {
      $.when(leaveService.getLeaveRecords(pageIndex))
        .done(function(result) {
          $scope.page = result;
          $scope.$apply();
        });
    }
  }
]);

huoyun.controller('huoyun.controllers.LeaveCreateController', ['$scope', '$uibModalInstance', 'leaveService', 'approveService',
  function($scope, dialog, leaveService, approveService) {
    $scope.ok = function() {
      save();
    };

    $scope.cancel = function() {
      dialog.dismiss('cancel');
    }

    init();

    function init() {
      $.when(leaveService.getLeaveTypes(), approveService.getApprover())
        .done(function(types, approver) {
          $scope.types = types;
          $scope.approver = approver;
          $scope.$apply();
        });
    }

    function save() {
      $.when(leaveService.create($scope.data))
        .done(function() {
          dialog.dismiss('ok');
        });
    }
  }
]);