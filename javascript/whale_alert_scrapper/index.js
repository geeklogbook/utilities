const fs = require('fs');
const puppeteer = require('puppeteer');

async function run() {
    const browser = await puppeteer.launch();
    const page = await browser.newPage();
    await page.goto('https://whale-alert.io/whales');

    // await page.screenshot({path: 'example.png'})

    // const html = await page.content();
    // console.log(html)

    // const title = await page.evaluate(() => document.title);
    // console.log(title)
 
    // const table = await page.evaluate(() => document.table);
    // console.log(table)

    // const links = await page.evaluate(() => Array.from(document.querySelectorAll('a'), (e) =>e.href))
    // console.log(links)

     //const currencyTable = await page.evaluate(() => Array.from(document.querySelectorAll('table tr td'), (e) =>e.innerText))
     //console.log(currencyTable)
     const currencyTable = await page.evaluate(() => 
        Array.from(document.querySelectorAll('table tbody tr'), (e) => ({
            currency: e.querySelector('i').innerText,
            Know: e.querySelector(':nth-child(2)').innerText,
            Unknown: e.querySelector(':nth-child(3)').innerText,
        }))
    );
    console.log(currencyTable)
    
    // fs.writeFile('currencyTable.json', JSON.stringify(currencyTable), (err) => {
    //     if (err) throw err;
    //     console.log('object')
    // })


    await browser.close();
}

run();