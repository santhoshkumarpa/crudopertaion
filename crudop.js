var app = new function () {
    this.el = document.getElementById('Students');
    this.Students = ['Anuj', 'Dhanuj', 'Kanuj', 'Pranuj', 'Ranuj', 'Sanuj', 'Thanuj'];
    // alert("Welcome to the page");
    this.FetchAll = function () {
        var data = '';
        data += '<table>';
        // if (this.Students.length > 0) {
        for (i = 0; i < this.Students.length; i++) {
            data += '<tr>';
            data += '<td>' + this.Students[i] + '</td>';
            data += '<td><button onclick="app.Edit(' + i + ')">Edit</button></td>';
            data += '<td><button onclick="app.Delete(' + i + ')">Delete</button></td>';
            data += '</tr>';
            // }
        }
        data += '</table>';
        return this.el.innerHTML = data;
    };

    // this.Add = function () {
    //     el = document.getElementById('add-name');
    //     var Student = el.value;
    //     if (Student) {
    //     this.Students.push(Student);
    //     el.value = '';
    //     this.FetchAll();
    //     alert("Successfully added");
    //     }
    //     };
    this.Add =function(){
        el=document.getElementById('add-name');
        alert();
        var student=el.value;
        if(student){
            this.Students.push(student);
            el.value='';
            this.FetchAll();
            alert("successfully added");
        }

    }
    this.Edit=function(){
        var el=document.getElementById("edit-name");
    }

};
app.FetchAll();
