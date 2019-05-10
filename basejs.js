var app = new function () {
    this.countries = ['india', 'srilanka', 'brazil', 'new york', 'england'];

    var data = '';
    this.indexx= function(){
        alert();
        var num=["san","siva","uma","bhuva","banu"];

        var a=num.indexof("siva");
        document.getElementsById("indexofD").innerHTML=a;
    }
  



    this.FetchAll = function() {
      
        data+='<table>';
        
         for(i = 0; i < this.countries.length; i++) {
          data += '<tr>';
          data += '<td>' + this.countries[i] + '</td>';
          data += '</tr>';
         
        }
        data += '</table>';
        // alert(data);

        document.getElementById("countries").innerHTML=data;
       
    }

   
}
function insert()
{
var a=["siva","san"];
a.push("vicky");
document.getElementById("push").innerHTML=a;
alert(a);
}
// every start
var number=[1,13,2,15,2,3];
function calc(age){
    return age<=18;
}
function everyd(){
    

    document.getElementById("everys").innerHTML=number.every(calc);
}

// every end 
//filter()
var ages = [32, 33, 12, 40];

function checkAdult(age) {
  return age >= document.getElementById("ageToCheck").value;
}

function myFunction() {
  document.getElementById("filterD").innerHTML = ages.filter(checkAdult);
}

// end filter()


// entries method example
function entries(){

var fruits = ["Banana", "Orange", "Apple", "Mango"];
//var x = fruits.entries();

document.getElementById("demo").innerHTML =fruits.entries().next().value;
}
   
// for each()

// var number=[12,3,6,7,8];
// var sum=0;
// function calc(item) {
//      sum =+item;
//      ForEach.innerHTML=sum;
// }
// function callFor() {
//     document.getElementById("ForEach").innerHTML=sum;
    
// }
// var sum = 0;
// var numbers = [65, 44, 12, 4];

// function myFunction(item) {
//   sum += item;
//   demo.innerHTML = sum;
// }
   



//app.FetchAll();