import express from 'express';
import path from 'path';

const app = express();
const PORT = process.env.PORT || 3000;

// Serve static files (like your HTML README)
app.use(express.static('kyvonthompson'));

app.listen(PORT, () => {
  console.log(`Server is running on port ${PORT}`);
});