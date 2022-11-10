const fs = require('fs');
const puppeteer = require('puppeteer');
const cheerio = require("cheerio"); 
const fetch = require('node-fetch')

async function run() {
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
    var currencyTableFetched;
    fetch("https://whale-alert.io/whales") 
        .then(res => res.text())
        .then(html => {
            const $ = cheerio.load(html);
            const rows = [...$("table tr")].slice(1).map((e, i) => {
            const cells = $(e).find("td");
        return {
            currency: $(cells[0]).text().trim(),
            Know: $(cells[1]).text().trim(),
            Unknown: $(cells[2]).text().trim(),
        };
        })
        currencyTableFetched = rows;
        console.log(rows);
        // fs.writeFile('currencyTableFetched.json', JSON.stringify(rows), (err) => {
        //     if (err) throw err;
        //     console.log('object')
        // })
    });
    console.log(currencyTableFetched)
}

run();