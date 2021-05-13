'use strict';

const contextPath = "http://localhost:9092/";

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




