const fs = require('fs');
const express = require('express');
const app = express();
const port = 3000;

const fileContent = fs.readFileSync('PoorMansAuto.java', 'utf-8');

app.get('/', (req, res) => {
	res.send(`
        <!DOCTYPE html>
        <html>
        <head>
            <link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/highlight.js/11.2.0/styles/default.min.css">
            <script src="//cdnjs.cloudflare.com/ajax/libs/highlight.js/11.2.0/highlight.min.js"></script>
            <script>hljs.highlightAll();</script>
            <style>
                body {
                    background-color: #1e1e1e;
                    color: #d4d4d4;
                    font-family: Arial, sans-serif;
                }
                pre {
                    background-color: #1e1e1e; /* Updated background color */
                    color: #d4d4d4; /* Updated text color */
                    padding: 10px;
                    overflow: auto;
                }
            </style>
        </head>
        <body>
            <pre><code class="java">${fileContent}</code></pre>
        </body>
        </html>
    `);
});

app.listen(port, () => {
	console.log(`App listening on port ${port}`);
});
