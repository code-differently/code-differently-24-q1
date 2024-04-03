"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
const express = require("express");
const dotenv = require("dotenv");

dotenv.config();
const app = express();

const port = process.env.PORT || 3000;

app.get("/", function (req, res) {
    res.send("Express + TypeScript Server");
});

app.listen(port, function () {
    console.log("[server]: Server is running at http://localhost:".concat(port));
});
