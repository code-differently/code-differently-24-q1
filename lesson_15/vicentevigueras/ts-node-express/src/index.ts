// src/index.js
import express, { Express, Request, Response } from "express";
import dotenv from "dotenv";
import path from "path";

dotenv.config();

const app: Express = express();
const port = process.env.PORT || 3000;


// Set the directory containing your HTML and CSS files
const publicDirectoryPath = path.join(__dirname, "/workspaces/code-differently-24-q1/lesson_01/VicenteVigueras");

// Middleware to serve static files
app.use(express.static(publicDirectoryPath));

app.get("/", (req: Request, res: Response) => {
  // Send the HTML file
  res.sendFile(path.join(publicDirectoryPath, "index.html"));
});

app.listen(port, () => {
  console.log(`[server]: Server is running at http://localhost:${port}`);
});








