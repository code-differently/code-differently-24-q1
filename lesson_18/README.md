# Lesson 18

## Lecture Resources

* [HTML Tutorial for Beginners: HTML Crash Course](https://youtu.be/qz0aGYrrlhU) **(1 hour)** - An introduction to HTML designed for folks who've never worked with it or would like a refresher.
* [Client-side vs Server-side, Front-end vs Back-end? Beginner Explanation of JavaScript on the Web](https://youtu.be/7GRKUaQ8Spk) **(12 minutes)** - Check out this video to help understand the difference between the server-side and the client-side
* [Post From HTML Form To MongoDB Atlas | Javascript Tutorial](https://www.youtube.com/watch?v=ZhqOp1Dkuso) **(12 minutes)** - This short tutorial explores the traditional way that web pages send data back and forth with a web server.
* [POST Form Data With JavaScript Fetch API](https://youtu.be/fGYQJAlLD68) **(10 minutes)** - A tutorial on how to interact with servers from the client-side using the Fetch API in the browser via JavaScript. 

## Homework

* Go through the lecture resources to understand the basics of working with web clients and servers. Feel free to skip the HTML tutorial if you feel comfortable working with the basics already.
* Complete the [Exploring the Client and Servers](#exploring-the-client-and-servers) walkthrough. You will not need to submit a PR for this assignment.
* Continue working on [lesson_16](/lesson_16/) PR submission.

## Exploring the Client and Servers

Let's add some interactivity to a web page by using what we've learned about HTML, CSS, and JavaScript to exchange data with both a web server and an API server. For this exercise, we'll execute the same task (searching for media items by title) both on the server-side and on the client-side.

### Sending form data on button click

As demonstrated in lecture, we have a NodeJS web server implemented in TypeScript using the Express library (all files in the [webserver/](./webserver/) folder).

1. We need to start both our web server and api servers. Our API server is implemented in Java, so navigate into the [api/](./api/) folder to get that started using `gradle run` in a terminal window. It should be running on port 5000.
2. Once the API server is started, run the Node web server using NPM by executing `npm run dev` in a separate terminal, this time navigating into the [webserver/] folder. Confirm that it has started the server on port 4000.
3. Now, Open up the [public/index.html](./webserver/public/index.html) so that we can make some changes.
4. Wrap the search box and button `div` elements in a `<form>` element. Configure the `action` attribute on the form to specify `/search` as the target where we will send form data and the `method` attribute to the value `POST`.
> [!NOTE]
> Our web server that serves the HTML you're modifying is also listening for `POST` requests on the `/search` path and will [read the form data](./webserver/src/server.ts#L8) in order to figure out what text to use for search. It will call our Java-based API server to query for media items.  
5. To configure which field data will get sent with the post data, we need to add a `name` attribute to the desired elements. For now, we just need to send the search text, so configure the `name` attribute to be `searchText`.
> [!NOTE]
> Note that we're using `camelCase` for the element name attribute and not `kebab-case` as we do with the `class` attribute. This is a convention used by some projects and isn't a mandatory rule.
6. You should be able to view the page by visiting http://localhost:4000/. Try entering some text in the search box and clicking the search button. You should be redirected to the `/search` url and see results dynamically rendered.
7. Check the terminal where your web server is running. You should see messages prefixed with `Server: Search for titles containing` that confirm your requests have reached the server. 

The look of the results page is very simple as we're generating the HTML the hard way—character by character. In real life, we would use template engines that help us generate dynamic HTML and describe how we want it to change based on data. We'll discuss this more in the next lecture.

### Doing the work on the client-side instead

This time, instead of sending data to our web server, we'll keep the data in the browser and fetch what we need from the API server ourselves. The benefit to this approach is that we don't have to make a trip to the web server before calling the API server, but the downside is that we have to move that logic into our clients-side JavaScript. Figuring out which approach is the best (server-side vs. client-side) for any given project is tough and requires assessing a bunch of tradeoffs that's beyond the scope of this exercise.

1. For this part, we're going to make a single code change to the [script.js](./webserver/public/script.js#L4) file. Uncomment the code on [line 4](./webserver/public/script.js#L4) to get things wired up.
2. Refresh or browse to the main page at https://localhost:4000/. Enter some text again and click search. Notice that instead of redirecting, results appear below the search buttons.
3. Assuming you're using Google Chrome, Open the **Developer Tools** in the browser using `F12` or `Option ⌥ - Cmd ⌘ - J` on Mac. On the **Console** tab, you should see messages that start with `Client: Searching for titles containing`. Note that you may need to execute a new search in order to see the messages.

There are several things in the `script.js` file that make this demo work. Let's discuss each part.

1. First, the code in `listenForSearchButtonClick` searches for the search button using the css class selector `.search-button` and attaches an event handler that simply calls the `onSearchButtonClick` whenever the button is clicked.
2. Once the button is clicked and the function is activated, we prevent the form from submitted data to the web server by using the provided `event` parameter and calling `event.preventDefault()` to stop the normal, default button behavior.
3. Next we read the search text from the text box identify the term we want to search on.
4. We call the `performSearch` method with the search text which will, in turn, use the `fetch` API in the browser to make a web request to our API server, parse the JSON response, and filter through the results to find matching titles. The code for getting results from the API is almost [exactly the same as the code](./webserver/src/server.ts) we were running in TypeScript on our web server.
5. Lastly, since we're on the client-side, we can use JavaScript to dynamically modify the HTML to show our results. The `showResults` function demonstrates how we manipulate the DOM to add new elements to the page without going to the server. 

> [!WARNING]
> There is one very important change that needed to be made to our API server that allowed us to call it from the client-side. For security purposes, modern browsers and server typically don't just let you post data anywhere except to URL from the same origin (in this case, localhost:4000). This is done to prevent a type of security vulnerability called a cross-site scripting (XSS) that attackers use to steal information from one website using JavaScript code running from another site.
>
> To that end, one change was made to the [MediaItemsController](./api/api_app/src/main/java/com/codedifferently/lesson18/web/MediaItemsController.java#L17) to let us call the API. A new `CrossOrigin` attribute was added to the controller to let us use CORS to access the API. This lets our website code that runs from localhost:4000 call our API server at localhost:5000. In the real world, we'd want to configure only the specific hosts we want to access our API or use other means of protection to prevent arbitrary access to our API.