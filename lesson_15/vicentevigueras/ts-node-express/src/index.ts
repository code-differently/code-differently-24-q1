// src/index.js
import express, { Express, Request, Response } from "express";
import dotenv from "dotenv";
import path from "path";

dotenv.config();

const app: Express = express();
const port = process.env.PORT || 3000;

app.use(express.static('/workspaces/code-differently-24-q1/lesson_01/VicenteVigueras'));
app.listen(port, () => {
  console.log(`[server]: Server is running at http://localhost:${port}`);
});
