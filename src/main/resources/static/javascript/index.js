'use strict';

const contextPath = "http://localhost:9092/";
//for Form
const RESTNAME = document.querySelector("#restName");
const LOCATION = document.querySelector("#location");
const DISH = document.querySelector("#dishName");
const RATING = document.querySelector("#ratingNo");

const CREATEALERT = document.querySelector("#createAlert");
//for Modal
const NAMEREST = document.querySelector("#nameRest");
const NAMELOC = document.querySelector("#nameLoc");
const NAMEDISH = document.querySelector("#nameDish");
const NAMERAT = document.querySelector("#nameRat");

const btnSubmit = document.querySelector("#updateButton");

//Creates table rows with Restaurant data
fetch("/getAll")
    .then(res => {
        res.json().then(
            data => {
                console.log(data);
                if (data.length > 0) {
                    var rest = "";

                    let button2 = `<button type="button" class="btn btn-danger" onclick="getConfirmation(this);">Delete</button>`;
                    let button1 = `<button type="button" onclick="Update(this)" class="btn btn-primary" data-toggle="modal" data-target="#form2">Update</button>`;

                    data.forEach((a) => {
                        rest += "<tr>";
                        rest += "<td>" + a.id + "</td>";
                        rest += "<td>" + a.restaurantName + "</td>";
                        rest += "<td>" + a.location + "</td>";
                        rest += "<td>" + a.dish + "</td>";
                        rest += "<td>" + "<b>" + a.rating + "</b>" + "<small>/100</small>" + "</td>";
                        rest += "<td>" + button1 + " " + button2 + "</td></tr>";
                    })
                    document.getElementById("data").innerHTML = rest;
                }
            }
        )
    })

// Create
const createRest = () => {

    const REST_NAME = RESTNAME.value;
    const LOCATION_VALUE = LOCATION.value;
    const DISH_VALUE = DISH.value;
    const RATING_VALUE = RATING.value;

    console.log(`${REST_NAME} ${LOCATION_VALUE} ${DISH_VALUE} ${RATING_VALUE}`);

    let obj =
    {
        restaurantName: REST_NAME,
        location: LOCATION_VALUE,
        dish: DISH_VALUE,
        rating: RATING_VALUE
    };

    //  Axios Post request
    if ((REST_NAME == "") || (LOCATION_VALUE == "") || (DISH_VALUE == "") || (0 > RATING_VALUE > 100)) {
        CREATEALERT.setAttribute("class", "alert alert-secondary");
        CREATEALERT.innerHTML = "Restaurant entity has NOT been created";
        setTimeout(() => {
            CREATEALERT.removeAttribute("class");
            CREATEALERT.innerHTML = "";
        }, 2000)
    }
    else {
        axios
            .post("/create", obj)
            .then((resp) => {
                console.log(data);
                CREATEALERT.setAttribute("class", "alert alert-secondary");
                CREATEALERT.innerHTML = "Restaurant entity has been succesfully created";
                setTimeout(() => {
                    CREATEALERT.removeAttribute("class");
                    CREATEALERT.innerHTML = "";
                    parent.window.location.reload();
                }, 3000)
            })
            .catch((err) => {
                console.error(err);
                CREATEALERT.setAttribute("class", "alert alert-secondary");
                CREATEALERT.innerHTML = "Restaurant entity not been created";
                setTimeout(() => {
                    CREATEALERT.removeAttribute("class");
                    CREATEALERT.innerHTML = "";
                }, 3000)
            })
    }
}


//Deletes elements within the table using the button
window.getConfirmation = function (ele) {
    var retVal = confirm("Are you sure you want to delete?");
    if (retVal == true) {
        var row = ele.closest('tr');
        var id = row.cells[0].textContent;
        console.log("User wants to delete: " + id);
        axios
            .delete('/remove/' + id)
            .then((response) => {
                console.log(response);
                CREATEALERT.setAttribute("class", "alert alert-secondary");
                CREATEALERT.innerHTML = "Restaurant entity has been succesfully deleted";
                setTimeout(() => {
                    CREATEALERT.removeAttribute("class");
                    CREATEALERT.innerHTML = "";
                    parent.window.location.reload();
                }, 3000)
            })
            .catch((error) => {
                console.error(error);
                CREATEALERT.setAttribute("class", "alert alert-secondary");
                CREATEALERT.innerHTML = "Restaurant entity has not been deleted";
                setTimeout(() => {
                    CREATEALERT.removeAttribute("class");
                    CREATEALERT.innerHTML = "";
                }, 3000)
            })
        return true;
    }
    else {
        console.log("User does not want to delete!");
        return false;
    }
}


function Update(ele) {
    var row = ele.closest('tr');
    let id = row.cells[0].textContent;
    let restName = row.cells[1].textContent;
    let locat = row.cells[2].textContent;
    let dis = row.cells[3].textContent;
    let rati = row.cells[4].textContent;

    console.log(id, restName, locat, dis, rati);

    NAMEREST.value = restName;
    NAMELOC.value = locat;
    NAMEDISH.value = dis;
    NAMERAT.value = rati;

    let obj =
    {
        restaurantName: restName,
        location: location,
        dish: dis,
        rating: rati
    };


    if ((REST_NAME == "") || (LOCATION_VALUE == "") || (DISH_VALUE == "") || (0 > RATING_VALUE > 100)) {
        CREATEALERT.setAttribute("class", "alert alert-secondary");
        CREATEALERT.innerHTML = "Restaurant entity has NOT been updated";
        setTimeout(() => {
            CREATEALERT.removeAttribute("class");
            CREATEALERT.innerHTML = "";
        }, 2000)
    }
    else {
        axios.
            put('/update/' + id, obj)
            .then(resp => {
                console.log(resp);
            })
            .catch(err => {
                console.error(err);
            })
    }
}
    
    





