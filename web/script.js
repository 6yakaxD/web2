let svg = document.querySelector("svg");
const R_PIXELS = 120; // Длина от центра до точки R в пикселях (по графику это 120 пикселей от центра до метки R)

document.addEventListener("DOMContentLoaded", () => {
    svg.addEventListener("click", (event) => {

        const rChecked = document.querySelector('input[name="r"]:checked');
        if (!rChecked) {
            alert("Выберите значение R");
            return;
        }

        R = parseFloat(rChecked.value);
        let position = getMousePosition(svg, event);
        console.log("Координаты в масштабе R:", position.x, position.y);
        setPointer(position.x, position.y);

        fetch('app', {
            method: 'POST',
            headers: {'Content-Type': 'application/x-www-form-urlencoded'},
            body: `x=${position.x}&y=${position.y}&r=${R}`
        })
            .then(response => response.text())
            .then(html => {
                const resultsTable = document.getElementById('results');
                resultsTable.innerHTML += html.trim();
            })
            .catch(error => console.error('Error:', error));
    });
});

function getMousePosition(svg, event) {
    let rect = svg.getBoundingClientRect();
    
    // Центр координат - это середина SVG графика
    let centerX = rect.width / 2;
    let centerY = rect.height / 2;
    
    // Получаем координаты клика относительно центра координат
    let x = (event.clientX - rect.left - centerX) * R / R_PIXELS;
    let y = (centerY - (event.clientY - rect.top)) * R / R_PIXELS;

    return { x, y };
}

function setPointer(x, y) {
    // координаты -> обратно в пиксели для отображения точки на графике
    let pixelX = x * R_PIXELS / R + svg.clientWidth / 2;
    let pixelY = svg.clientHeight / 2 - y * R_PIXELS / R;

    svg.insertAdjacentHTML("beforeend", `<circle r="4" cx="${pixelX}" cy="${pixelY}" fill-opacity="0.7" fill="white" ></circle>`);
}



function validateForm() {
    const xInput = document.getElementById('x');
    if (!xInput.value || isNaN(xInput.value)) {
        alert("Поле X должно быть числом");
        return false;
    }
    if (xInput.value < -3 || xInput.value > 3) {
        alert("Поле X должно лежать в диапазоне от -3 до 3");
        return false;
    }

    const yChecked = document.querySelector('input[name="y"]:checked');
    if (!yChecked) {
        alert("Выберите значение Y");
        return false;
    }

    const rChecked = document.querySelector('input[name="r"]:checked');
    if (!rChecked) {
        alert("Выберите значение R");
        return false;
    }

    return true;
}


function sendData() {
    event.preventDefault();

    const x = document.getElementById('x').value;
    const y = document.querySelector('input[name="y"]:checked')?.value;
    const r = document.querySelector('input[name="r"]:checked')?.value;

    if (validateForm()) {

        fetch('app', {
            method: 'POST',
            headers: {'Content-Type': 'application/x-www-form-urlencoded'},
            body: `x=${x}&y=${y}&r=${r}`
        })
            .then(response => response.text())
            .then(html => {
                const resultsTable = document.getElementById('results');
                resultsTable.innerHTML += html.trim();
            })
            .catch(error => console.error('Error:', error));
    }
}

