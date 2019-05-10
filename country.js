var app = new function () {

    var mode = "";


    this.el = document.getElementById('countries');
    this.countries = [];
    this.FetchAll = function () {
        var data = '';
        if (this.countries.length > 0) {
            for (i = 0; i < this.countries.length; i++) {
                data += '<tr>';
                data += '<td>' + this.countries[i].id + '</td>';
                data += '<td>' + this.countries[i].name + '</td>';
                data += '<td><button onclick="app.Edit(' + this.countries[i].id + ')">Edit</button></td>';
                data += '<td><button onclick="app.Delete(' + this.countries[i].id + ')">Delete</button></td>';
                data += '</tr>';
            }
        }

        return this.el.innerHTML = data;
    };
    this.saveorupdate = function () {
        if (mode == "") {
            var id = document.getElementById('id').value;
            var name = document.getElementById('name').value;

            var newCountry = new Object();

            newCountry.id = id;
            newCountry.name = name;
            this.countries.push(newCountry);
            // alert(JSON.stringify(this.countries));
            // console.log(JSON.stringify(this.countries));
            document.getElementById('id').value = "";
            document.getElementById('name').value = "";
        }
        else {
            // console.log("update");
            var updateid = document.getElementById('id').value;
            var updatename = document.getElementById('name').value;

            // var updateCountry = new Object();

            // updateCountry.id = id;
            // updateCountry.name = name;

            for (let index = 0; index < this.countries.length; index++) {

                if (this.countries[index].id == updateid) {
                    this.countries[index].name = updatename;
                }

            }

            document.getElementById('btn').innerHTML = "Add";
            mode = "";
            // alert(JSON.stringify(this.countries));
            // // console.log(JSON.stringify(this.countries));
            document.getElementById('id').value = "";
            document.getElementById('name').value = "";
        }
        app.FetchAll();
    };

    this.Edit = function (id) {
        // alert(id);
        // var a = this.countries.indexOf(id);
        mode = "edit";
        document.getElementById('btn').innerHTML = "Update";
        var foundValue = this.countries.filter(x => x.id == id);

        //   console.log(foundValue);
        // document.getElementById('test').innerHTML=foundValue;

        document.getElementById('id').value = foundValue[0].id;
        document.getElementById('name').value = foundValue[0].name;

    };
    this.Delete = function (id) {
        alert(id);
        for (let index = 0; index < this.countries.length; index++) {

            if (this.countries[index].id == id) {
                this.countries.splice(index, 1);
            }

        }
        app.FetchAll();
    };
}
app.FetchAll();




