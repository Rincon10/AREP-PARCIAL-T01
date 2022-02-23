//========================variables========================


const input = document.getElementById("ciudad");
const form = document.getElementById("form");
const url = 'http://localhost:35000/Consulta?q=';

var input_value="";

//========================functions========================

const submit = async (event) => {
    event.preventDefault();
    console.log(input_value);
    const response = await fetch(`${url}${input_value}`, {
        method: 'GET',
        headers: new Headers({
            'Content-Type': 'application/json',
            'Access-Control-Allow-Origin': '*',
        })
    });
    return response.json();
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
