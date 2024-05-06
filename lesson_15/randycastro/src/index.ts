
// src/index.js
import express, { Express, Request, Response } from "express";
import dotenv from "dotenv";


dotenv.config();

const app: Express = express();
app.use(express.static('public'))
const port = process.env.PORT || 4000;


app.listen(port, () => {
  console.log(`[server]: Server is running at http://localhost:${port}`);
});