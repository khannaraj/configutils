(function () {
    var as = angular.module('exampleApp.controllers', []);

    as.controller('MainController', function ($q, $scope, $rootScope, $http, i18n, $location) {
        var load = function () {
        };

        load();

        $scope.language = function () {
            return i18n.language;
        };
        $scope.setLanguage = function (lang) {
            i18n.setLanguage(lang);
        };
        $scope.activeWhen = function (value) {
            return value ? 'active' : '';
        };

        $scope.path = function () {
            return $location.url();
        };

        $scope.logout = function () {
            $rootScope.user = null;
            $scope.username = $scope.password = null;
            $scope.$emit('event:logoutRequest');
            $location.url('/login');
        };

    });

    as.controller('LoginController', function ($scope, $rootScope, $http, base64, $location) {

        $scope.login = function () {
            console.log('username:password @' + $scope.username + ',' + $scope.password);
            $scope.$emit('event:loginRequest', $scope.username, $scope.password);
            // $('#login').modal('hide');
        };
    });


    as.controller('ServiceDetailsController', function ($scope, $http, $routeParams, $q) {
        $scope.p = 1;
        var actionUrl = 'api/services/',
                load = function () {
                    $q.all([
                        $http.get(actionUrl + $routeParams.id)
                    ])
                            .then(function (result) {
                                $scope.service = result[0].data;
                                $scope.totalItems = result[1].data.totalElements;
                            });
                };

        load();

        $scope.checkData = function () {
        	return !$scope.service.hasOwnProperty('environments');
        };

        $scope.save = function () {
        };

    });


    as.controller('ServiceDetailsTypeController', function ($scope, $http, $routeParams, $q) {
        $scope.p = 1;
        var actionUrl = 'api/services/',
                load = function () {
                    $q.all([
                        $http.get(actionUrl + $routeParams.id + "/" + $routeParams.type)
                    ])
                            .then(function (result) {
                                $scope.service = result[0].data;
                            });
                };

        load();

        $scope.checkData = function () {
        	return !$scope.service.hasOwnProperty('environments');
        };

        $scope.save = function () {
        };

    });


    as.controller('ServicesController', function ($scope, $http, $location, i18n) {
        $scope.p = 1;
        $scope.q = '';
        $scope.statusOpt = {'label': $.i18n.prop('ALL'), 'value': 'ALL'};
        $scope.statusOpts = [
            {'label': $.i18n.prop('ALL'), 'value': 'ALL'},
            {'label': $.i18n.prop('DRAFT'), 'value': 'DRAFT'},
            {'label': $.i18n.prop('PUBLISHED'), 'value': 'PUBLISHED'}
        ];
        
        //alert('HW JS REST APP3');

        var actionUrl = 'api/services/',
                load = function () {
            	//alert('Get ' + actionUrl);
                    $http.get(actionUrl)
                            .success(function (data) {
                                $scope.services = data.serviceList;
                                $scope.totalItems = data.totalElements;
                                //alert("?? size " + data.totalElements);
                                //alert("?? content " + data.serviceList);
                                //alert("?? data " + data);
                                //alert("?? content " + $scope.services);
                            });
                };

        load();

        $scope.search = function () {
            //alert('Search');
            load();
        };

        $scope.toggleStatus = function (r) {
            //alert('Toggle');
            $scope.statusOpt = r;
        };
        
        $scope.add = function () {
            $location.path('/services/new');
        };

    });

}());