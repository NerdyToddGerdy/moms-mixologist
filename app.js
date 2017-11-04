console.log("app.js is working");

const app = angular.module('MixerApp', []);
let myURL = "http://www.thecocktaildb.com/api/json/v1/1/"

app.controller('MixerController', ['$http', function($http){
let controller = this;

  $http({
    method: 'GET',
    url: myURL + 'filter.php?i=Gin'
  }).then(
    function(response){
      controller.drinks = response.data;
      console.log(controller.drinks);
    }
  )

}])
