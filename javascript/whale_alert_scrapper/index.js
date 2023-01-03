const fs = require('fs');
const puppeteer = require('puppeteer');
const cheerio = require("cheerio");
const fetch = require('node-fetch');
const { table } = require('console');

async function run() {
    // SCRAPPING
    // const browser = await puppeteer.launch();
    // const page = await browser.newPage();
    // await page.goto('https://whale-alert.io/whales');
    // const currencyTableScrapped = await page.evaluate(() => 
    //     [...document.querySelectorAll("table tbody tr")].map(e => {
    //     const cells = e.querySelectorAll("td");
    //     return {
    //         currency: cells[0].textContent.trim(),
    //         Know: cells[1].textContent.trim(),
    //         Unknown: cells[2].textContent.trim(),
    //         };
    //     })
    // );
    // console.log(currencyTableScrapped);
    // await browser.close();

    // fs.writeFile('currencyTable.json', JSON.stringify(currencyTable), (err) => {
    //     if (err) throw err;
    //     console.log('object')
    // })

    //FETCHING
    // fetch("https://whale-alert.io/whales") 
    //     .then(res => res.text())
    //     .then(html => {
    //         const $ = cheerio.load(html);
    //         const rows = [...$("table tr")].slice(1).map((e, i) => {
    //         const cells = $(e).find("td");
    //     return {
    //         currency: $(cells[0]).text().trim(),
    //         Know: $(cells[1]).text().trim(),
    //         Unknown: $(cells[2]).text().trim(),
    //     };
    //     })
    //     console.table(rows);
    // });

    // var nombre = async function (username){
    //     const url = `https://api.github.com/users/${username}`
    //     var respuesta = await fetch (url)
    //     var response = await respuesta.json();
    //     return response.login;        
    // }

    async function currencyTableFetched(url) {
        var result = await fetch(url);
        var response = await result.text()
        return response
    }

    var table = currencyTableFetched('https://whale-alert.io/whales')

    console.log(table)
}

run();