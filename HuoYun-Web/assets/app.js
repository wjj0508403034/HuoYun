'use strict';

angular.module('huoyun.config', ['pascalprecht.translate']);
angular.module('huoyun.directives', ['huoyun.config']);
angular.module('huoyun.services', []);
angular.module('huoyun.filters', []);
angular.module('huoyun.controllers', ['huoyun.services']);
angular.module('huoyun', [
  'huoyun.config',
  'huoyun.directives',
  'huoyun.services',
  'huoyun.filters',
  'huoyun.controllers'
]);

angular.module('huoyun.config')
  .constant('appConfig', {
    baseServiceUrl: "http://localhost:8080/",
    appBaseUrl: "http://127.0.0.1:8082/HuoYun/"
  })
  .config(function($httpProvider) {
    $httpProvider.defaults.headers.common['X-Requested-By'] = 'HuoYun';
  })
  .config(function($translateProvider, appConfig) {
    $translateProvider.useStaticFilesLoader({
      prefix: 'locales/',
      suffix: '.json'
    });
    $translateProvider.preferredLanguage('zh-CN');
  });