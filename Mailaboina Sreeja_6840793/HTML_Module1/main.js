// ================= TASK 1 =================

console.log("Welcome to the Community Portal");

window.addEventListener("load", () => {
    alert("Page Loaded Successfully");
});

// ================= TASK 2 =================

const eventName = "Music Festival";
const eventDate = "2026-06-10";
let seats = 50;

console.log(`Event: ${eventName} | Date: ${eventDate} | Seats: ${seats}`);

// ================= TASK 3 =================

const events = [
    { name: "Music Festival", category: "Music", seats: 20 },
    { name: "Food Carnival", category: "Food", seats: 0 },
    { name: "Dance Competition", category: "Dance", seats: 15 }
];

events.forEach(event => {
    if (event.seats > 0) {
        console.log(`${event.name} Available`);
    } else {
        console.log(`${event.name} Full`);
    }
});

function safeRegister(event) {
    try {
        if (event.seats <= 0) {
            throw new Error("No Seats Available");
        }
        event.seats--;
    } catch (error) {
        console.error(error.message);
    }
}

// ================= TASK 4 =================

function addEvent(name, category) {
    events.push({
        name,
        category,
        seats: 20
    });
}

function registerUser(eventName) {
    console.log(`Registered for ${eventName}`);
}

function filterEventsByCategory(category, callback) {
    const filtered =
        events.filter(event =>
            event.category === category
        );

    callback(filtered);
}

// Closure Example

function registrationCounter() {

    let count = 0;

    return function () {

        count++;

        return count;
    };
}

const musicCounter =
    registrationCounter();

// ================= TASK 5 =================

class Event {

    constructor(name, category, seats) {

        this.name = name;
        this.category = category;
        this.seats = seats;
    }
}

Event.prototype.checkAvailability =
    function () {

        return this.seats > 0;
    };

const sampleEvent =
    new Event(
        "Workshop",
        "Education",
        25
    );

console.log(
    Object.entries(sampleEvent)
);

// ================= TASK 6 =================

events.push({
    name: "Book Fair",
    category: "Education",
    seats: 10
});

const musicEvents =
    events.filter(
        event => event.category === "Music"
    );

console.log(musicEvents);

const formattedEvents =
    events.map(
        event =>
        `Workshop on ${event.name}`
    );

console.log(formattedEvents);

// ================= TASK 7 =================

const eventContainer =
    document.querySelector(
        ".eventContainer"
    );

if (eventContainer) {

    const card =
        document.createElement("div");

    card.className =
        "eventBox";

    card.innerHTML = `
        <h3>Community Workshop</h3>
        <p>Learn new skills and network.</p>
    `;

    eventContainer.appendChild(card);
}

// ================= TASK 8 =================

document.addEventListener(
    "keydown",
    function(event){

        console.log(
            `Key Pressed: ${event.key}`
        );
    }
);

// ================= TASK 9 =================

fetch(
    "https://jsonplaceholder.typicode.com/posts"
)
.then(response =>
    response.json()
)
.then(data =>
    console.log(data.slice(0,5))
)
.catch(error =>
    console.error(error)
);

async function loadEvents(){

    try{

        const response =
            await fetch(
                "https://jsonplaceholder.typicode.com/posts"
            );

        const data =
            await response.json();

        console.log(data.slice(0,5));

    }catch(error){

        console.error(error);
    }
}

loadEvents();

// ================= TASK 10 =================

function createEvent(
    name = "Default Event"
){
    return name;
}

const {category} =
    sampleEvent;

const clonedEvents =
    [...events];

// ================= TASK 11 =================

const form =
    document.querySelector("form");

if(form){

    form.addEventListener(
        "submit",
        function(event){

            event.preventDefault();

            const name =
                form.elements[0].value;

            const email =
                form.elements[1].value;

            if(
                name === "" ||
                email === ""
            ){

                alert(
                    "Please fill all fields"
                );

                return;
            }

            console.log(
                "Form Submitted"
            );
        }
    );
}

// ================= TASK 12 =================

function sendRegistration(data){

    setTimeout(() => {

        fetch(
            "https://jsonplaceholder.typicode.com/posts",
            {
                method:"POST",

                headers:{
                    "Content-Type":"application/json"
                },

                body:JSON.stringify(data)
            }
        )
        .then(response =>
            response.json()
        )
        .then(result =>
            console.log(result)
        )
        .catch(error =>
            console.error(error)
        );

    },2000);
}

// ================= EXISTING PROJECT FUNCTIONS =================

function validatePhone(){

    let phone =
        document.getElementById(
            "phone"
        ).value;

    if(phone.length < 10){

        alert(
            "Phone number must contain 10 digits"
        );
    }
}

function showFee(){

    let fee =
        document.getElementById(
            "eventType"
        ).value;

    document.getElementById(
        "eventFee"
    ).innerHTML =
    "Selected Event Fee : ₹" + fee;
}

function showConfirmation(){

    document.getElementById(
        "outputMessage"
    ).innerHTML =
    "Registration Successful!";
}

function countCharacters(){

    let text =
        document.getElementById(
            "feedback"
        ).value;

    document.getElementById(
        "charCount"
    ).innerHTML =
    "Characters : " + text.length;
}

function enlargeImage(image){

    image.style.width =
        "350px";

    image.style.height =
        "250px";
}

function videoReady(){

    alert(
        "Video Ready To Play"
    );
}

function savePreference(){

    let selectedEvent =
        document.getElementById(
            "eventType"
        ).value;

    localStorage.setItem(
        "preferredEvent",
        selectedEvent
    );

    sessionStorage.setItem(
        "sessionEvent",
        selectedEvent
    );

    alert(
        "Preference Saved"
    );
}

window.onload = function(){

    let savedEvent =
        localStorage.getItem(
            "preferredEvent"
        );

    if(savedEvent){

        document.getElementById(
            "eventType"
        ).value =
        savedEvent;

        showFee();
    }
};

function clearPreferences(){

    localStorage.clear();

    sessionStorage.clear();

    alert(
        "Preferences Cleared"
    );
}

function findLocation(){

    navigator.geolocation.getCurrentPosition(

        function(position){

            document.getElementById(
                "location"
            ).innerHTML =

            `Latitude :
            ${position.coords.latitude}
            <br>
            Longitude :
            ${position.coords.longitude}`;
        },

        function(){

            alert(
                "Unable To Fetch Location"
            );
        }
    );
}