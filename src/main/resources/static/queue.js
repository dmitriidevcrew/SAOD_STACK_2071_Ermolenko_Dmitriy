document.getElementById('create').addEventListener('submit', async (event) => {
    event.preventDefault();
    const capacity = document.getElementById('queueRange').value
    const options = {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        }
    };
    await fetch("http://localhost:8080/queue/create/" + capacity, options);
});

async function renderStack() {
    let html = ``;
    const options = {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json'
        }
    };
    let response = await fetch("http://localhost:8080/queue/toArray", options);
    let json = await response.json();
    json.reverse().forEach(x => {
        html += `<tr class="table-primary" id="${x}">${x}</tr>`;
    });

    document.getElementById('queueView').innerHTML = html;
}

document.getElementById('enqueueForm').addEventListener('submit', async (event) => {
    event.preventDefault();
    const item = document.getElementById('inputText').value
    const options = {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(item)
    };
    let response = await fetch("http://localhost:8080/queue/enqueue", options);
    if (response.status === 409) document.getElementById('itemOutput').innerHTML = `<label id="itemOutput">Push Exception</label>`;
    await renderStack();
});

document.getElementById('dequeueForm').addEventListener('submit', async (event) => {
    event.preventDefault();
    let html = ``;
    const options = {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json'
        }
    };
    let response = await fetch("http://localhost:8080/queue/dequeue", options);
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
    let response = await fetch("http://localhost:8080/queue/peek", options);
    if (response.status === 409) html = `<label id="itemOutput">Empty Stack Exception</label>`;
    else {
        let json = await response.json();
        html = `<label id="itemOutput">${json}</label>`;
    }
    document.getElementById('itemOutput').innerHTML = html;
    await renderStack();
});