import express, { Express, Request, Response } from 'express';

const app: Express = express();

app.use(express.static('public'));
app.use(express.urlencoded({ extended: true }));

app.post('/search', async (req: Request, res: Response) => {
    const searchText = req.body.searchText as string;

    console.log("Server: Search for titles containing:", searchText || "<empty>");

    const apiResponse = await fetch(`http://localhost:5000/items`);
    const apiData = await apiResponse.json();

    const filteredData = apiData.items
        .filter((item: any) => item.title.toLowerCase().includes(searchText.toLowerCase()));
    
    let responseText = '<h1>Search Results</h1>';
    responseText += '<ul>';
    for (const item of filteredData) {
        responseText += `<li>${item.title}</li>`;
    }
    responseText += '</ul>';

    res.status(200).send(responseText);
});

const port = 4000;
app.listen(port, () => {
  console.log(`Server is running on http://localhost:${port}`);
});