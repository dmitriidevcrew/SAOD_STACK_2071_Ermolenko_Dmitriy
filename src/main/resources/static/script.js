document.getElementById('create').addEventListener('submit', async (event) => {
    event.preventDefault();
    const capacity = document.getElementById('stackRange').value
    const options = {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        }
    };
    await fetch("http://localhost:8080/create/" + capacity, options);
});

async function renderStack() {
    let html = ``;
    const options = {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json'
        }
    };
    let response = await fetch("http://localhost:8080/stack", options);
    let json = await response.json();
    json.reverse().forEach(x => {
        html += `<tr class="table-primary" id="${x}">${x}</tr>`;
    });

    document.getElementById('stackView').innerHTML = html;
}

document.getElementById('pushForm').addEventListener('submit', async (event) => {
    event.preventDefault();
    const item = document.getElementById('inputText').value
    const options = {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(item)
    };
    let responce = await fetch("http://localhost:8080/push", options);
    let json = await responce.json();
    if (json === "CONFLICT") document.getElementById('itemOutput').innerHTML = `<label id="itemOutput">Push Exception</label>`;
    await renderStack();
});

document.getElementById('popForm').addEventListener('submit', async (event) => {
    event.preventDefault();
    let html = ``;
    const options = {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json'
        }
    };
    let response = await fetch("http://localhost:8080/pop", options);
    if (response.status === 409) html = `<label id="itemOutput">Empty Stack Exception</label>`;
    else {
        let json = await response.json();
        html = `<label id="itemOutput">${json}</label>`;
    }
    document.getElementById('itemOutput').innerHTML = html;
    await renderStack();
});

document.getElementById('peekForm').addEventListener('submit', async (event) => {
    event.preventDefault();
    let html = ``;
    const options = {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json'
        }
    };
    let response = await fetch("http://localhost:8080/peek", options);
    if (response.status === 409) html = `<label id="itemOutput">Empty Stack Exception</label>`;
    else {
        let json = await response.json();
        html = `<label id="itemOutput">${json}</label>`;
    }
    document.getElementById('itemOutput').innerHTML = html;
    await renderStack();
});