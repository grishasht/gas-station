const fuels = [
    {
        "id": 1,
        "type": "Diesel",
        "name": "EURO",
        "price": 1.12
    },
    {
        "id": 2,
        "type": "Diesel",
        "name": "ECO",
        "price": 1.23
    },
    {
        "id": 3,
        "type": "Diesel",
        "name": "ULTRA",
        "price": 1.3
    },
    {
        "id": 4,
        "type": "Gas",
        "name": "GazProm",
        "price": 5.4
    },
    {
        "id": 5,
        "type": "Gas",
        "name": "PropanTM",
        "price": 5.8
    },
    {
        "id": 6,
        "type": "Gas",
        "name": "Ukr",
        "price": 6.1
    },
    {
        "id": 7,
        "type": "Petrol",
        "name": "A-100",
        "price": 1.35
    },
    {
        "id": 8,
        "type": "Petrol",
        "name": "A-98",
        "price": 1.29
    },
    {
        "id": 9,
        "type": "Petrol",
        "name": "A-95",
        "price": 1.2
    },
    {
        "id": 10,
        "type": "Petrol",
        "name": "A-92",
        "price": 1.15
    },
    {
        "id": 11,
        "type": "Petrol",
        "name": "A-88",
        "price": 1.11
    }
]

const fuelHashTable = {};

function init() {

    fuels.forEach(fuel => {
        fuelHashTable[fuel.type] = [];
    });

    fuels.forEach(fuel => {
        fuelHashTable[fuel.type].push({
            name: fuel.name,
            price: fuel.price
        });
    });
}

function parseData() {

    let fuelTypeSelect = document.getElementById("fuel-type");
    // let fuelNameSelect = document.getElementById("fuel-name");

    Object.keys(fuelHashTable).forEach(key => {

        createNewTag("option", key, fuelTypeSelect);
    });

    changeName();


}

window.onload = function () {

    init();
    parseData();

};

function createNewTag(tag, tagTextContent, parentNode) {

    const newTag = document.createElement(tag);
    const newTagContent = document.createTextNode(tagTextContent);

    newTag.appendChild(newTagContent);

    parentNode.appendChild(newTag);

}

function changeName() {
    const selectedIndex = document.getElementById('fuel-type').selectedIndex;
    const options = document.getElementById('fuel-type').options;
    const value = options[selectedIndex].value;

    document.getElementById("fuel-value").innerHTML = value;

    clean("fuel-name");

    getNamesByType(value);
    changePrice();
}

function changePrice() {
    const selectedIndexType = document.getElementById('fuel-type').selectedIndex;
    const options = document.getElementById('fuel-type').options;
    const value = options[selectedIndexType].value;

    const fuelNameSelect = document.getElementById("fuel-name");
    const selectedIndex = fuelNameSelect.selectedIndex;
    const nameOptions = document.getElementById('fuel-name').options;
    const nameOptionValue = nameOptions[selectedIndex].value;

    getPriceByTypeAndName(value, nameOptionValue);
}

function clean(nodeId) {

    const select = document.getElementById(nodeId);
    const length = select.options.length;

    for (let i = length - 1; i >= 0; i--) {
        select.options[i] = null;
    }

}

function getNamesByType(type) {
    const fuelNameSelect = document.getElementById("fuel-name");

    fuelHashTable[type].forEach(fuel => {
        createNewTag("option", fuel.name, fuelNameSelect);
    });
}

function getPriceByTypeAndName(type, name) {
    let fuelPriceSelect = document.getElementById("fuel-price");
    fuelHashTable[type].forEach(fuel => {
        if (name === fuel.name) {
            fuelPriceSelect.innerText = fuel.price;
        }
    });

}

function buyFuelbySize() {

    //clean options
    const cleanFuelPrize = document.getElementById("end-your-fuel-price");
    cleanFuelPrize.innerHTML = '<div> </div>';
    const cleanBuy = document.getElementById("submit");
    cleanBuy.innerHTML = '<div> </div>';

    const buyForPrize = document.getElementById("buyforprice");
    buyForPrize.innerHTML = '<button type="button" onclick="buyFuelbyPrice()" class="btn btn-info" style="width: 100%">Придбати пальне за ціною </button>';

    const buyForSize = document.getElementById("buyforsize");
    buyForSize.innerHTML = '<input type="text" class="form-control" id="buy-for-size" placeholder="Вкажіть потрібний об\'єм (л)">';

    const buttonCount = document.getElementById("button-count");
    buttonCount.innerHTML = '<button type="button" onclick="countMoney()" class="btn btn-warning">Розрахувати ціну за вказаний об\'єм</button>';
}

function buyFuelbyPrice() {

    //clean options
    const cleanFuelPrize = document.getElementById("end-your-fuel-price");
    cleanFuelPrize.innerHTML = '<div> </div>';
    const cleanBuy = document.getElementById("submit");
    cleanBuy.innerHTML = '<div> </div>';

    const buyForSize = document.getElementById("buyforsize");
    buyForSize.innerHTML = '<button type="button" onclick="buyFuelbySize()" class="btn btn-primary " style="width: 100%">Придбати пальне за об\'ємом </button>';
    const buyForPrize = document.getElementById("buyforprice");
    buyForPrize.innerHTML = '<input type="text" class="form-control" id="buy-for-price" placeholder="Вкажіть бажану ціну (грн)">';

    const buttonCount = document.getElementById("button-count");
    buttonCount.innerHTML = '<button type="button" onclick="countSize()" class="btn btn-warning">Розрахувати об\'єм за вказаною ціною</button>';
}

function countMoney() {

    const inputPrice = document.getElementById("buy-for-size").value;
    const fuelPrice = document.getElementById("fuel-price");
    const currentPrice = fuelPrice.innerHTML;


    const endPrice = inputPrice * currentPrice;
    const yourFuelPrize = document.getElementById("end-your-fuel-price");
    yourFuelPrize.innerHTML = '<div> Ваша ціна пального з вибраними опціями становить <span id="your-fuel-price"></span> грн.</div>';
    document.getElementById("your-fuel-price").innerHTML = endPrice;

    const submitBuy = document.getElementById("submit");
    submitBuy.innerHTML = '<button type="button" onclick="alert()" class="btn btn-success">Підвердити покупку</button>';

}

function countSize() {

    const inputPrice = document.getElementById("buy-for-price").value;
    const fuelPrice = document.getElementById("fuel-price");
    const currentPrice = fuelPrice.innerHTML;

    const endPrice = inputPrice * currentPrice;
    const yourFuelPrize = document.getElementById("end-your-fuel-price");
    yourFuelPrize.innerHTML = '<div>Ви можете придбати <span id="your-fuel-price"></span>л пального за вибраними опціями</div>';
    document.getElementById("your-fuel-price").innerHTML = endPrice;

    const submitBuy = document.getElementById("submit");
    submitBuy.innerHTML = '<button type="button" onclick="alert()" class="btn btn-success">Підвердити покупку</button>';

}