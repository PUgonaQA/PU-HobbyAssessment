'use strict';

const contextPath = "http://localhost:9092/";

const RESTNAME = document.querySelector("#restName");
const LOCATION = document.querySelector("#location");
const DISH = document.querySelector("#dishName");
const RATING = document.querySelector("#ratingNo");

const CREATEALERT = document.querySelector("#createAlert")

fetch("/getAll")
    .then(res => {
        res.json().then(
            data => {
                console.log(data);
                if (data.length > 0) {
                    var rest = "";

                    const del = "/remove/{id}"
                    const upd = "/update/{id}"

                    let button1 = "<a href=" + del + ">Delete</a>";
                    let button2 = "<a href= " + upd + ">Update</a>";

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
    if ((REST_NAME == "") || (LOCATION_VALUE == "") || (DISH_VALUE == "") || (RATING_VALUE=="") || (RATING_VALUE>100) || (RATING_VALUE<0)) {
        CREATEALERT.setAttribute("class", "alert alert-secondary");
        CREATEALERT.innerHTML = "Restaurant entity not been created";
        setTimeout(() => {
            CREATEALERT.removeAttribute("class");
            CREATEALERT.innerHTML = "";
        }, 3000)
    }
    else {
        axios
            .post("/create", obj)
            .then((resp) => {
                console.log(resp);
                CREATEALERT.setAttribute("class", "alert alert-secondary");
                CREATEALERT.innerHTML = "Restaurant entity has been succesfully created";
                setTimeout(() => {
                    CREATEALERT.removeAttribute("class");
                    CREATEALERT.innerHTML = "";
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