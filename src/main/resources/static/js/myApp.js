

var myBanqueApp=angular.module("myBanqueApp",['ngResource']);


myBanqueApp.service('compteService',function ($resource,$http){
    this.codeCompte="C1";
    this.compte={};
    //var compteApiResource=$resource("/comptes/"+this.codeCompte);
    //console.log(compteApiResource);
    this.getCompte=function (){
    $http.get("/comptes/"+this.codeCompte)
        .then(function(data) {
        this.compte=data;
        console.log('this.compte:'+this.compte);
    });
    };
});

myBanqueApp.controller("myBanqueController",['$scope','$log','$http',function ($scope,$log,$http){
    $scope.codeCompte=null;
    $scope.compte=null;
    $scope.operation={type:"versement",montanat:0,copmteDest:null};
    $scope.listeOperation=[];
    $scope.pageCourante=0;
    $scope.pageSize=3;
    $scope.pages=[];
    $scope.errorMessage=null;

    $scope.ChangePage=function(index){
        $log.info(typeof index);
        $scope.pageCourante=index;
        $scope.chergerOperation2();

    };

    $scope.chargerCompte=function(){
        $scope.pageCourante=0;  //intialiser la page par defaut à 0
        $http.get("/comptes/"+$scope.codeCompte)
            .then(function(response){
                $scope.compte=response.data;
                $scope.chergerOperation2();
            },function erreure(err){
            $scope.errorMessage=err.data.message;
            $log.info(err.data.message);
        });
        $log.info($scope.compte);
    };

    //save operation
    $scope.effectuerOperation=function(){
        $log.info($scope.operation.type);
        if($scope.operation.montanat) {
            $http({
                method: 'PUT',
                url: $scope.operation.type,
                data:  ($scope.operation.type!=='virement') ?"code=" + $scope.codeCompte + "&montant=" + $scope.operation.montanat + "&codeEmpl=1" : "compt1=" + $scope.codeCompte + "&compt2=" + $scope.operation.copmteDest + "&montant=" + $scope.operation.montanat + "&codeEmpl=1",
                headers: {'Content-Type': 'application/x-www-form-urlencoded'}
            }).then(function (response) {
                $scope.chargerCompte();
            },function erreure(err){
                $scope.errorMessage=err.data.message;
                $log.info(err.data.message);
            });
        }
        else {
            alert("Le montant ne doit pas etre agele zero");
        }
    };




    $scope.chergerOperation=function (){
     $http({
         method: 'GET',
         url: 'operations',
         data: "codeCompte="+$scope.codeCompte+"&page=0"+"&size=2",
         headers: {'Content-Type':'application/x-www-form-urlencoded'}
     }).then(function(response){
         $scope.listeOperation=response.data;
         $log.info('Liste Operation:'+$scope.listeOperation);
     });

    };

    $scope.chergerOperation2=function(){
        $scope.errorMessage=null;
        $http.get("/operations?codeCompte="+$scope.codeCompte+"&page="+$scope.pageCourante+"&size="+$scope.pageSize)
            .then(function(response){
                $scope.listeOperation=response.data.operations;
                $scope.pages=new Array(response.data.totalPages);
            });
        $log.info($scope.listeOperation);
        $log.info("Pages:"+$scope.pages);
    };

}]);