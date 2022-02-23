//========================variables========================


const input = document.getElementById("ciudad");
const form = document.getElementById("form");
const url = 'https://arep-parcial-ivan.herokuapp.com/Consulta?q=';
//const url = 'http://localhost:35000/Consulta?q=';

var input_value="";

//========================functions========================

const submit = async (event) => {
    event.preventDefault();
    console.log(input_value);
    console.log("paseeeeeeee");
    const response = await fetch(`${url}${input_value}`, {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json',
        }
    });
    console.log("paseeeeeeee");
    console.log(response);
    console.log(response.json());
    updateHTML(response.json());
}

const updateHTML = (json)=>{
    const div = document.getElementById("div");
    const j = JSON.stringify(json);
    console.log(j);
    document.getElementById("div").innerHTML = `<h1>Tu respuesta es:</h1>${j}`
    console.log(div);
}

const updateValue = (event) =>{
    const { value } = event.target;
    input_value = value;
}

//========================EventsListeners==================

setEventsListeners();

// Function that set all the events of the DOM
function setEventsListeners() {
    input?.addEventListener('change', updateValue);
    form?.addEventListener('submit', submit);
}
